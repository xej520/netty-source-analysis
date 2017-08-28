package com.a8_1.getClassAndClassOf

/**
  * Created by erjun on 2017/2/14.
  */
class Person
class Student extends Person
object Driver extends  App{
	val p = new Person
	println("---> " + p.getClass) //---> class com.a8_1.getClassAndClassOf.Person
	val p2 = new Student
	println("-----> " + p2.getClass) //-----> class com.a8_1.getClassAndClassOf.Student

	println("---------> " + classOf[Person]) //---------> class com.a8_1.getClassAndClassOf.Person


}
