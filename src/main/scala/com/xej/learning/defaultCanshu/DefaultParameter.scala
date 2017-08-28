package com.xej.learning.defaultCanshu

/**
  * Created by erjun on 2017/8/5.
  */
object DefaultParameter  extends App{

	sayHello("laoxing", 55)

	def sayHello(name: String, age:Int = 20) {
		println("hello, " + name + ", your age is " + age);
	}
}


