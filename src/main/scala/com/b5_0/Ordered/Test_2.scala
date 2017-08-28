package com.b5_0.Ordered

/**
  * Created by erjun on 2017/2/16.
  */
object Test_2{
	def main(args: Array[String]): Unit = {
		//又专门 创建一个类
		val pair = new Pair1[Student](Student("xej"), Student("laoxing"))
		println(pair.smaller())
		println(pair.smaller().name)
		//
		val stu1 = Student("xej")
		val stu2 = Student("abc")
		println(stu1.compare(stu2))
	}
}


