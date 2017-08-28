package com.b4_0.fanxing

/**
  * Created by erjun on 2017/2/15.
  */
object FanXingFunction_Test {
	def main(args: Array[String]): Unit = {
		getCard(2)
		//自动类型 推断
		getCard("00001")
		getCard[String]("00001")
	}

	def getCard[T](context: T): Unit = {
		if (context.isInstanceOf[Int]) {
			println("card ID is " + context)
		} else if (context.isInstanceOf[String]) {
			println("card: this is your card " + context)
		} else {
			println("card: ----> " + context)
		}
	}

}
