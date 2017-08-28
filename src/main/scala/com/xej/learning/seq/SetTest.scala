package com.xej.learning.seq

/**
  * Created by erjun on 2017/8/24.
  */
object SetTest {
	def main(args: Array[String]): Unit = {
		val set1 = Set(13,45)
		val set2 = Set(34,45)
		//
		set1.intersect(set2).foreach(println)
	}
}
