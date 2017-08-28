package com.xej.learning.classAndObjectAndtrait.Class

/**
  * Created by erjun on 2017/8/23.
  */
class Kafka2{
	def method(name:String): Unit ={
		println("---->1、定义在类里的def----称之为----方法------")
		println("---->2、只能通过---类---或者---对象---来访问----")
	}
}
object FunTest {
	def main(args: Array[String]): Unit = {
		val kafka = new Kafka2
		kafka.method("kafka")  //通过对象来调用方法
		fun("函数")		//函数，可以直接调用的，脱离对象的，这一点很牛
	}

	def fun(name: String): Unit = {
		println("---->1、在这里定义的def----称之为----函数------")
		println("---->2、不依赖其他对象---可以直接调用的-")
	}
}
