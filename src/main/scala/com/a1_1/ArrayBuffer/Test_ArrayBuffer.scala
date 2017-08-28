package com.a1_1.ArrayBuffer
import  scala.collection.mutable.ArrayBuffer
/**
  * Created by erjun on 2017/2/13.
  */
object Test_ArrayBuffer {
	def main(args: Array[String]) : Unit = {
		//创建一个ArrayBuffer, 并添加一个值10
		val arr1 = ArrayBuffer(10)
		//往arr1里添加一个元素
		arr1 += 3
		arr1.foreach(println(_))
		val names = new ArrayBuffer[String]()
		names += "laoxing"
		//一次性添加多个元素
		names ++= ArrayBuffer("laoxing", "spark","hive")
		println("==========================")
		names.foreach(i => print(i + " "))
		println("==========开始遍历==============")
		for(ele <- 0 until(names.length, 2)) {
			println(names(ele))
		}
		println("==========倒序遍历==============")
		//实现倒序输出
		for(ele <- (0 until(names.length, 2)).reverse) {
			println(names(ele))
		}
		println("==========增强for循环==============")
		//下面使用增强for循环
		for(ele <- names) {
			println(ele)
		}

	}
}














