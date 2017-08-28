package com.b3_0.collections

/**
  * Created by erjun on 2017/2/15.
  * 集合的函数式编程
  */
object Collection_Function {
	def main(args: Array[String]): Unit = {
		List("Lio","Jen","Peter","Jack").map("name is " + _).foreach(println(_))



	}
}
