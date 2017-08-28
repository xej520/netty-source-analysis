package com.xej.learning.GaoJieFunction

/**
  * Created by erjun on 2017/8/7.
  */
object GFunctionTest002 {
	def main(args: Array[String]): Unit = {
		println(triple(2 + _, 3))
		println(triple(x =>2 + x, 3))
		println(triple(x =>2 * x, 3))
	}

	def triple(func:Int => Int, num: Int): String = {
		func(num) + " is OK!!!"
	}
}
