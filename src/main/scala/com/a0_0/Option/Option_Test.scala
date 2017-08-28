package com.a0_0.Option

import scala.collection.mutable

/**
  * Created by erjun on 2017/2/13.
  */
object Option_Test {
	def main(args: Array[String]): Unit = {
		val propertiesFile = ("spark", "laoxing");

		Option(propertiesFile).foreach{
			case (k,v) => println(k + " ---> " + v)
		}

		var master: String = null;

		master = Option(master).orElse(Option("spark")).orNull

		println("master：\t" + master)

	}
}



















