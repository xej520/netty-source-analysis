package com.xej.learning.map

/**
  * Created by erjun on 2017/8/29.
  * 测试用例：将Seq转换成Map类型
  */
private[map] class Student(val id: Int, val name: String)

object Seq2Map {
	def main(args: Array[String]): Unit = {
		val stu1 = new Student(1, "zhangsan")
		val stu2 = new Student(2, "lisi")
		val stu3 = new Student(3, "wangwu")
		val seq = Seq(stu1, stu2, stu3)
		//普通序列
		val map = seq.map(stu => stu.id -> stu)
		map.foreach(stu => println(stu._1 + " ----> " + stu._2.name))

		//添加上(collection.breakOut) 就变为索引序列
		//索引序列的优点是：
		//	具有高效的apply, length, 以及(如果可变的话) update操作
		val map2 = seq.map(stu => stu.id -> stu)(collection.breakOut)
		map2.foreach(stu => println(stu._1 + " ----> " + stu._2.name))
	}
}
