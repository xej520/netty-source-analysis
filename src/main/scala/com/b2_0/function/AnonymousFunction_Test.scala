package com.b2_0.function

/**
  * Created by erjun on 2017/2/15.
  * 匿名函数：
  * 	可以传递赋值给变量
  *
  */
object AnonymousFunction_Test {
	def main(args: Array[String]): Unit = {
		//1、没有输入参数的，没有返回值的 匿名函数
		val aFunc = println("=========")
		aFunc
		println("afunc:\t" + aFunc)
		println("------------------------")
		//2、有输入参数，没有返回值的匿名函数
		val aFunc2 = (name: String) => {println("---->\t" + name)}
		aFunc2("laoxing")
		val result2 = aFunc2("xej")
		println(result2)//该匿名函数，没有返回值的，因此，这里只打印输出 括号
		println("------------------------")
		//3、有输入参数，有返回值的匿名函数
		val aFun3 = (name: String) => {"hello, spark:\t" + name}
		val result = aFun3("hive")
		println(result)
		println(aFun3("hadoop"))
	}
}
