package com.b1_0.trait_lazy_test

/**
  * Created by erjun on 2017/2/15.
  * 当接口里，存在没有被初始化的抽象字段时，
  * 继承
  */
private[trait_lazy_test] trait Sch {
	lazy val msg: String = null
	println(msg.toString)
}
//当一个类在继承某个接口时，这个接口里，字段必须被初始化了
//或者，字段必须被lazy进行修饰，说明是赖初始化，然后你就可以在Person类，进行初始化
private[trait_lazy_test] class Person2 extends Sch {
	override lazy val msg: String = "hello, spark "
	def say(): Unit = {
		println("---->\t" + msg)
	}
}
object Lazy_Test {
	def main(args: Array[String]): Unit = {
		val p = new Person2
	}
}



















