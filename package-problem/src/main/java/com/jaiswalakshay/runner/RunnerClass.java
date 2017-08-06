package com.jaiswalakshay.runner;

import java.util.List;

import com.jaiswalakshay.model.Package;
import com.jaiswalakshay.model.RawData;
import com.jaiswalakshay.processor.DataReader;
import com.jaiswalakshay.processor.PackageProcessor;
		
public class RunnerClass {
	public static void main(String[] args) {

		String filePath = args.length > 0 ? args[0] : "/home/vagrant/Desktop/data.txt";
		List<RawData> listOfRawData = DataReader.readDetailsFromFile(filePath);
		for (RawData raw : listOfRawData) {
			Package _package = PackageProcessor.getPackage(raw.getAllTheThings(), raw.getWeightLimit());
			System.out.println(_package);
		}

	}
}
