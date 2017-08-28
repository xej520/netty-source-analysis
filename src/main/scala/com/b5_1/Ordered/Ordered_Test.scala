package com.b5_1.Ordered

/**
  * Created by erjun on 2017/2/16.
  */
private[Ordered] case class Student(val name: String) extends Ordered[Student] {
	override def compare(that: Student): Int = {
		if (this.name < that.name) {
			1
		} else {
			-1
		}
	}
}

private[Ordered] class Pairl[T <: Ordered[T]](val first: T, val second: T) {
	def smaller() = {
		if (first < second) {
			first
		} else {
			second
		}
	}
}

object Ordered_Test {
	def main(args: Array[String]): Unit = {
		val p = new Pairl[Student](Student("laoxing"), Student("xej"))
		println(p.smaller())
		println(p.smaller().name)
	}
}










