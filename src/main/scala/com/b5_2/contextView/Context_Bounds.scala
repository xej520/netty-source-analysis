package com.b5_2.contextView

/**
  * Created by erjun on 2017/2/16.
  * [T: Ordering] 就表示 上下文界定， 一定是Ordering 而不是 Ordered, 然后会利用
  * 隐式转换功能，将Ordering  转换成 Ordered的
  */
//[T: Ordering] 上下文 边界
private[contextView] class Pair_Ordering[T: Ordering] (val first: T, val second: T){
	//方式一
	def bigger(implicit ordered:  Ordering[T]) = {
		if (ordered.compare(first, second) > 0) first else second
	}

	//方式二, 下面的三种方式都可以的
	import Ordered.orderingToOrdered
	def bigger2 = if (first > second) first else second

	def bigger3 = if (first.compareTo(second) > 0) first else second

	def bigger4 = if (first.compare(second) > 0) first else second
}

object Context_Bounds extends App{
	val  pair = new Pair_Ordering[String]("laoxing", "xej")
	println(pair.bigger)
	println("==========================================")
	val  pair2 = new Pair_Ordering[String]("897", "456")
	println(pair2.bigger)
	println("==========================================")
	val pair3 = new Pair_Ordering[String ]("234", "123")
	println(pair3.bigger2)
	println(pair3.bigger3)
	println(pair3.bigger4)
}

















