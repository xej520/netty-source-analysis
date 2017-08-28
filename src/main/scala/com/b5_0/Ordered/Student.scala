package com.b5_0.Ordered

/**
  * Created by erjun on 2017/2/16.
  */
private[Ordered] case class Student(val name: String) extends Ordered[Student]{
	override def compare(stu: Student): Int = {
		if (this.name == stu.name) {
			1
		} else {
			-1
		}
	}

}
