package org.example.proxy;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ReverseProxyInitializer extends ChannelInitializer<SocketChannel> {

    private final ReverseProxyServer server;

    public ReverseProxyInitializer(ReverseProxyServer server){
        this.server = server;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        var pipeline = channel.pipeline();

        // Vi har en proxy handler
        pipeline.addLast(new ReverseProxyHandler(server));
    }
}
