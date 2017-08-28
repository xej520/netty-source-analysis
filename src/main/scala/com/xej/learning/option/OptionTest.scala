package com.xej.learning.option

/**
  * Created by erjun on 2017/8/5.
  */
object OptionTest {
	def main(args: Array[String]): Unit = {
		val propertiesFile = ("spark","hadoop")
		Option(propertiesFile).foreach{
			case (k,v) => println("x:\t" +k + ", v:\t" + v)//x:	spark, v:	hadoop
		}

		val propertiesFile2 = null
		Option(propertiesFile2) match {
			case Some(x) => println("------------>" + x)
			case None => println("-------null---------")//-------null---------
		}
	}
}
