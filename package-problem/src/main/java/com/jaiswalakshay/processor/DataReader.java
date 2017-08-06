package com.jaiswalakshay.processor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.jaiswalakshay.model.RawData;
import com.jaiswalakshay.model.Thing;

public class DataReader {
	public static List<RawData> readDetailsFromFile(String filePath) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.err.println("Error while reading given file : \n Message " + e.getMessage());
			e.printStackTrace();
		}
		return parseRawPackage(lines);

	}

	private static List<RawData> parseRawPackage(List<String> lines) {
		List<RawData> listOfRawPackage = new ArrayList<>();
		for (String line : lines) {
			List<Thing> listOfThings = new ArrayList<>();
			line = line.replaceAll("\\s+", "");
			line = line.replaceAll("\\(", "");
			line = line.replaceAll("\\$", "");
			String[] parts = line.split(":");
			String[] things = parts[1].split("\\)");
			if(things.length > 15){
				throw new RuntimeException("Number of things for each data set should not exceed 15");
			}
			String[] fields;
			for (String thing : things) {
				fields = thing.split(",");
				int index = Integer.parseInt(fields[0]);
				double weight = Double.parseDouble(fields[1]);
				double cost = Double.parseDouble(fields[2]);
				listOfThings.add(new Thing(index, weight, cost));
			}
			double weightlimit = Double.parseDouble(parts[0]);
			listOfRawPackage.add(new RawData(listOfThings, weightlimit));
		}
		return listOfRawPackage;
	}
}
