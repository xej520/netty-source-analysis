package com.a9_0.protected_test

/**
  * Created by erjun on 2017/2/14.
  */
class Person {
	//没有写修饰符，默认是private的，会默认提供的public级别的set get 方法
	//1、子类可以访问 2、其他外界可以通过Person对象来方法
	var name: String = "laoxing"

	//1、子类的当前实例可以访问，非当前实例不能访问 2、外界不能访问
	protected[this] var sex: String = "male"
	//1、子类可以访问，2、非Person的子类 不能访问的
	protected[Person] var address: String = "sjz"
	//1、子类可以访问，2、protected_test 包下，可以通过Person对象来访问的
	protected[protected_test] var school: String = "bjtu"

	//private修饰，只能在本类里访问，其他不能访问
	private var age = 19

	def show(): Unit = {
		println("========person============")
	}
	protected def showInfo(): Unit = {
		println("name:\t" + name + "; age:\t" + age + "; school:\t" + school)
	}
}

class Student extends Person {
	def doShow(): Unit = {
		println("Person_name:\t" + name)      //var name: String = "laoxing"
		println("Person_sex:\t" + sex)
		println("Person_address:\t" + address)
		println("Person_school:\t" + school)

		show()
		showInfo()
	}
	def isAge(s: Student): Unit = {
		//sex 只能在当前实例里访问的，不能通过其他实例 传过来的
//		super.sex == s.sex
	}
	//school 可以通过其他实例来传递过来
	def isSchool(s: Student): Boolean = {
		return school == s.school
	}
	//address 可以通过其他实例来传递过来
	def isAddress(s: Student): Boolean = {
		return address == s.address
	}
}

class Worker  {
	def doWoker(): Unit = {
		val p = new Person
		println("Person--->name:\t" + p.name)
//		println("Person--->name:\t" + p.)
		println("Person--->school:\t" + p.school)
		val a = new Animal3
	}


}

object Protected_Test {
	def main(args: Array[String]): Unit = {
		val student: Student = new Student
		student.doShow()
	}
}
