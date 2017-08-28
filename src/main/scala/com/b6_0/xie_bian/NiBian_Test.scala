package com.b6_0.xie_bian

/**
  * Created by erjun on 2017/2/16.
  */

private[xie_bian] class Animal2
private[xie_bian] class Person2 extends Animal2
private[xie_bian] class Male2 extends Person2
private[xie_bian] class Boy2 extends Male2
private[xie_bian] class Miss2 extends Person2
private[xie_bian] class Girl2 extends Miss2

//定义一个 具有  逆变 性质的类
private[xie_bian] class Car2[-T](val name: String)

object NiBian_Test {
	def main(args: Array[String]): Unit = {
		val animalCar = new Car2[Animal2]("animal")
		val personCar = new Car2[Person2]("person")
		val boyCar = new Car2[Boy2]("boy")
		val girlCar = new Car2[Girl2]("girl")
		val maleCar = new Car2[Male2]("male")
		val missCar = new Car2[Miss2]("miss")
		enter(maleCar)
		enter(personCar)
		enter(animalCar)
//		enter(missCar)
//		enter(girlCar)
	}
	//这是协变，只有 Male2, 以及 父类 可以进来
	def enter(car: Car2[Male2]) {println("-------大爷，你好，你是我大爷-----------")}
}
