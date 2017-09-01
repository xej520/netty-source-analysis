package io.netty.example.nettySimple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by erjun on 2017/9/1.
 */
public class NettyServer {
	public static void main(String[] args) {

		// 复杂accept请求
		EventLoopGroup parentGroup = new NioEventLoopGroup(1);
		// 处理请求，读写
		EventLoopGroup childGroup = new NioEventLoopGroup();
		try {

			// 创建服务引擎
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(parentGroup, childGroup);

			serverBootstrap.channel(NioServerSocketChannel.class);

			// 设置tcp参数
			serverBootstrap.option(ChannelOption.SO_BACKLOG, 128).option(ChannelOption.SO_KEEPALIVE, true)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(
									new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
							ch.pipeline().addLast(new SimpleHandler());
							ch.pipeline().addLast(new StringEncoder());
						}
					});

			// 同步绑定
			ChannelFuture future = serverBootstrap.bind(8080).sync();

			if (future.isSuccess()) {
				System.out.println("-----服务端开始工作------");
			}

			// 同步等待关闭
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			parentGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}
	}

}
