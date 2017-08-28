package com.b4_0.fanxing

/**
  * Created by erjun on 2017/2/15.
  * 泛型类测试，
  * 	泛型类，可以限制类里的成员属性 或者 成员方法
  */
private[fanxing] class Student[T](val name: T) {
	def getSchool(hukouID: T): Unit = {
		println("S-" + name + "-" + hukouID)
	}
}

object FanXingClass {
	def main(args: Array[String]): Unit = {
		val student = new Student[String]("laoxing")
		student.getSchool("000001")
	}
}


























