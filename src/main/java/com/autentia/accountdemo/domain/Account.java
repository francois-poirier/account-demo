package com.autentia.accountdemo.domain;

public class Account {
	private String name;

	public Account(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
