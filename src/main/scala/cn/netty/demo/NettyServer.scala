package cn.netty.demo

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.serialization.{ClassResolvers, ObjectDecoder, ObjectEncoder}

/**
  * Created by erjun on 2017/3/17.
  */
class NettyServer {
	def bind(host: String, port: Int): Unit = {
		val boss = new NioEventLoopGroup()
		val worker = new NioEventLoopGroup()

		try {
			val bootstrap = new ServerBootstrap()
			bootstrap.group(boss, worker)
						    .channel(classOf[NioServerSocketChannel])
								    .childHandler(new ChannelInitializer[SocketChannel] {
										override def initChannel(ch: SocketChannel): Unit = {
											ch.pipeline().addLast(
												new ObjectEncoder,
												new ObjectDecoder(ClassResolvers.cacheDisabled(getClass.getClassLoader)),
												new ServerHandler
											)
										}
									})
				//绑定端口，调用sync方法等待绑定操作完成
			val channelFuture = bootstrap.bind(host, port).sync()

			//等待关闭服务
			channelFuture.channel().closeFuture().sync()
		} finally {
			boss.shutdownGracefully()
			worker.shutdownGracefully()
		}
	}
}

object NettyServer {
	def main(args: Array[String]): Unit = {
		val host = "127.0.0.1"
		val port = 8080
		val server = new NettyServer

		server.bind(host, port)
	}
}







