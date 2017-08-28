package com.a2_0.seal

/**
  * Created by erjun on 2017/2/13.
  */

sealed abstract class  Person
case object American extends Person
case object Japanese extends Person
case object Chinese extends Person
case object Russia extends Person



object Test_Seal {
	def main(args: Array[String]): Unit = {

		//直接调用函数，而不是通过对象或者类
		people(American)
		people(Russia)
	}

	//定义一个函数，在scala语言中，函数是第一公民，不依赖于其他对象而存在，可以直接调用
	def people(p: Person) = p match {
		case American => println("American")
		



	}

//	def people(p: Person) = p match {
//		case American => println("American")
//		case Japanese => println("Japanese")
//		case Chinese => println("Chinese")
//	}
}


















