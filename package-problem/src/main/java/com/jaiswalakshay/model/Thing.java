package com.jaiswalakshay.model;

public class Thing {
	private int index;
	private double weight;
	private double cost;

	public Thing() {
		super();
	}

	public Thing(int index, double weight, double cost) {
		super();
		this.index = index;
		this.weight = weight;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return String.valueOf(index);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
