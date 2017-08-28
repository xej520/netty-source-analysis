package com.b4_0.fanxing

/**
  * Created by erjun on 2017/2/15.
  * 泛型之上边界测试，也就是说，只能子类或者自己传进去哈
  * 	泛型 可以用在 类上，就称为 泛型类
  * 	泛型 可以用在方法上，就称为了 泛型方法
  */
private[fanxing] class Animal {
	def showAnimal(): Unit = {
		println("===============")
	}
}

private[fanxing] class JiaQin extends Animal{
	def showJiaQin(): Unit = {
		showAnimal()
		printf("=======JiaQin======")
	}
}

private[fanxing] class YeWai extends Animal{
	def showJiaQin(): Unit = {
		showAnimal()
		printf("=======YeWai======")
	}
}

private[fanxing] class YeWai2 extends YeWai{
	def showJiaQin2(): Unit = {
		showAnimal()
		printf("=======YeWai======")
	}
}

//将泛型声明在类上，而且，是，上边界
private[fanxing] class All[T>:YeWai](p1: T, p2: T) {
	def play(): Unit = {
		println("----->\t" + p1.getClass + "---->" +p2.getClass)
	}
}

object UpBounds {
	def main(args: Array[String]): Unit = {
		val dog = new JiaQin
		val tuzi = new YeWai
		val tuzi2 = new YeWai2
		val animal = new Animal
		val animal2 = new Animal
//		val all = new All[YeWai](dog, animal2)
//		all.play()
	}
}
