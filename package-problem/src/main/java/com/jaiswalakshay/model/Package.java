package com.jaiswalakshay.model;

import java.util.Set;
import java.util.StringJoiner;

public class Package {
	private double totalWeight;
	private double totalCost;
	private Set<Thing> listOfThing;

	public Package() {
		super();
	}

	public Package(double totalWeight, double totalCost, Set<Thing> listOfThing) {
		super();
		this.totalWeight = totalWeight;
		this.listOfThing = listOfThing;
		this.totalCost = totalCost;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public Set<Thing> getListOfThing() {
		return listOfThing;
	}

	public void setListOfThing(Set<Thing> listOfThing) {
		this.listOfThing = listOfThing;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(",");
		if (!listOfThing.isEmpty()) {
			listOfThing.forEach(x -> {
				joiner.add(String.valueOf(x.getIndex()));
			});
			return joiner.toString();
		} else {
			return "-";
		}
	}

}
