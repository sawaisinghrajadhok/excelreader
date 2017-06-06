package org.opallios.excel.mapping.yml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public final class ConfiguredData {
	
	private Map<String, Year> years;
	private Map<String, Bank> banks;
	private String revenueSummaryFilePath = "";
	private short batchSize = 10;
	private String username;
	private String password;
	private String url;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, Year> getYears() {
		return years;
	}
	public void setYears(Map<String, Year> years) {
		this.years = years;
	}
	public Map<String, Bank> getBanks() {
		return banks;
	}
	public void setBanks(Map<String, Bank> banks) {
		this.banks = banks;
	}
	public String getRevenueSummaryFilePath() {
		return revenueSummaryFilePath;
	}
	public void setRevenueSummaryFilePath(String revenueSummaryFilePath) throws FileNotFoundException {
		File file = new File(revenueSummaryFilePath);
		if (file.exists()) {
			this.revenueSummaryFilePath = revenueSummaryFilePath;
		} else {
			throw new FileNotFoundException(revenueSummaryFilePath);
		}
	}
	public short getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(short batchSize) {
		if (batchSize > 10 && batchSize < 150) {
			this.batchSize = batchSize;
		}	
	}
}
