package com.xej.learning.keyword

/**
  * Created by erjun on 2017/8/15.
  */

//类似于java中泛型吧
trait A { type T; def foo(i:T) = println("---->\t" + i)}

object BB extends A {type T = String}
object CC extends A {type T = Int}

object Test_003_type extends App{

	val b = BB
	val c = CC

	b.foo("scala")
	c.foo(8)
}
