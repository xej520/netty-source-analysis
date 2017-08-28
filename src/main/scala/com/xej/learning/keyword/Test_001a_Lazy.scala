package com.xej.learning.keyword

/**
  * Created by erjun on 2017/8/13.
  */
object Test_001a_Lazy {
	def main(args: Array[String]): Unit = {
		lazy val node = initNode()
		println("--------after--------")
		println(node)
	}

	def initNode(): String = {
		println("------init---node----info--")
		"--------------init----node-----------------"
	}
}
