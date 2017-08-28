package com.xej.learning.GaoJieFunction

/**
  * Created by erjun on 2017/8/7.
  */
object GFunctionTest001 {
	def main(args: Array[String]): Unit = {
		greeting((name: String) => {println("---->:\t" + name)}, "laoxing")
		greeting((name: String) => {println("++++>:\t" + name)}, "laoxing")
	}

	def greeting(func: (String)=>Unit, name: String): Unit = {
		func(name) + ",\thaha" + "; ===> " + name
	}



}

