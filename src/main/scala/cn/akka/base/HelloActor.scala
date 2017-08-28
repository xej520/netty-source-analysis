package cn.akka.base

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.Actor.Receive

/**
  * Created by erjun on 2017/4/4.
  */
class HelloActor() extends Actor{
	def receive = {
		case "hello" => println("hello back to you")
		case _ => println("huh?")
	}

}

object Test1_HelloActor extends App{
	//actor need an ActorSystem
	val system = ActorSystem("HelloSystem")
	//create and start the actor
	//当你调用ActorSystem的actorOf方法时，将创建并返回一个ActorRef的实例
	val helloActor = system.actorOf(Props[HelloActor],name="helloActor")
	//send two message
	helloActor ! "hello"
	helloActor ! "what"
	//shutdown the actor system
	system.shutdown()


}

