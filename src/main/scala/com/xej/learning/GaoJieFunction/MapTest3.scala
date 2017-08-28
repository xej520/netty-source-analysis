package com.xej.learning.GaoJieFunction

/**
  * Created by erjun on 2017/8/24.
  */
private[GaoJieFunction] class Kafka(val name: String)

object MapTest3 {
	def main(args: Array[String]): Unit = {
		val kafka1 = new Kafka("kafka-1")
		val kafka2 = new Kafka("kafka-2")
		val kafka3 = new Kafka("kafka-3")
		val kafka4 = new Kafka("kafka-4")
		val arrKafka = Array(kafka1,kafka2,kafka3,kafka4)
		//需求，将kafka对象的name属性取出来，组成一个数组返回
		//就可以利用高阶函数map来实现了
		val nameKafka = arrKafka.map(_.name)
		//打印nameKafka输出
		nameKafka.foreach(x => print(x + " "))
	}
}
