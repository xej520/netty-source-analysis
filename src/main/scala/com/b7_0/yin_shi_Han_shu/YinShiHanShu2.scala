package com.b7_0.yin_shi_Han_shu
/**
  * Created by erjun on 2017/2/16.
  */
private[yin_shi_Han_shu] class Man(val name: String) {
	def show: Unit = {
		println("=====>\t" + "Hello, " + name)
	}
}
private[yin_shi_Han_shu] class SuperMan(val name: String) {
	def wuGong(): Unit = {
		println("I can fly!!!")
	}
}

object YinShiHanShu2 {
	def main(args: Array[String]): Unit = {
		val man = new Man("Jack")
		//下面是利用隐式转换函数，man对象去调用 其他类型 里的方法
		man.wuGong()
	}

	//定义一个 隐式 转换 的函数
	implicit def man2SuperMan(man: Man): SuperMan = {
		//其实，如果参数已经规定具体的类型了，如Man的话，就不需要下面的
		// man.getClass == classOf[Man] 判断了
		if (man != null) {
			if (man.getClass == classOf[Man]) {
				new SuperMan(man.name)
			} else null

		} else null

	}
}





