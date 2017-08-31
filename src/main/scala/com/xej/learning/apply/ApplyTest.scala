package com.xej.learning.apply

/**
  * apply方法: 就是创建对象时，不再使用new的形式，而是直接使用了类名()的形式
  */
private[apply] class Storm
object Storm{
	//创建伴生类的对象时，会隐式的调用这个的
	def apply: Storm = new Storm()
}
private[apply] class Kafka(val name: String)
object Kafka{
	//由于伴生类的主构造器是有参数的，
	//因此，这里，也必须有参数的
	def apply(name: String): Kafka = new Kafka(name)
}

object ApplyTest {
	def main(args: Array[String]): Unit = {
		val storm = Storm
		val kafka = Kafka("kafka")
	}
}
