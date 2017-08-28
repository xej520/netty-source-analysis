package cn.akka.ParentChildActor

import akka.actor.{Actor, ActorSystem, PoisonPill, Props}
import akka.actor.Actor.Receive

/**
  * Created by erjun on 2017/4/4.
  */

case class CreateChild(name: String)
case class Name(name: String)

class Child extends Actor {
	var name = "No name"
	override def postStop(): Unit = {
		println(s"D'oh! They killed me ($name):${self.path}")
	}

	override def receive: Receive = {
		case Name(name) => {
			this.name = name
		}

		case _ => println(s"Child $name got message.")
	}

}

class Parent extends Actor {
	override def receive: Receive = {
		case CreateChild(name) => {
			//parent create a new Child here
			println(s"Parent about to create Child ($name)...")
			val child = context.actorOf(Props[Child], name = s"$name")
			child ! Name(name)
		}
		case _ => println(s"Parent got some other message")

	}
}

object ParentChildDemo extends App{
	val actorSystem = ActorSystem("ParentChild")
	val parent = actorSystem.actorOf(Props[Parent], name = "Parent")

	//send message to Parent to create to child actors
	parent ! CreateChild("xiaoming")
	parent ! CreateChild("laoxing")
	Thread.sleep(500)

	//lookup Xiaoming the kill it
	println("Sending Xiaoming a PoisonPill...")
	val xiaoming = actorSystem.actorSelection("/user/Parent/xiaoming")
	xiaoming ! PoisonPill
	println("Xiaoming was killed")

	Thread.sleep(500)
	actorSystem.shutdown()

}
