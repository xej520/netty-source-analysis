package cn.netty.demo

import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter}

/**
  * Created by erjun on 2017/3/17.
  */
class ServerHandler extends ChannelInboundHandlerAdapter{

	override def channelActive(ctx: ChannelHandlerContext): Unit = {
		println("server actived")
	}

	override def channelRead(ctx: ChannelHandlerContext, msg: scala.Any): Unit = {
		msg match {
			case message : String => {
				println(s"string: $message");
				ctx.write("string return")
			}

			case NettyMsg(message) => {
				println(s"NettyMsg: $message")
				ctx.write(NettyMsg("nettyMessage return "))
			}
		}
	}

	override def channelRegistered(ctx: ChannelHandlerContext): Unit = {
		println("server point registered")
	}

	override def channelReadComplete(ctx: ChannelHandlerContext): Unit = {
		println("server read complete")
		ctx.flush()
	}

}
