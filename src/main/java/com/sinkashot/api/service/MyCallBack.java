package com.sinkashot.api.service;

import io.netty.channel.ChannelHandlerContext;

public interface MyCallBack {
	/**
	 * 연결 시  동작 메소드
	 * @param String read
	 */
	public void connect(ChannelHandlerContext ctx);
	
	/**
	 * 데이터 수신 시 동작 메소드
	 * @param String read
	 */
	public void read(String read);
	
	/**
	 * 데이터 전송 시 동작 메소드
	 * @param String read
	 */
	public String write(String msg);
	
	/**
	 * 종료 시  동작 메소드
	 * @param String read
	 */
	public void disconnect(ChannelHandlerContext ctx);
}
