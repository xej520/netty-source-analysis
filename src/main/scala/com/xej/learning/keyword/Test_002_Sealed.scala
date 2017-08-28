package com.xej.learning.keyword

/**
  * Created by erjun on 2017/8/14.
  */
sealed abstract class Person{
}

case object Student extends Person
case object BoyStudent extends Person
case object GirlStudent extends Person
case object Worker extends Person
case object MaleWorker extends Person
case object FemaleWorker extends Person

object Test_002_Sealed {
	def main(args: Array[String]): Unit = {
		person(BoyStudent)
	}
	def person(p: Person) = p match {
		case BoyStudent =>  println("------BoyStudent-----")
		case GirlStudent =>  println("------GirlStudent-----")
		case MaleWorker =>  println("------MaleWorker-----")
	}
}
