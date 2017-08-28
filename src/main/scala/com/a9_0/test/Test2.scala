package com.a9_0.test

import com.a9_0.protected_test.{Animal3, Professor3, Student3, Worker3}

/**
  * Created by erjun on 2017/2/14.
  */
object Test2 {
	def main(args: Array[String]): Unit = {
		println("============")
		val a = new Animal3
		val teacher3 = Student3("laoxing")

	}
}

object xx {
	def main(args: Array[String]): Unit = {
		println("=====2=======")
		val perforesor = Professor3
		println("---> " + perforesor.getClass)
	}
}


