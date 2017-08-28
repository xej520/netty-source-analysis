package com.b6_0.xie_bian

/**
  * Created by erjun on 2017/2/16.
  * 针对协变，进行测试，
  * 	协变，就是保持以前的 依赖 关系
  */
private[xie_bian] class Animal
private[xie_bian] class Person extends Animal
private[xie_bian] class Male extends Person
private[xie_bian] class Boy extends Male
private[xie_bian] class Miss extends Person
private[xie_bian] class Girl extends Miss

//【+T】这是 协变，保持 依赖关系
//协变，可以看做是，类具有某种属性吧
private[xie_bian] class Car[+T](val name: String)

object XieBian_Test {
	def main(args: Array[String]): Unit = {
		val carPerson = new Car[Person]("laoxing")
		val carBoy = new Car[Boy]("laoxing")
		val carGirl = new Car[Girl]("laoxing")
		val carMale = new Car[Male]("male")
		val carMiss = new Car[Miss]("miss")
		val carAnimal = new Car[Animal]("laoxing")
		enter(carPerson)
		enter(carBoy)
		enter(carBoy)
		enter(carMale)
		enter(carMiss)
//		编辑时，直接报错的
//		enter(carAnimal)
	}

	//Person 以及Person的子类 可以进来
	//是这里，
	def enter(car: Car[Person]) {println("=========孙子，您进来啊===========")}
}













