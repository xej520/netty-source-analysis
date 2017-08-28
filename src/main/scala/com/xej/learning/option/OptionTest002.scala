package com.xej.learning.option

/**
  * Created by erjun on 2017/8/5.
  */
object OptionTest002 {
	def main(args: Array[String]): Unit = {
		//有点java里的if判断
		val master001 = Option("spark").orElse(Option(null)).orNull

		val master002 = Option(null).orElse(Option("hadoop")).orNull

		val master003 = Option(null).orElse(Option(null)).orNull

		println("====>master001:\t" + master001) //====>master001:	spark

		println("====>master002:\t" + master002)//====>master002:	hadoop

		println("====>master003:\t" + master003)//====>master003:	null

	}
}
