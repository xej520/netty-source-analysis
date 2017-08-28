package com.a5_0.AbstractClass

/**
  * Created by erjun on 2017/2/13.
  * 测试object 来继承  抽象类
  */
//定义一个抽象类
abstract class Person(var name:String , var age: Int){
	def sayHello(name: String): Unit
}


object Student extends Person("spark", 23){
	override def sayHello(name: String): Unit = {
		println(name + " ----> " + 23)
		say()
	}

	def say(): Unit = {
		println(name + " ---> " + age)
	}
}


