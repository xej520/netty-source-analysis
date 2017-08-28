package com.a7_0.type_test

/**
  * Created by erjun on 2017/2/14.
  */
trait A {
	//定义一个别名，或者叫，就是定义一种类型
	type T
	def foo(i: T) = println(i)
}
