package com.b7_0.yin_shi_Han_shu

/**
  * Created by erjun on 2017/2/16.
  * 使用某个类型的对象，调用某个方法，虽然该类型有这个方法，但是给方法传入的参数类型，与方法定义的接收参数的类型不匹配
  */
private[yin_shi_Han_shu] class TicketHouse {
	var ticketNum = 0
	def buySpecialTicket(p: SpecialPerson): Unit = {
		ticketNum += 1
		println("T-" + ticketNum)
	}
}


object YinShiHanShu3 {
	def main(args: Array[String]): Unit = {
		val student = new Student("jack")
		val worker = new Worker("lili")
		val specialPerson = new SpecialPerson("wangliu")
		val ticketHouse = new TicketHouse
		ticketHouse.buySpecialTicket(specialPerson)
		//对象里的方法的 实际传入参数类型 与 规定的类型 不匹配 导致触发 隐式转换函数
		ticketHouse.buySpecialTicket(student)
		//如果传进入的不是Studet以及子类的话，就会报错的
//		ticketHouse.buySpecialTicket(worker)
	}

	implicit def student2SpecialPerson(stu: Student): SpecialPerson = {
		new SpecialPerson(stu.name)
	}

}
