package cn.netty.demo

import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter}

/**
  * Created by erjun on 2017/3/17.
  */
class ClientHandler extends ChannelInboundHandlerAdapter{

	override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {
		println("server exceptionCaught")
		ctx.close()
	}

	override def channelActive(ctx: ChannelHandlerContext): Unit = {
		println("client active and write hello world")
		ctx.writeAndFlush("hello world")

	}

	override def channelRead(ctx: ChannelHandlerContext, msg: scala.Any): Unit = {
		msg match {
			case message: String => println(s"string:  $message")
			case NettyMsg(message) => println(s"string: $message")
		}
	}

	override def channelRegistered(ctx: ChannelHandlerContext): Unit = {
		println("client registered")
	}

	override def channelReadComplete(ctx: ChannelHandlerContext): Unit = {
		println("client read complete")
	}

}














