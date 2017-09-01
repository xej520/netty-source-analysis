package io.netty.example.nettySimple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;

/**
 * Created by erjun on 2017/9/1.
 */
public class NettyClient {
	private static EventLoopGroup eventLoopGroup = null;
	private static Bootstrap bootstrap = null;
	static {
		eventLoopGroup = new NioEventLoopGroup();
		bootstrap = new Bootstrap();
		bootstrap.group(eventLoopGroup);
		bootstrap.channel(NioSocketChannel.class);
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true).handler(new ChannelInitializer<NioSocketChannel>() {
			@Override
			protected void initChannel(NioSocketChannel ch) throws Exception {
				ch.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
				// 设置String类型解码器
				ch.pipeline().addLast(new StringDecoder());
				// 设置编码器
				ch.pipeline().addLast(new StringEncoder());
				ch.pipeline().addLast(new ClientHandler());
			}
		});
	}

	public static void main(String[] args) {
		try {
			// 同步连接
			ChannelFuture future = bootstrap.connect("localhost", 8080).sync();
			String person = "张三\r\n";
			// 连接成功后，获取通过，往通道里，写入数据
			future.channel().writeAndFlush(person);
			future.channel().closeFuture().sync();
			Object msg = future.channel().attr(AttributeKey.valueOf("ChannelKey")).get();
			System.out.println("====客户端接收到的值===>:\t" + msg);
		} catch (Exception e) {

		} finally {
			eventLoopGroup.shutdownGracefully();
		}
	}
}
