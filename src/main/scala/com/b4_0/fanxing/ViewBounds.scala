package com.b4_0.fanxing

/**
  * Created by erjun on 2017/2/15.
  * 增强版，上下边界测试
  */
private[fanxing] class Person4(val name: String) {
	def sayHello() {println("Hi, my name is " + name)}
	def makeFriends(p: Person4): Unit = {
		sayHello()
		p.sayHello()
	}
}

private[fanxing] class Student01(name: String) extends Person4(name)

private[fanxing] class Dog(val name: String) {
	def sayDog() = {
		println("Wang, Wang , hi my name is " + name)
	}
}

private[fanxing] class PlayParty[T <% Person4](p1: T, p2: T) {
	def pay(): Unit = {
		p1.makeFriends(p2)
	}
}

object ViewBounds {
	def main(args: Array[String]): Unit = {
		val stu1 = new Student01("laoxing")
		val stu2 = new Student01("xej")
		val dog = new Dog("huanghuang")

//		val party = new PlayParty(stu1, stu2)
//		party.pay()

//		val party2 = new PlayParty(stu1, dog)
//		party2.pay()
	}

//	implicitTest def dog2Person(obj: Object): Person4 = {
//		if (obj.isInstanceOf[Dog]) {
//			println("-------------------")
//			val dog = obj.asInstanceOf[Dog]
//			new Person4(dog.name)
//		} else {
//			Nil
//		}
//
//	}
}






















