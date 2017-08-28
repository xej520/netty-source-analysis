package com.a8_0.IsInstanceOf

/**
  * Created by erjun on 2017/2/14.
  */

class Person
class Student extends Person
object IsInstanceof_Test extends App{
	val p: Person = new Student  //p仅仅是引用，指向的堆内存里的Student类型的对象
	val s: Student = null
	if (p.isInstanceOf[Person]) {
		println("=================") // 可以输出
		println(p)
	} else {
		p.asInstanceOf[Student]
		println(p)
	}
	val person2 = new Person
	if (person2.isInstanceOf[Student]) {
		println("------------------------")
		println(person2)
	} else {//可以输出
		println( "-----> " + person2)
	}
}


