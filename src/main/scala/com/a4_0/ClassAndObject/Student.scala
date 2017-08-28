package com.a4_0.ClassAndObject

/**
  * Created by erjun on 2017/2/13.
  */
class Student(name:String, age: Int) {
	def show(): Unit = {
		println(name + " ---> " + age + " ---> " + Student.schoolID)
	}
}

object Student {
	private val schoolID: Int = 22
}












