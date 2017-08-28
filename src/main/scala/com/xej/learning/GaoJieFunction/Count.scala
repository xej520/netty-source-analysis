package com.xej.learning.GaoJieFunction

/**
  * Created by erjun on 2017/8/9.
  */
object Count {
	def main(args: Array[String]): Unit = {
		val a = List(1,2,3,4,5)
		//count 是说，满足条件的个数，这里是指，集合a里元素大于3个个数
		println(a.count(_ > 3)) //2
	}
}
