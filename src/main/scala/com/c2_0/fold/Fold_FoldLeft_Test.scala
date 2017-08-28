package com.c2_0.fold

/**
  * Created by erjun on 2017/4/5.
  */
object Fold_FoldLeft_Test extends App{
	val strs = List("h", "e","l","l","o")
	val results = strs.fold("") {(x,y) =>
		x + y
	}
	println(results)
}
