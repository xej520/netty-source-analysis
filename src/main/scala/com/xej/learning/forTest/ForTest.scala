package com.xej.learning.forTest

/**
  * Created by erjun on 2017/8/23.
  */
class ForTest{
	val arr = List(1,2,3,4,5,6,7)
	//for循环里，可以添加多个条件
	val deployment = for{ele <- arr
		if ele + 2 > 3
		if ele % 2 == 1
	} yield ele
}
object ForTest {
	def main(args: Array[String]): Unit = {
		val fortest = new ForTest
		fortest.deployment.foreach(println(_ ))
	}
}
