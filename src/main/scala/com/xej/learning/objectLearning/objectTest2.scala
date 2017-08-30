package com.xej.learning.objectLearning

/**
  * 主要测试伴生对象，伴生类里的私有属性的访问范围
  */
private[objectLearning] class Student(val name: String, val age: Int, address: String="xizhimen"){
	private val sex = "male"
	val weight = 80
	def sayHello(): Unit ={
		Student.address = address
		//访问伴生对象里的普通属性 以及 私有属性
		println("name:\t" + name + " ----> " + " age:\t" + age +
			"\naddress:\t" + Student.address + " ----> school:\t" + Student.school)
	}
}
object Student{
	//伴生对象里的私有属性 跟 普通的私有属性 相比？
	//伴生对象，伴生类里的私有属性的 使用范围，扩大了。
	//伴生对象 与 伴生类可以互相访问彼此的私有属性，而普通私有属性仅仅只能在自己类里使用的
	private val school = "bjtu" //只能在伴生类里，调用，其他地方不能调用
	var address = "beijing" //除了伴生类里，其他地方也可以调用，跟普通属性一样
	//访问伴生类里的属性
	val stu = new Student("lisi",22, "haidian")
	println("----访问----伴生类里的---属性-----name:\t" + stu.name)
	println("----访问----伴生类里的---私有属性-----sex:\t" + stu.sex)
	println("----访问----伴生类里的---属性-----weight:\t" + stu.weight)
}
object objectTest2 {
	def main(args: Array[String]): Unit = {
		//调用伴生对象里的public属性
		println("----address:\t" + Student.address)

		//school是伴生对象的私有属性，这里不能访问的
		//println("----school:\t" + Student.school)
		new Student("zhansan", 19).sayHello()
		new Student("xiaoming", 22,"haidian").sayHello()
	}
}
