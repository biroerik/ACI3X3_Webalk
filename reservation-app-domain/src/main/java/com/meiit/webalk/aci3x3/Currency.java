package com.meiit.webalk.aci3x3;

public enum Currency {

	HUF(1), EUR(2), USD(3);

	private Integer code;

	private Currency(int number) {
		this.code = number;
	}

	public Integer getCode() {
		return code;
	}
}
