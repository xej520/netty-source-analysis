package com.xej.learning.class_learning

/**
  * Created by erjun on 2017/8/28.
  * 内部类测试
  */
private[class_learning] class Kafka{
	//定义一个内部类
	class InnerKafka(val name: String){
		var config = "properties.txt"
		def sayHello(): Unit ={
			//内部类，可以调用外部类里private的属性
			//但是，外部类，缺不能访问内部类里的属性
			println("---->:\t" + age)
		}
	}
	private var age = 10
	import scala.collection.mutable.ArrayBuffer
	//这个数组，只能添加，同一个对象里多个内部类对象
	//不能添加，不同对象的多个内部类对象
	val saveKakfa = new ArrayBuffer[InnerKafka]()
	def create(name: String): InnerKafka ={
		new InnerKafka(name)
	}
}

object InnerClass {
	def main(args: Array[String]): Unit = {
		val master = new Kafka
		val masterKafka = master.create("masterKafka")
		val masterKafka2 = master.create("masterKafka2")

		println("---->\t" + masterKafka.getClass == masterKafka2.getClass)//false

		val slave = new Kafka
		val slaveKafka = slave.create("slaveKafka")
		val slaveKafka2 = slave.create("slaveKafka2")

		master.saveKakfa += masterKafka
		master.saveKakfa += masterKafka2

		master.saveKakfa.foreach(x => print(x.name + " "))

//		master.saveKakfa += slaveKafka

	}
}
