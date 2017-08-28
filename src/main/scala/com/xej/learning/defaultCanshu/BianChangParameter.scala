package com.xej.learning.defaultCanshu

/**
  * Created by erjun on 2017/8/5.
  */
object BianChangParameter extends App{

	val s = sum2(1 to 5: _*)

	println("=====:\t" + s)

	def sum2(nums:Int*): Int = {
		if (nums.length == 0) 0
		else nums.head + sum2(nums.tail:_*)
	}
}
