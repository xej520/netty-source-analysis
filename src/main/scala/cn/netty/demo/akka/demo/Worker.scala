package cn.netty.demo.akka.demo

import java.util.UUID

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import org.hyperic.sigar.{Mem, Sigar}

/**
  * Created by erjun on 2017/3/18.
  */
class Worker (val host: String, val port: Int) extends Actor{

	val workerId: String = UUID.randomUUID().toString

	var master: ActorSelection = _

	//worker 一启动，就立马向maser注册自己的信息
	override def preStart(): Unit = {
		println(s"worker 1 [$host: $port] starting ...")

		master = context.actorSelection("akka.tcp://MasterSystem@127.0.0.1:9900/user/Master")

		master ! WorkderRegister(workerId, host, port, 256, 2)
		println(s"workerID---->$workerId")
	}

	override def receive: Receive = {
		case RegisterBack(masterId) => {
			import scala.concurrent.duration._
			import scala.concurrent.ExecutionContext.Implicits.global
			//每个2秒钟，就要向自己发送消息WorkerHearBeat，
			context.system.scheduler.schedule(0 millis, 2000 millis, self, WorkerHearBeat)
		}
		//这个消息的作用，就是，向master发送消息，就是心跳检测机制
		case WorkerHearBeat =>  {
			val memFree = Runtime.getRuntime.freeMemory() / 1024 / 1024
			val cpuFreeNum = Runtime.getRuntime.availableProcessors
			println("可用内存：\t" + memFree + "M")
			println("可用cpu核数:\t" + cpuFreeNum)
			master ! HeartBeat(workerId, System.currentTimeMillis(), memFree, cpuFreeNum)
		}

		case _=> println("worker received mismatched msg")

	}
}

object Worker {
	def apply(host: String, port: Int): Worker = new Worker(host, port)

	def main(args: Array[String]): Unit = {

		val host = "127.0.0.1"
		val port = 9912
		val confStr =
			s"""
				akka.actor.provider = "akka.remote.RemoteActorRefProvider"
						  |                      |akka.remote.netty.tcp.hostname = "$host"
						  |                      |akka.remote.netty.tcp.port = "$port"""" stripMargin
		val conf = ConfigFactory.parseString(confStr)
		val workerSystem1 = ActorSystem("Worker1", conf)
		workerSystem1.actorOf(Props(Worker(host, port)), "Worker1")
		workerSystem1.awaitTermination()

	}

}















