package com.xej.learning.array

/**
  * Created by erjun on 2017/8/5.
  */
object ArrayTest001 {
	def main(args: Array[String]): Unit = {

		val b = new Array[Int](10);
		val b1: Array[Int] = new Array[Int](10);
		val placeName = Array("beijing","shanghai","guangzhou")

		//初始化b数组
		b(0) = 3
		b(1) = 4
		b(2) = 5
		//打印数组b的内容
		b.foreach(x => print(x + " ")) //3 4 5 0 0 0 0 0 0 0
		placeName.foreach(x => print(x + " "))// beijing shanghai guangzhou

		println("---->:\t" + b(2))//与java不同，是通过  小括号   哦

		val a: Array[Int] = Array[Int](2,10,1);
		println(a(0))
		Option(b.apply(0)).foreach(print(_))
	}
}
