package com.xej.learning.GaoJieFunction

/**
  * Created by erjun on 2017/8/23.
  */
object MapTest2 {
	def main(args: Array[String]): Unit = {
		val arr = Array("laoxing","spark","xx","hive")
		//_.length
		//map是说，对集合里的每一个元素，进行_.length操作，
		//然后，再返回一个集合，集合个数等价于arr的个数
		val result = arr.map(_.length)
		result.foreach(println(_))

	}
}
