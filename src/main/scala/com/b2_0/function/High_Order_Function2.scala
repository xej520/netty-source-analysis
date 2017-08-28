package com.b2_0.function

/**
  * Created by erjun on 2017/2/15.
  * 高阶函数，
  * 	将  函数  作为  返回值返回
  */
object High_Order_Function2 {
	def main(args: Array[String]): Unit = {
		//第一种调用方式
		greeting("msg: hello, spark")("laoxing")
		//
		val m1 = greeting("msg: hello, hadoop")
		m1("xej")

		greeting2("Flink")
		greeting3("Hive")
	}
	//高阶函数，返回的返回值是  匿名函数
	def greeting(msg: String) = (name: String) => println(name + " ----> " + msg)

	//首先，定义一个匿名函数，并赋值给某个变量，然后，将变量，作为函数体
	val aFunction = (name: String) => println("------->\t" + name)
	def greeting2 = aFunction
	def greeting3(name: String) = aFunction(name)


}
