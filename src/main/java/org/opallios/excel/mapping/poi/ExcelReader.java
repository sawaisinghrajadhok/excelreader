package org.opallios.excel.mapping.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date; 
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.opallios.excel.mapping.model.RevenueSummary;
import org.opallios.excel.mapping.yml.Bank;
import org.opallios.excel.mapping.yml.ConfiguredData;
import org.opallios.excel.mapping.yml.Year;

public class ExcelReader {
	
	public static List<RevenueSummary> read(ConfiguredData configuredData) throws IOException,
			ParseException {
		List<RevenueSummary> summaries = null;
		if (configuredData.getRevenueSummaryFilePath() == null || configuredData.getRevenueSummaryFilePath().equals("")) {
			throw new FileNotFoundException("GTP Revenue file is path empty in configuration.yml file");
		}
		try (InputStream inputStream = new FileInputStream(configuredData.getRevenueSummaryFilePath());
				Workbook workbook = new XSSFWorkbook(inputStream);) {
			Sheet sheet = workbook.getSheetAt(0);

			Map<String, Year> yearMap = configuredData.getYears();
			Set<String> yearKeySet = yearMap.keySet();

			Map<String, Bank> bankMap = configuredData.getBanks();
			Set<String> bankKeySet = bankMap.keySet();
			summaries = new ArrayList<RevenueSummary>();
			for (String yearKey : yearKeySet) {
				int i = yearMap.get(yearKey).getStart();
				int month = 0;
				for (; i < yearMap.get(yearKey).getStart() + 12; i++) {
					month++;
					for (String bankkey : bankKeySet) {
						String category = null;
						Iterator<Row> iterator = sheet.iterator();
						RevenueSummary summary = new RevenueSummary();
						summary.setBankId(bankkey);
						SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-yyyy");
						Date date = DATE_FORMAT.parse("" + month + "-" + yearKey);
						summary.setMonth(date);
						while (iterator.hasNext()) {
							Row row = iterator.next();
							if (row.getRowNum() >= bankMap.get(bankkey).getStart() && row.getRowNum() <= bankMap.get(bankkey).getEnd()) {
								Cell fieldCell = row.getCell(yearMap.get(yearKey).getStart() - 1);
								Cell valueCell = row.getCell(i);
								String fieldCellInString = fieldCell.getStringCellValue().trim();
								if (fieldCellInString != null && !fieldCellInString.equals("")) {
									if (fieldCellInString.equals("POS Purchases")) {
										category = "POS";
									} else if (fieldCellInString.equals("Total Net Revenue") || fieldCellInString.equals("Card Loads") || fieldCellInString.equals("Maintenance Fees")) {
										category = null;
									}
									if (valueCell != null) {
										switch (valueCell.getCellType()) {
											case Cell.CELL_TYPE_NUMERIC:
										case Cell.CELL_TYPE_FORMULA:
											fieldMapping(summary, fieldCellInString, valueCell.getNumericCellValue(), category);
											break;
										}
									}
								}
							} else if (row.getRowNum() > bankMap.get(bankkey).getEnd()) {
								break;
							}
						}
						summaries.add(summary);
					}
				}
			}
		}
		return summaries;
	}

	private static void fieldMapping(RevenueSummary summary, String field, double numericValue, String category) {
		if (category != null && category.equals("POS")) {
			field = "POS " + field;
		}
		switch (field) {
		case "Active Cards":
			summary.setActiveCards((long) numericValue);
			break;
		case "Total Transactions":
			summary.setTotalTransactions((long) numericValue);
			break;
		case "Total Net Revenue":
			summary.setTotalNetRevenue(numericValue);
			break;
		case "ATM Count":
			summary.setAtmCount((long) numericValue);
			break;
		case "Transaction Revenue":
			summary.setAtmTranRevenue(numericValue);
			break;
		case "OIF":
			summary.setAtmOIF(numericValue);;
			break;
		case "ISA":
			summary.setAtmISA(numericValue);;
			break;
		case "Visa Transaction Fees":
			summary.setAtmVisaTranFee(numericValue);
			break;
		case "ATM NET Revenue":
			summary.setAtmNetRevenue(numericValue);
			break;
		case "POS POS Count":
			summary.setPosCount(numericValue);
			break;
		case "POS Transaction Revenue":
			summary.setPosTranRevenue(numericValue);
			break;
		case "POS Interchange":
			summary.setPosInterchange(numericValue);
			break;
		case "POS OIF":
			summary.setPosOIF(numericValue);
			break;
		case "POS ISA":
			summary.setPosISA(numericValue);
			break;
		case "POS Visa Transaction Fees":
			summary.setPosVisaTranFee(numericValue);
			break;
		case "POS POS NET Revenue":
			summary.setPosNetRevenue(numericValue);
			break;
		case "Load Count":
			summary.setLoadCount(numericValue);
			break;
		case "Card Load Revenue":
			summary.setCardLoadRevenue(numericValue);
			break;
		case "Maintenance Fees":
			summary.setMaintenanceFees(numericValue);
			break;
		case "Processing Fees":
			summary.setProcessingFees(numericValue);
			break;
		case "SMS Fees":
			summary.setSmsFees(numericValue);
			break;
		case "Manual Adjustments":
			summary.setManualAdj(numericValue);
			break;
		case "Tier 2 Customer Svc":
		case "Tier 2 Support":
			summary.setTier2CustomerSvc(numericValue);
			break;
		case "Visa Chargebacks":
			summary.setVisaChargebacks(numericValue);
			break;
		case "Card Sales":
			summary.setCardSales(numericValue);
			break;
		case "Active Card Fees":
		case "Active Card Fee":
			summary.setActiveCardFee(numericValue);
			break;
		case "Registered Card Fee":
		case "Registered Cards":
			summary.setRegisteredCardFee(numericValue);
			break;
		case "SubCompany Set Up Fee":
			summary.setSubCompanySetUpFee(numericValue);
			break;
		case "Inactive Card Fee":
			summary.setInactiveCardFee(numericValue);
			break;
		case "API Fees":
			summary.setApiFees(numericValue);
			break;
		case "Visa Monthly Billing":
			summary.setVisaMonthlyBilling(numericValue);
			break;
		}
	}
}
