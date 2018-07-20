package com.rpm.domain;

public class Numbers {
	private int numbers;

	public Numbers() {
	}

	public Numbers(int numbers) {
		this.numbers = numbers;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return "Numbers [numbers=" + numbers + "]";
	}
}
