package com.meiit.webalk.aci3x3;

public enum WingType {

	EAST("East", 0), WEST("West", 1), NORTH("North", 2), SOUTH("South", 3);
	
	private String text;
	private Integer code;

	private WingType(String text, int code) {
		this.text = text;
		this.code = code;
	}
	
	@Override
	public String toString() {
		return this.text;
	}

	public Integer getCode(){
		return code;
	}
}
