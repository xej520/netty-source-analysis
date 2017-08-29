package com.xej.learning.map

/**
  * Created by erjun on 2017/8/29.
  */
object MapTest {
	def main(args: Array[String]): Unit = {
		val map1 = Map("key1" -> "spark", "key2" -> "hadoop")
		map1.foreach(x => println(x._1 + " ---> " + x._2))
		map1.updated("key1", "mesos").foreach(x => println(x._1 + " ====> " + x._2))
	}
}
