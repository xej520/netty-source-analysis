package com.xej.learning.GaoJieFunction

/**
  * Created by erjun on 2017/8/9.
  */
object PartitionTest {
	def main(args: Array[String]): Unit = {
		val (a, b) = List(1,3,2,4,5).partition(_ > 2)
		a.foreach(println(_))
		println(a.forall(_ > 2))
	}
}
