package com.a9_0.protected_test

/**
  * Created by erjun on 2017/2/14.
  */
private[protected_test] trait Father3
private[a9_0] sealed trait Person3
private[a9_0] case class Student3(name: String) extends Person3
private[protected_test] case class Worker3(name: String) extends Person3

private[a9_0] case class Professor3(name: String) extends Person3
//只能在protected_test 包内，进行创建Teacher3对象
private[protected_test] class Teacher3 {
	println("======Teacher======")
	val b = new Animal3
}
//只能在a9_0 包内，创建Animal3对象
private[a9_0] class Animal3 {
	println("==========animal3=============")
}

object Private_test {
	def main(args: Array[String]): Unit = {
		val a = new Animal3
	}
}


