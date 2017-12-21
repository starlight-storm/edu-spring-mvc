package com.example.customer.web.codelist;

import com.example.common.web.codelist.EnumValues;

public enum EmailNotificationValues implements EnumValues {
	YES("1", "あり"), NO("2", "なし");

	private final String value;
	private final String text;
	
	private EmailNotificationValues(String value, String text) {
		this.value = value;
		this.text = text;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getText() {
		return text;
	}
}