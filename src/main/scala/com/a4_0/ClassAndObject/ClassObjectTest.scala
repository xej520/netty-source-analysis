package com.a4_0.ClassAndObject

/**
  * Created by erjun on 2017/2/13.
  */
object ClassObjectTest {
	def main(args: Array[String]): Unit = {
		val student = new Student("laoxing", 22)
		val student2 = new Student("spark", 23)
		student.show()
		println("================")
		student2.show()
	}
}
