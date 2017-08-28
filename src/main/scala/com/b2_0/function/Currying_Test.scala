package com.b2_0.function

/**
  * Created by erjun on 2017/2/15.
  */
object Currying_Test {
	def main(args: Array[String]): Unit = {
		println("---> \t" + sum(3,4))
		println("---> \t" + sum2(4))
		println("---> \t" + sum2(4)(1))
		println("---> \t" + sum3(4)(1))
//		println("---> \t" + sum3(4))
	}

	def sum(a: Int, b: Int) = {	a + b }
	//这种形式，调用时，传入一个参数是不会报错的
	def sum2(a: Int) = (b: Int) => a + b
	//这种形式，调用时，仅仅传入一个参数是会报错的
	def sum3(a: Int)(b: Int) = a + b
}
