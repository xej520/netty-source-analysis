package com.a1_0.array

/**
  * Created by erjun on 2017/2/13.
  */
object Test_Array {
	def main(args: Array[String]) : Unit = {
		val b = new Array[Int](10)//默认值都是0哦
		b(2) = 4
		val a = Array(10,1)
		println(a.apply(0))
		b.foreach(println(_))
		println("======================")
	}
}















