package com.b0_0.inner_class

/**
  * Created by erjun on 2017/2/14.
  */
//private[inner_class] 用来限定Person的作用域范围，也就是说，只能在当前包下访问
private[inner_class] class Person(protected val name: String){
	def sayHello = "hello , spark" + name
}
//创建Person的一个子类
private[inner_class] class Student(name: String, age: Int, val school: String) extends Person(name) {
	override def sayHello: String = "name:\t" + name + "\nage:\t" + age + "\nschool:\t" + school;
}

object InnerClass_Test {
	def main(args: Array[String]): Unit = {
		//先创建一个Student对象
		val student = new Student("laoxing", 22, "bjtu")
		println(student.sayHello)
		//下面以 匿名内部类的方式，来进行创建
		val person = new Person("laoxing") {
			override def sayHello: String = "hello, spark " + name
		}
		val person3 = new Person("hive")
		println("==================匿名内部类=======================")
		println(person.sayHello)
		println("==================greeting=======================")
		greeting(person)
		println("==================greeting2=======================")
		greeting2(person3)
	}
	def greeting(p: Person): Unit = {
		println(p.sayHello)
	}
	def greeting2(p: Person{def sayHello: String}): Unit = {
		println(p.sayHello)
	}
}







