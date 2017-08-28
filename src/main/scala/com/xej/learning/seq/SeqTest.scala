package com.xej.learning.seq

/**
  * Created by erjun on 2017/8/23.
  */
object SeqTest {
	def main(args: Array[String]): Unit = {
		val steps = Seq.newBuilder[String]
		steps += "spark"
		steps += "mesos"
		//对Seq集合进行遍历
		steps.result().foreach(println(_))

	}
}
