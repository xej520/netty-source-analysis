package com.xej.learning.seq

/**
  * Created by erjun on 2017/8/24.
  */
object SeqTest2 {
	def main(args: Array[String]): Unit = {
		val map1 = Array(2,3,4,5)
		val map2 = Array(2,3,7,4)
		val map3 = Array(9,8,0,1)
		val seq = Seq(map1,map2,map3).flatten
		seq.foreach(x => print(x + " "))
		println("-------------------")
		//take是，取出集合里的前n个元素，这里是取出前3个元素
		seq.take(3).foreach(x => print(x + " "))

		println("-------------------")
		val seq2 = Seq(map1,map2,map3)
		seq2.foreach(println)
	}
}
