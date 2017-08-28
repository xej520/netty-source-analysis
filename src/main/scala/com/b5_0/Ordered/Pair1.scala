package com.b5_0.Ordered

/**
  * Created by erjun on 2017/2/16.
  */
private[Ordered] class Pair1[T <: Ordered[T]](val first: T, val second: T) {

	def smaller() = {
		if (first < second) {
			first
		} else {
			second
		}
	}

}
