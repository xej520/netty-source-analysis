package cn.netty.demo.akka.demo

/**
  * Created by erjun on 2017/3/18.
  */
trait Msg extends Serializable

case class WorkderRegister(workerId: String, host: String, port: Int, memory: Int, core: Int) extends Msg

case class RegisterBack(masterId: String) extends Msg

case class HeartBeat(workerId: String, beatTime: Long, memory: Long, core: Int) extends Msg

case class InfoMsg(msg: String) extends Msg

case object WorkerHearBeat

case object WorkerCheck




