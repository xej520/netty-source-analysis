package com.xej.learning.keyword

/**
  * Created by erjun on 2017/8/13.
  */
object Test_001_Lazy {
	def main(args: Array[String]): Unit = {
		val node = initNode()
		println("--------after--------")
		println(node)
	}

	def initNode(): String = {
		println("------init---node----info--")
		"--------------init----node-----------------"
	}
}
