package com.a6_1.Enum
/**
  * Created by erjun on 2017/2/14.
  */

object Driver extends App{
	println(Margin.BOTTOM)
	println(Margin.BOTTOM.id)

	def doWhat(color: TrafficLightColor.TrafficLightColor) = {
		if (color == TrafficLightColor.Red) {
			"stop"
		} else if (color == TrafficLightColor.Yellow) {
			"hurry up"
		} else {
			"go"
		}
	}

    def doWhat2(color:  TrafficLightColor.TrafficLightColor) = color match {
		case TrafficLightColor.Red => "Stop"
		case TrafficLightColor.Yellow => "Hurry up"
		case _ => "go"
	}

	val red = TrafficLightColor(10)
	println(red)
	println(doWhat(red))
	println("======================")
	println(doWhat2(red))


}












