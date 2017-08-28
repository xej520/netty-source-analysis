package com.xej.learning.keyword

import scala.util.{Failure, Success, Try}

/**
  * Created by erjun on 2017/8/16.
  */

object Test_004_try {
	def main(args: Array[String]): Unit = {
		println("--------->\t" + divideBy(4,2).get)
		println("--------->\t" + divideBy(4,0).getOrElse(0))

		divideBy(6,2) match {
			case Success(i) => println(s"Success, value is : $i")
			case Failure(i) => println(s"Failed, Message is : $i")
		}

		divideBy(6,0) match {
			case Success(i) => println(s"Success, value is : $i")
			case Failure(i) => println(s"Failed, Message is : $i")
		}
	}

	def divideBy(x: Int, y: Int): Try[Int] ={
		Try(x / y)
	}
}
