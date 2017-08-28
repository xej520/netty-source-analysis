package com.b2_0.function

/**
  * Created by erjun on 2017/2/15.
  * 定义一个函数，将此函数，赋值给一个变量
  * 就是起了一个别名吧
  */

object Function2Val {
	def main(args: Array[String]): Unit = {
		//返回必须有返回值，才能赋值给  变量，否则是不可以赋值给变量的
		//将函数赋值给一个变量，如下所示  函数名 _   中间是有空格的，要看清楚啊
		val say = sayHello _
		println(say("laoxing"))
	}
	//定义一个函数，函数可以独立存在的，
	def sayHello(name: String): String = {
		println("===========")
		"hello, spark, " + name
	}
}
