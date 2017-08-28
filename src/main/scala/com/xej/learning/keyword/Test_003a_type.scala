package com.xej.learning.keyword

/**
  * Created by erjun on 2017/8/15.
  */
class Wangjing (var num : Int)

object Test_003a_type {
	def main(args: Array[String]): Unit = {
		val address : WJ = List[Wangjing](new Wangjing(3),new Wangjing(5))

		println("----->\t" + checkAddress(address))
	}

	//给List[Wangjing]声明了一个别名，就是Wangjing，
	// 也就是说，Wangjing等价于List[Wangjing]
	type WJ = List[Wangjing]
	def checkAddress(wj: WJ) : WJ = {
		wj.filter(p => p.num < 4)
	}
}
