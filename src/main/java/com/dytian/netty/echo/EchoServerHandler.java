package com.dytian.netty.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class EchoServerHandler extends SimpleChannelInboundHandler<UnixTime> {


//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf b = (ByteBuf) msg;
//        while (b.isReadable()){
//            byte b1 = b.readByte();
//            System.out.println("recived content ==="+b1);
//        }
//        ctx.write(msg);
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, UnixTime unixTime) throws Exception {
        System.out.println("sfaddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        System.out.println(unixTime.getValue());

    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
