package com.sinkashot.api.handler;

import java.nio.charset.Charset;

import com.sinkashot.api.service.MyCallBack;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelHandler.Sharable;

@Sharable
public class MyServerHandler extends ChannelInboundHandlerAdapter {
	private static final Charset CHARSET = Charset.forName("EUC_KR");
	private MyCallBack writer;
	
	public MyServerHandler(MyCallBack write) {
		this.writer = write;
	}
	
	/**
	 * 연결 이벤트
	 * @param ctx ChannelHandlerContext
	 */
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		try {
			if (writer != null) {
				writer.connect(ctx);
			}
			super.channelRegistered(ctx);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf inBuffer = (ByteBuf) msg;
		String received = inBuffer.toString(CHARSET);
		
		if (writer == null) {
			System.out.println("server received : "+received);
			ctx.write(Unpooled.copiedBuffer("echo : "+received, CHARSET));
		} else {
			writer.read(received);
			String arg = writer.write(received);
			ctx.write(Unpooled.copiedBuffer(arg.toCharArray(), CHARSET));
			System.out.println("server send : "+received);
		}
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
	/**
	 * 종료 이벤트
	 * @param ctx ChannelHandlerContext
	 */
	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		if (writer != null) {
			writer.disconnect(ctx);
		}
		super.channelUnregistered(ctx);
	}
}
