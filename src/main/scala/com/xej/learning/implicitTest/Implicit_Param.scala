package com.xej.learning.implicitTest

/**
  * Created by erjun on 2017/8/22.
  * 隐式参数测试
  */
private[implicitTest] class Hadoop(val name: String)
private[implicitTest] class Yarn(val name:String)

object Implicit_Param {
	def main(args: Array[String]): Unit = {
		val hadoop = new Hadoop("hadoop")
		val hadoop2 = new Hadoop("hadoop2")
		val hadoop3 = new Hadoop("hadoop3")
		showInfo(hadoop)
		showInfo(hadoop2)
		showInfo(hadoop3)
	}
	def showInfo(hadoop: Hadoop)(implicit yarn: Yarn): Unit ={
		println("----->hadoop:\t" + hadoop.name + "; yarn:\t" + yarn.name)
	}
	//创建一个隐式变量，
	implicit val yarnName = new Yarn("yarn")
	//同一类型的隐式变量，应该只能有一个，不然，scala并不知道，
	// 到底要注入那个隐式变量
//	implicit val yarnName = new Yarn("yarn")
}
