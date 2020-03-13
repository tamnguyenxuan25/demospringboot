package com.spring.example.springBootApiDemo.config;

public enum WorkStatus {
	PLANNING(0),
	DOING(1),
	COMPLETED(2);
	
	private final int value;

    private WorkStatus(int value) {
        this.value = value;
    }
}
