package cn.akka.pingpong

import akka.actor.{ActorSystem, Props}

/**
  * Created by erjun on 2017/4/4.
  */
object PingPong extends App{
	val system = ActorSystem("PingPongTest")
	val pongActor = system.actorOf(Props[Pong], name = "pong")
	val pingActor = system.actorOf(Props(new Ping(pongActor)), name = "ping")
	pingActor ! StartMessage

}
