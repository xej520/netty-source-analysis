package com.xej.learning.GaoJieFunction

import scala.concurrent.Future

/**
  * Created by erjun on 2017/8/24.
  */
object FoldTest {
	def main(args: Array[String]): Unit = {
		val numbers = List(5,4,8,6,2)
		//
		val num = numbers.fold(0){(z,i) => z + i}
		println("---->:\t" + num)
		println("---->:\t" + Future.successful(numbers).value)


	}
}
