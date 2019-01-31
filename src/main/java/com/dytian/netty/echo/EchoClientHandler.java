package com.dytian.netty.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class EchoClientHandler extends SimpleChannelInboundHandler<UnixTime> {


   // private final   ByteBuf firstMessage;

    public EchoClientHandler() {
//        firstMessage = Unpooled.buffer(8);
//        for (int i = 0;i < firstMessage.capacity();i++){
//            firstMessage.writeByte((byte)i);
//        }

    }





    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("contetddddddddddddddddd");
        for (int i = 0;i < 5;i++){
            UnixTime unixTime = new UnixTime();
            ctx.writeAndFlush(unixTime);
        }
    }



//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ctx.write(msg);
//
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, UnixTime unixTime) throws Exception {

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
