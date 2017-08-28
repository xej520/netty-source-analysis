package com.xej.learning.classAndObjectAndtrait.Class

/**
  * Created by erjun on 2017/8/19.
  */
class Node{
	var nodeName= "ftp-work-0"
	val ip = "192.168.1.11"
	private var cpu = 2
	private val disk = 2*1024
	private[this] val memory = 128
	private[this] var log = "/log/ftp.log"

	def getNodeInfo(): Unit ={
		println("---create----:\t" + cpu)
		println("---create----:\t" + disk)
		println("---create----:\t" + memory)
		println("---create----:\t" + log)
	}
	def updateNodeInfo: Unit ={
		cpu = 3//private
		log = "/log/ftp2.log"
	}
	def compore(node: Node): Unit = {

//		println("----private[this]---memory----:\t" + (memory < node.memory))
		println("----private[this]---cpu---:\t" + (cpu < node.cpu))
	}
}

 class Cluster  private (name: String){
	def sayHello(): Unit = {
		println("-----> " + name)
	}
}

private class FtpCluster (name: String) {
	def sayHello(): Unit = {
		println("-----> " + name)
	}
}


object ClassTest2 {
	def main(args: Array[String]): Unit = {
		val node = new Node
		println("----->:\t" + node.ip)

//		val cluster = new Cluster()
//		println("-----> " + cluster.sayHello())
//		val clusterFtp = new FtpCluster("hello");
//		val clusterFtp2 = new FtpCluster();
//		println("-----> " + clusterFtp.sayHello())
	}
}
