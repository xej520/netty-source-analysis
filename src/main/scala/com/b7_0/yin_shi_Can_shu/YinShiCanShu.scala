package com.b7_0.yin_shi_Can_shu

/**
  * Created by erjun on 2017/2/16.
  * 隐式参数，很明显，触发的机制，就是，参数里出现了关键之  implicitTest 修饰，
  * 	需要提供一个隐式变量 就行了
  */
private[yin_shi_Can_shu] class School(val name: String)
private[yin_shi_Can_shu] class Student(val name: String)

object YinShiCanShu {
	def main(args: Array[String]): Unit = {
		val student = new Student("laoxing")
		showInfo(student)
	}
	def showInfo(student: Student)(implicit school: School): Unit = {
		println("school:\t" + school.name + " ------> " + "name:\t" + student.name)
	}

	//创建一个隐式变量   作用域1：可以定义在这里
	implicit val school = new School("bjtu")
	//还有，隐式变量，只能有一个，不能存在两个
//	implicitTest val school2 = new School("bjtu2")
}
