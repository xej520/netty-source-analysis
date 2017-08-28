package com.b1_0.trait_lazy_test

/**
  * Created by erjun on 2017/2/14.
  * 为某个实例对象，动态增加 trait
  */
private[trait_lazy_test] trait Logger {
	//定义一个具体的方法，不然， 子类，还的去实现
	def log(msg: String) {}
}

private[trait_lazy_test] trait MyLogger extends Logger{
	override //定义一个具体的方法，不然， 子类，还的去实现
	def log(msg: String): Unit = println("log:\t" + msg)
}

private[trait_lazy_test] class Person{
	def show(): Unit = {
		println("========Person========")
	}
}

private[trait_lazy_test] class Student extends MyLogger {
	def doShow(): Unit = {
		println("===========Student=========")
		log("------>Student<--------")
	}
}


object Trait_Dynamic {
	def main(args: Array[String]): Unit = {
		//首先创建一个 不带 trait的接口的
		val person = new Person
		person.show()
		//person.log
		println("===========================================")
		val student = new Student
		student.doShow()
		println("-------------------------------------------")
		val person2 = new Person with Logger
		person2.show()
		person2.log("---> 我是动态增加的triat")

	}
}








