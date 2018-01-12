package com.example.customer.web.codelist;

import com.example.common.web.codelist.EnumValues;

public enum CustomerTypeValues implements EnumValues {
	PLATINUM("1", "プラチナ"), GOLD("2", "ゴールド"), SILVER("3", "シルバー");

	private final String value;
	private final String text;
	
	private CustomerTypeValues(String value, String text) {
		this.value = value;
		this.text = text;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getText() {
		return text;
	}
	
	
}