package com.a9_0.protected_test

/**
  * Created by erjun on 2017/2/14.
  */
class Book {

	def show(p: Person3) = p match {
		case Student3(name) => println("name:\t" + name)


	}


}
