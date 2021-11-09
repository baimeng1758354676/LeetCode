package com.honor.netty.discard.timeServer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Description
 * @Author baimeng
 * @Date 2021/11/9 10:17
 **/
public class TimeServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        ByteBuf buffer = ctx.alloc().buffer(8);
        buffer.writeLong(System.currentTimeMillis());
        ChannelFuture channelFuture = ctx.writeAndFlush(buffer);

        channelFuture.addListener((ChannelFutureListener) channelFuture1 -> ctx.close());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
