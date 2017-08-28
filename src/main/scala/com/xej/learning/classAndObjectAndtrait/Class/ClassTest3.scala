package com.xej.learning.classAndObjectAndtrait.Class

/**
  * Created by erjun on 2017/8/21.
  * 分享类的构造器，构造器分为两种，第一种是主构造器，第二种辅助构造器
  */
class Kafka(val kafkaName: String, kakfaAge : Int = 12) {
	private var url = ""
	val name = kafkaName
	val arr = List(2,3,4,5)

	def this(kafkaName:String){
		this(kafkaName, 22)//主构造器
		this.url = url
	}
	def this(url:String, memory: Float, cpu: Float) {
		this(url)//调用上面的辅助构造器
		println("----->:\t" + this.url)
	}

	println("------主构造器--------")
	arr.foreach(x => println("-------->:\t" + x))
}
object ClassTest3 {
	def main(args: Array[String]): Unit = {
		val test = new Kafka("kafka")
	}
}
