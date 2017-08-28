package com.a3_0.constructor

/**
  * Created by erjun on 2017/2/13.
  */
/**
  * 主构造函数跟函数名在一起的
  */
class Student {
	//类私有对象
	private var name = ""
	private var age = 0
	//定义一个方法
	def this(name: String) {
		this()
		this.name = name
	}

	def this(age: Int) {
		this()
		this.age = age
	}

	def show: Unit = {
		println(name + " ----> " + age)
	}

	def setAge_=(age: Int): Unit = {
		if (age > 0) {
			this.age = age
		} else {
			throw new IllegalArgumentException("age:\t" + age + " is more than zero")
		}

	}
}

class Worker(name: String, age: Int) {
	private var school: String = "bjtu"

	println("-------我是主构造器-----")

	def show(): Unit = {
		println(name + " -----> " + age + " ----> " + school)
	}
}
class Teacher {
	println("---------------")
	private var age: Int = 34
	if (age > 0) {
		println("==========我也是主构造器==============")
	}
 }

object Test_Constructor extends App{
	val student = new Student()
	val student2 = new Student("laoxing")
	student2.setAge_=(4)
	student2.show
	println("+++++++++++++++++++++")
	val worker = new Worker("laoxing", 22)
	worker.show()
	println("---><-----")
	val teacher = new Teacher
}
