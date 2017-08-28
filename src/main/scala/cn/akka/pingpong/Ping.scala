package cn.akka.pingpong

import akka.actor.{Actor, ActorRef}

/**
  * Created by erjun on 2017/4/4.
  */
case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage

class Ping(pong: ActorRef) extends Actor{
	var count = 0
	def incrementAndPrint: Unit = {
		count += 1
		println(s"$count:ping")
	}

	override def preStart(): Unit = {
		println("----Ping---")
	}

	def receive = {
		case StartMessage => {
			incrementAndPrint
			pong ! PongMessage
		}

		case PingMessage => {
			incrementAndPrint
			if (count > 99) {
				sender ! StopMessage
				println("ping stopped")
				context.stop(self)
			} else {
				sender ! PongMessage
			}
		}

		case _=> println("Ping got unexpected information")
	}


}

class Pong extends Actor {
	var count = 0

	override def preStart(): Unit = {
		println("----Pong---")
	}

	def receive = {
		case StopMessage =>{
			println("pong stopped")
			context.stop(self)
		}
		case PongMessage => {
			count += 1
			println(s"$count:pong")
			sender ! PingMessage
		}

		case _ => println("Pong got unexpected information")
	}
}


