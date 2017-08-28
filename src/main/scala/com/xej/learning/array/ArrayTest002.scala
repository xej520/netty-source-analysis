package com.xej.learning.array

import scala.collection.mutable.ArrayBuffer

/**
  * Created by erjun on 2017/8/5.
  */
object ArrayTest002 {
	def main(args: Array[String]): Unit = {
		val array001 = ArrayBuffer(10)
		array001 += 2
//		array001.foreach(x => print(x + " "))
//		print("---------------------------------\n")

		import  Array._
		//range()方法生成一个区间范围内数组；
		//可以生成递增，或者递减数组
		//第一个参数，初始值
		//第二个参数，最大值
		//第三个参数，间隔;  大于0，表示递增数组
		//小于0，表示递减数组
		val test001 = range(1,20,2)//递增数组
		Option(test001) match {
			case Some(x) => x.foreach(y => print(y + " "))
			case None => println("--------------------")
		}
		println("\n--------------------")
		val test002 = range(20,1,-2)//递减数组
		Option(test002) match {
			case Some(x) => x.foreach(y => print(y + " "))
			case None => println("--------------------")
		}
	}
}
