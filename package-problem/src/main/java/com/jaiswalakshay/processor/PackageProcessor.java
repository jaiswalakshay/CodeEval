package com.jaiswalakshay.processor;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.common.collect.Sets;
import com.jaiswalakshay.model.Package;
import com.jaiswalakshay.model.Thing;

public class PackageProcessor {

	public static Package getPackage(List<Thing> things, double maxPackageWeight) {
		Set<Set<Thing>> possibleCombinations = Sets.powerSet(Sets.newHashSet(things));
		Comparator<Package> costComparator = (o1, o2) -> ((Double) o1.getTotalCost()).compareTo(o2.getTotalCost());
		SortedSet<Package> intermediateResult = new TreeSet<Package>(costComparator);
		possibleCombinations.forEach(subSet -> {
			double totalWeight = 0.0;
			double totalCost = 0.0;
			for (Thing thing : subSet) {
				totalWeight = (double) totalWeight + thing.getWeight();
				totalCost = (double) totalCost + thing.getCost();
			}
			if (totalWeight <= maxPackageWeight) {
				intermediateResult.add(new Package(totalWeight, totalCost, subSet));
			}
		});
		return intermediateResult.last();
	}
}
