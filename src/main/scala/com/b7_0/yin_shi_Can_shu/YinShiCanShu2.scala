package com.b7_0.yin_shi_Can_shu

/**
  * Created by erjun on 2017/2/16.
  * 	这个源码，主要是，将隐式变量 存放在/作用域在  目标对象的 伴生对象里
  */
private[yin_shi_Can_shu] class School2(val name: String)
private[yin_shi_Can_shu] class Student2(val name: String)

//隐式变量，定义在 伴生对象里
private[yin_shi_Can_shu] object School2{
	implicit val school = new School2("qinghua")
}

object YinShiCanShu2 {
	def main(args: Array[String]): Unit = {
		val student = new Student2("laoli")
		showInfo(student)
	}
	//定义
	def showInfo(student: Student2)(implicit school: School2): Unit = {
		println("school:\t" + school.name + " ------> " + "name:\t" + student.name)
	}
}
