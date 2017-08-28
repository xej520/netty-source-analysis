package com.b4_0.fanxing

/**
  * Created by erjun on 2017/2/15.
  * 	下边界测试
  */
private[fanxing] class Person
private[fanxing] class Master extends Person
private[fanxing] class Boy extends Master
private[fanxing] class Girl extends Boy

private[fanxing] class FanDian[T >: Master] (p1: T, p2: T)

private[fanxing] class Worker

object DownBounds {
	def main(args: Array[String]): Unit = {
		val person = new Person
		val master = new Master
		val boy = new Boy
		val girl = new Girl
		val worker = new Worker

		sayHello(girl)
		sayHello(boy)
		sayHello(master)
		sayHello(person)
//		sayHello(worker)

		val f1 = new FanDian[Person](girl,master)
		println(f1.toString)
	}

	def sayHello[T <: Person](p: T): Unit = {
		println("=================")
	}
}










