package org.opallios.excel.mapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.opallios.excel.mapping.yml.Bank;
import org.opallios.excel.mapping.yml.ConfiguredData;
import org.opallios.excel.mapping.yml.Year;

public class UserInputValidation {
	
	public static ConfiguredData getConfiguration(String args[], ConfiguredData configuredData) throws Exception {
		if (args.length == 2) {
			configuredData = mapForYear(args[0], configuredData);
			Map<String, Bank> bankMap = new HashMap<String, Bank>(); 
			Bank bank = configuredData.getBanks().get(args[1]);
			if (bank == null) 
				printConfigurationData(configuredData.getBanks().keySet(), "Available banks: ", "Bank " + args[1] + " data is not configured.");	
			bankMap.put(args[1], bank);
			configuredData.setBanks(bankMap);
		} else if (args.length == 1) {
			configuredData = mapForYear(args[0], configuredData);
		}
		return configuredData;
	}
	
	private static ConfiguredData mapForYear(String args0, ConfiguredData configuredData) throws Exception {
		Map<String, Year> yearMap = new HashMap<String, Year>();
		Year year = configuredData.getYears().get(args0);
		if (year == null) { 
			printConfigurationData(configuredData.getYears().keySet(), "Available years: ", "Year " + args0 + " data is not configured.");
		}
		yearMap.put(args0, year);
		configuredData.setYears(yearMap);
		return configuredData;
	}
	
	private static void printConfigurationData(Set<String> keys,String msg1, String msg2) throws Exception {
		System.err.print(msg1);
		System.out.println();
		for (String key : keys) {
			System.out.println(key);
		}
		throw new Exception(msg2);
	}
}
