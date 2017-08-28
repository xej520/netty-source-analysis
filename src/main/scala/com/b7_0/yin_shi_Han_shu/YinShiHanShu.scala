package com.b7_0.yin_shi_Han_shu

/**
  * Created by erjun on 2017/2/16.
  * 隐式函数  测试
  */
private[yin_shi_Han_shu] class SpecialPerson(val name: String)
private[yin_shi_Han_shu] class Student(val name: String)
private[yin_shi_Han_shu] class OlderMan(val name: String)
private[yin_shi_Han_shu] class Worker(val name: String)

private[yin_shi_Han_shu] object Student{
	//这里可以定义隐式转换的
	implicit def student2SpecialMan(stu: Student): SpecialPerson = {
		new SpecialPerson(stu.name)
	}
}
//OlderMan 伴生对象
private[yin_shi_Han_shu] object OlderMan {
	//针对OlderMan, 创建隐式转换函数
	implicit def olderMan2SpecialMan(older: OlderMan): SpecialPerson = {
		new SpecialPerson(older.name)
	}
}

object YinShiHanShu {
	//定义一个全局的变量
	var ticketNumer = 0
	def main(args: Array[String]): Unit = {
		val specialPerson = new SpecialPerson("worker")
		val student = new Student("stu")
		val olderMan = new OlderMan("laowang")
		val worker = new Worker("worker")
		buySpecialTicket(specialPerson)
		buySpecialTicket(student)
		buySpecialTicket(olderMan)
		buySpecialTicket(worker)
	}
	//普通函数，里的参数，实际输入的类型与规定的类型不匹配，从而触发，隐式转换
	//定义一个普通函数
	def buySpecialTicket(p: SpecialPerson) = {
		//这里需要做一个 保护的措施，因为，p为null的时候，也可以传递进来的
		if (p != null) {
			ticketNumer += 1
			println("T-" + ticketNumer)
			"T-" + ticketNumer
		}
	}

	//定义一个 隐式转换 函数
	implicit def object2SpecialPerson(obj: Object): SpecialPerson = {
		if (obj.getClass == classOf[Student]) {
			val stu = obj.asInstanceOf[Student]
			new SpecialPerson(stu.name)
		} else if (obj.getClass == classOf[OlderMan]) {
			val old = obj.asInstanceOf[OlderMan]
			new SpecialPerson(old.name)
		} else {
			println("obj:\t" + obj.getClass)
			null
		}
	}

}















