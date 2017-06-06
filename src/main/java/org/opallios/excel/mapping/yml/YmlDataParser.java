package org.opallios.excel.mapping.yml;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YmlDataParser {
	public static ConfiguredData parseYml(String filePath) throws Exception {
		return new ObjectMapper(new YAMLFactory()).readValue(new File(filePath), ConfiguredData.class);
	}
}