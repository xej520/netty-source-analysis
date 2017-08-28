package com.a6_1.Enum

/**
  * Created by erjun on 2017/2/14.
  */
object TrafficLightColor extends Enumeration{
	type TrafficLightColor = Value
	val Red = Value(0, "Stop")
	val Yellow = Value(10)
	val Green = Value("Go")

}
