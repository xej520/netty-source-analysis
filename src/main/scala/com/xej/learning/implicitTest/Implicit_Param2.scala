package com.xej.learning.implicitTest

/**
  * Created by erjun on 2017/8/22.
  * 此隐式参数的作用域在，伴生对象里
  */
private[implicitTest] class Kafka(val name: String)
private[implicitTest] class Flume(val name: String)
private[implicitTest] object Flume{
	implicit val flumeName = new Flume("flume")
}

object Implicit_Param2 {
	def main(args: Array[String]): Unit = {
		val kafka = new Kafka("kafka")
		val kafka2 = new Kafka("kafka2")
		val kafka3 = new Kafka("kafka3")
		sayHello(kafka)
		sayHello(kafka2)
		sayHello(kafka3)

	}
	def sayHello(kafka: Kafka)(implicit flume: Flume): Unit ={
		println("--->kafka:\t" + kafka.name + ";\tflume:\t" + flume.name)
	}
}
