package cn.netty.demo.akka.demo

/**
  * Created by erjun on 2017/3/18.
  */
class WorkerInfo(val workerId: String, val host: String, val port: Int,
				 var memory: Int, var core: Int, val startTime: Long) {
	var lastHeartBeatTime: Long = _
}

object WorkerInfo {

	def apply(workerId: String, host: String, port: Int, memory: Int, core: Int, startTime: Long): WorkerInfo =
			new WorkerInfo(workerId, host, port, memory, core, startTime)

}

