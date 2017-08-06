package com.jaiswalakshay.model;

import java.util.List;

public class RawData {
	private List<Thing> allTheThings;
	private double weightLimit;
	
	public RawData() {
		super();
	}
	public RawData(List<Thing> allTheThings, double weightLimit) {
		super();
		this.allTheThings = allTheThings;
		this.weightLimit = weightLimit;
	}
	public double getWeightLimit() {
		return weightLimit;
	}
	public void setWeightLimit(double weightLimit) {
		this.weightLimit = weightLimit;
	}
	public List<Thing> getAllTheThings() {
		return allTheThings;
	}
	public void setAllTheThings(List<Thing> allTheThings) {
		this.allTheThings = allTheThings;
	}

}
