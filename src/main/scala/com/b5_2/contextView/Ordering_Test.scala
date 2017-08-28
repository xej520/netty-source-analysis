package com.b5_2.contextView

/**
  * Created by erjun on 2017/2/16.
  */
//自己定义 隐式转换
private[contextView] class PersonOrdering extends Ordering[Person] {
	override def compare(x: Person, y: Person): Int = {
		if(x.name > y.name) 1 else -1
	}
}

private[contextView] case class Person(val name: String) {
	println("正在构造对象：\t" + name)
}

private[contextView] class Pair[T: Ordering](val first: T, val second: T) {
	//引入Ordering到Ordered的隐式转换， 在查找作用域范围内的Ordering[T]的隐式值
	//本例的话是implicit val p1 = new PersonOrdering
	import Ordered.orderingToOrdered
	def samller = {
		//编译器看到的比较方式是 < 的方式 进行的时候， 会自动进行 隐式转换的
		//转换成Ordered, 然后，调用其中的  <  方法进行比较
		if (first < second) first else second
	}
}

object Ordering_Test {
	def main(args: Array[String]): Unit = {
		implicit val p1 = new PersonOrdering
		val p = new Pair[Person](Person("123"), Person("456"))
		println(p.samller)
		println("==================")
		val pair = new Pair[String]("laoxing", "spark")
		println(pair.samller)

	}
}













