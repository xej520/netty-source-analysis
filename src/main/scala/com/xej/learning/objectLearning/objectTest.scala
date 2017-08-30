package com.xej.learning.objectLearning

/**
  * objectLearning 测试
  */
private[objectLearning] class Kafka(val name: String){
	//目的:测试多次调用object时，其主构造方法调用几次
	def sayHello(): Unit ={
		objectTest.name
		objectTest.name
		objectTest.name
		println("--------------------")
	}
}
object objectTest {
	val name = "spark"
	println("----object----主构造器--------")
	def main(args: Array[String]): Unit = {
		new Kafka("spark").sayHello()
	}
}
