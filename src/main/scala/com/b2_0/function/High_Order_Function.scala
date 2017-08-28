package com.b2_0.function

/**
  * Created by erjun on 2017/2/15.
  * 	测试 高阶函数
  * 			1、接收 普通函数
  * 			2、接收 匿名函数
  */
object High_Order_Function {
	def main(args: Array[String]): Unit = {
		//高阶函数，调用，匿名函数，将匿名函数赋值给变量，
		greeting(sayHello, "hive")

		//高阶函数，调用， 匿名函数，直接将匿名函数，传递进入，不需要
		//赋值给变量
		greeting((name: String) => {println("I‘m spark " + name)}, "laoxing")

		//高阶函数，调用，非匿名函数,
		greeting(sayHelloFunc, "laoxing")

	}

	//定义一个匿名函数， 并将匿名函数，赋值给一个 变量
	val sayHelloFunc = (name: String) => {
		println("Hello, " + name)
	}
	//定义一个 非匿名函数
	def sayHello(name: String): Unit = {
		println("Hello world , " + name)
	}
	//定义一个高阶函数
	def greeting(func: (String) => Unit, name: String): Unit = {
		func(name)
	}
}

















