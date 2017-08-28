package com.a2_0.seal

/**
  * Created by erjun on 2017/2/13.
  * 怪了，并没有报错啊
  */
//创建一个抽象类
sealed abstract class Person2
//创建3个case class类
case class Student2(name:String, sno:Int) extends Person2
case class Teacher2(name:String, sno:Int) extends Person2
case class Worker2(name:String, sno:Int) extends Person2

object SealedAndOption extends App{
	val p: Person2 = Student2("laoxing",22)
	p match {
		case Student2(name,sno) => println(name + " is a student")
	}

	val m = Map("name"->"spark", "age"->25)
	m.get("age") match {
		case Some(age) => println("age is : " + age )
	}
	println(m("name"))
	for((key,value) <- m) yield (value, key)

}













