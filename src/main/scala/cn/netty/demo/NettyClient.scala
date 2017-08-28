package cn.netty.demo

import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.serialization.{ClassResolvers, ObjectDecoder, ObjectEncoder}

/**
  * Created by erjun on 2017/3/17.
  */
class NettyClient {

	def connect(host: String, port: Int): Unit = {

		val msgGroup = new NioEventLoopGroup()

		try{
			val bootstrap = new Bootstrap

			bootstrap.group(msgGroup)
						    .channel(classOf[NioSocketChannel]).handler(new ChannelInitializer[SocketChannel] {
				override def initChannel(ch: SocketChannel): Unit = {
					ch.pipeline().addLast(
						new ObjectEncoder,
						new ObjectDecoder(ClassResolvers.cacheDisabled(getClass.getClassLoader)),
						new ClientHandler
					)
				}
			})

			//发起异步链接操作
			val channelFuture = bootstrap.connect(host, port).sync()
			//等待服务器的链接
			channelFuture.channel().closeFuture().sync()
		} finally {
			msgGroup.shutdownGracefully()
		}
	}
}

object NettyClient {

	def main(args: Array[String]): Unit = {

		val host = "127.0.0.1"
		val port = 8080;
		val client = new NettyClient
		client.connect(host, port)
	}

}


