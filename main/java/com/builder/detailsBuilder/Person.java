package com.builder.detailsBuilder;

import java.util.Date;

public abstract class Person {
	private String body;
	private String head;
	private String foot;
	/**
	 * 一次编译，终生使用
	 */
	private static final Date date;
	
	static {
		date = new Date("1990-01-01");
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getFoot() {
		return foot;
	}
	public void setFoot(String foot) {
		this.foot = foot;
	}
	
	
	
	
}
