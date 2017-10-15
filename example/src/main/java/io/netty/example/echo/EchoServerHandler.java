/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.example.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * Handler implementation for the echo server.
 */
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    //这里体现出来的，应该就是
    //事件机制，Object msg 就是消息
    //接收到什么类型，就会触发对应的机制
    // 这是netty 4.0版本，而netty3.0版本，这里是，对应的是MessageEvent
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ctx.write(msg);
        System.out.println("===========开始接收数据=====1======");
        if (msg instanceof ByteBuf) {
            ByteBuf req = (ByteBuf) msg;
            String content = req.toString(Charset.defaultCharset());
        }

        System.out.println("===========开始接收数据====2=======:\t" + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
