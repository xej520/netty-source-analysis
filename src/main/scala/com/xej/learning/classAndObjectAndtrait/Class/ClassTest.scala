package com.xej.learning.classAndObjectAndtrait.Class

/**
  * Created by erjun on 2017/8/17.
  */
class Beijing
class Beijing002(var name: String, val age: Int, address: String){
	def sayHello(): Unit ={
		println("------>: " + address)
	}
}
object ClassTest {
	def main(args: Array[String]): Unit = {
		val beijing = new Beijing
		val beijing002 = new Beijing002("xiaoming",22,"beijing")
		println(s"----beijing002----:\nname: " + beijing002.name + " age: "+beijing002.age)
	}
}
