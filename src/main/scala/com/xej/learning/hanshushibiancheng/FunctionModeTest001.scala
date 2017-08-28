package com.xej.learning.hanshushibiancheng

/**
  * Created by erjun on 2017/8/5.
  * 函数式编程
  */
object FunctionModeTest001 {
	def main(args: Array[String]): Unit = {
		println(cube(9))
		println(cube(4))
		println(cube(2))
		println(sumCube(1,2))

	}
	def cube(n: Int): Int = n * n * n

	def id(n:Int):Int = n

	def square(n:Int):Int = n * n

	def fact(n:Int):Int = if(n==0) 1 else n * fact(n-1)

	def sumCube(a:Int, b:Int):Int = {
		if (a > b)
			0
		else
			cube(a) + sumCube((a+1), b)
	}

	def sumSquare(a:Int, b:Int):Int = if (a > b) 0 else square(a) + sumSquare((a+1), b)

	def sumFact(a:Int, b:Int):Int = if (a > b) 0 else fact(a) + sumFact((a + 1) , b)

	def sumId(a:Int, b:Int):Int = if (a>b) 0 else id(a) + sumId(a+1, b)

	//定义一个高阶函数
	def sum(f:Int => Int, a:Int, b:Int) :Int = if (a > b) 0 else f(a) + sum(f, a+1, b);

	def sumSquare2(a:Int, b:Int) :Int = sum(x=> x*x, a,b)
	def sumCube2(a:Int, b:Int) :Int = sum(x=> x*x*x, a,b)

}
