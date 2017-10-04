/*
 * Copyright 2016 The Netty Project
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
package io.netty.channel.socket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;

import java.net.Socket;

/**
 * duplex:双工，双向
 * 因此，这里是指
 * 双向通道，独立关闭
 * A duplex {@link Channel} that has two sides that can be shutdown independently.
 */
//DuplexChannel 是双向通道的意思
//此接口，声明的方法，基本上全是 关闭通道的
public interface DuplexChannel extends Channel {
    /**
     * Returns {@code true} if and only if the remote peer shut down its output so that no more
     * data is received from this channel.  Note that the semantic of this method is different from
     * that of {@link Socket#shutdownInput()} and {@link Socket#isInputShutdown()}.
     */
    //如果客户端关闭了通道的话，服务器端就不会通过此通道接受到数据了
    //不同于java原生的Socket的shutdownInput() 以及  isInputShutdown()
    boolean isInputShutdown();

    /**
     * @see Socket#shutdownInput()
     */
    //可以参考java原生的shutdownInput()方法
    ChannelFuture shutdownInput();

    /**
     * Will shutdown the input and notify {@link ChannelPromise}.
     *
     * @see Socket#shutdownInput()
     */
    ChannelFuture shutdownInput(ChannelPromise promise);

    /**
     * @see Socket#isOutputShutdown()
     */
    boolean isOutputShutdown();

    /**
     * @see Socket#shutdownOutput()
     */
    ChannelFuture shutdownOutput();

    /**
     * Will shutdown the output and notify {@link ChannelPromise}.
     *
     * @see Socket#shutdownOutput()
     */
    ChannelFuture shutdownOutput(ChannelPromise promise);

    /**
     * Determine if both the input and output of this channel have been shutdown.
     */
    boolean isShutdown();

    /**
     * Will shutdown the input and output sides of this channel.
     * @return will be completed when both shutdown operations complete.
     */
    //关闭的是Channel的两个方向
    ChannelFuture shutdown();

    /**
     * Will shutdown the input and output sides of this channel.
     * @param promise will be completed when both shutdown operations complete.
     * @return will be completed when both shutdown operations complete.
     */
    ChannelFuture shutdown(ChannelPromise promise);
}
