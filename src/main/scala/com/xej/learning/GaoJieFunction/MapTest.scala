package com.xej.learning.GaoJieFunction

/**
  * Created by erjun on 2017/8/23.
  * 高阶函数map测试
  */
object MapTest {
	def main(args: Array[String]): Unit = {
		val arr = Array(3,5,4,10)
		val result = arr.map(_ > 5)
		result.foreach(x => print(x + " "))

		val mapTest = Map(1->"hive", 3->"spark", 5->"hadoop", 4->"mesos")
		val arr2 = Array(1,4)
		val arr3 = mapTest -- arr2
		arr3.foreach(println)

		arr3.to[Seq].foreach(println)
	}
}
