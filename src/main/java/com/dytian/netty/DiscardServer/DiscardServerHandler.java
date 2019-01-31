package com.dytian.netty.DiscardServer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler  extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("innnnnnnnnnnnnnn");
        ByteBuf b = (ByteBuf) msg;
        try{
            while (b.isReadable()){
                System.out.print((char) b.readByte());
                System.out.flush();
            }
        }finally {
            ReferenceCountUtil.release(msg);
        }


    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();

    }
}
