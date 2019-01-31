package com.dytian.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class EchoClient {


    void connect () throws Exception{

        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap b = new Bootstrap();
        try {
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoClientHandler());
                        }
                    });


            ChannelFuture f = b.connect("127.0.0.1", 8087).sync();
            f.channel().closeFuture().sync();


        } finally {
            group.shutdownGracefully();
        }


    }


    public static void main(String[] args) throws Exception {


        new EchoClient().connect();

    }


}
