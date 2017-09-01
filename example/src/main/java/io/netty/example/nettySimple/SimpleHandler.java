package io.netty.example.nettySimple;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * Created by erjun on 2017/9/1.
 */
public class SimpleHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("===========开始接收数据===========");
		if (msg instanceof ByteBuf) {
			ByteBuf req = (ByteBuf) msg;
			String content = req.toString(Charset.defaultCharset());
			System.out.println("-------->:\t" + content);
			ctx.channel().writeAndFlush("你好，我是李四\r\n");

		}
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		super.userEventTriggered(ctx, evt);
	}
}
