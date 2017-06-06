package org.opallios.excel.mapping;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.opallios.excel.mapping.constant.Constant;
import org.opallios.excel.mapping.model.RevenueSummary;
import org.opallios.excel.mapping.poi.ExcelReader;
import org.opallios.excel.mapping.repository.RevenueSummaryRepository;
import org.opallios.excel.mapping.yml.ConfiguredData;
import org.opallios.excel.mapping.yml.YmlDataParser;

public class CenterlizedController {
	
	public static void call(String[] args) throws Exception {
		ConfiguredData configuredData = getConfiguration(Constant.CONFIGURATION_FILE_PATH);
		configuredData = userInputValidation(args, configuredData);
		
		// for testing only
		//printConfigurationDetailsForUser(configuredData);
		
		List<RevenueSummary> summaries = readExcelDataOnConfigurationBases(configuredData);
		
		saveExcelDataIntoDB(summaries, configuredData);
	}
	
	private static ConfiguredData getConfiguration(String filePath) throws Exception {
		return  YmlDataParser.parseYml(filePath);
	}
	
	private static ConfiguredData userInputValidation(String[] args, ConfiguredData configuredData) throws Exception {
		return UserInputValidation.getConfiguration(args, configuredData);
	}
	
	private static List<RevenueSummary> readExcelDataOnConfigurationBases(ConfiguredData configuredData) throws IOException, ParseException {
		return ExcelReader.read(configuredData);
	}
	
	private static void saveExcelDataIntoDB(List<RevenueSummary> summaries, ConfiguredData configuredData) {
		RevenueSummaryRepository repository = new RevenueSummaryRepository();
		boolean reply = repository.save(summaries, configuredData);
		if (reply)
			System.out.println("======================Record Entered Successfully=========================");
	}
	
	/*private static void printConfigurationDetailsForUser(ConfiguredData configuredData) {
		Set<String> years = configuredData.getYears().keySet();
		System.out.println("-------------Years--------------");
		for (String year : years) {
			System.out.println(year);
		}
		Set<String> banks = configuredData.getBanks().keySet();
		System.out.println("-------------Banks--------------");
		for (String bank : banks) {
			System.out.println(bank);
		}
	}*/
}
