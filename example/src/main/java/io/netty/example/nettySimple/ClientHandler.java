package io.netty.example.nettySimple;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;

/**
 * Created by erjun on 2017/9/1.
 */
public class ClientHandler  extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// 下面，将接收到的值，写到通道里
		ctx.channel().attr(AttributeKey.valueOf("ChannelKey")).set(msg.toString());
		// 短连接，获取完成后，关闭连接
		// 如果不关闭的话，客户端是获取不到数据的
		ctx.channel().close();
	}
}
