package cn.netty.demo.akka.demo

import java.util.UUID

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.Actor.Receive
import com.typesafe.config.ConfigFactory

/**
  * Created by erjun on 2017/3/18.
  */
class Master (val host: String, val port: Int) extends Actor{
	val LOST_WORKER = 10000
	val masterId: String = UUID.randomUUID().toString
	val workerMap = scala.collection.mutable.HashMap[String, WorkerInfo]()

	/**
	  * 只要一运行，就会首先，运行这里的
	  */
	override def preStart(): Unit = {
		println("master  starting ...")

		import scala.concurrent.duration._
		import scala.concurrent.ExecutionContext.Implicits.global
		//调度器，
		/**
		  * self表示，接收消息方
		  * workerCheck 表示 发送的是什么类型的消息
		  */
		context.system.scheduler.schedule(0 millis, 5000 millis, self, WorkerCheck)
	}

	override def receive: Receive = {
		case HeartBeat(workerId: String, workerBeatTime: Long, memory: Long, cpuFree: Int) => {
			println(s"HeartBeat:--->\nworkerId:\t$workerId")
			workerMap.get(workerId).get.lastHeartBeatTime = workerBeatTime
		}

		case WorkerCheck => {
			workerMap.filter(System.currentTimeMillis() - _._2.lastHeartBeatTime > LOST_WORKER)
						    .foreach(workerMap -= _._1)
			println("-----------------------------------------------------")
//			workerMap.foreach{
//				println(_)
//			}

			for(key <- workerMap.keySet) {
				println("\thost:\t" + workerMap(key).host)
				println("\tport:\t" + workerMap(key).port)
				println("\tmem:\t" + workerMap(key).memory)
				println("\tcore:\t" + workerMap(key).core)
				println("\tstartTime:\t" + workerMap(key).startTime)
			}

			println("++++++++++++++++++++++++++++++++++++++++++++++++++++++")
		}

		case WorkderRegister(workerId, host, port, memory, core) => {
			if (!workerMap.contains(workerId)) {
				val worker = WorkerInfo(workerId, host, port, memory, core, System.currentTimeMillis)
				workerMap(workerId) = worker
				println(s"----------------->$workerMap", workerMap.get(workerId).toString)
				//sender的作用，就是，谁向我发送消息，我就向谁回消息
				sender ! RegisterBack(masterId)
			}
		}
		case _ => println("master received mismathed msg")

	}
}

object Master {
	def apply(host: String, port: Int) : Master = new Master(host, port)

	def main(args: Array[String]): Unit = {
		val host = "127.0.0.1"
		val port = 9900
		val confStr = s""" akka.actor.provider = "akka.remote.RemoteActorRefProvider"
						  |akka.remote.netty.tcp.hostname = "$host"
						  |akka.remote.netty.tcp.port = "$port"""" stripMargin

		val conf = ConfigFactory.parseString(confStr)
		val masterSystem = ActorSystem.apply("MasterSystem", conf)
		val master = masterSystem.actorOf(Props(Master(host, port)), "Master")

		masterSystem.awaitTermination()

	}
}


















