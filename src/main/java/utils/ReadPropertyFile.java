package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	public static String readFileBrwoserProperty(String browser) throws IOException {
		File file = new File("src/main/java/configuration/configuration.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		// fetching the value from properties file
		// String Name_Value = prop.getProperty("Name");
		String BrowserName_Value = prop.getProperty(browser);
		return BrowserName_Value;

	}

	public static String readFileBaseURLProperty() throws IOException {
		File file = new File("src/main/java/configuration/configuration.properties");
		// Create FileInputstream object to read the file
		FileInputStream fileInput = new FileInputStream(file);
		// Create properties class object
		Properties prop = new Properties();
		// Load the property file in Inputstream
		prop.load(fileInput);
		// fetching the value from properties file
		// String Name_Value = prop.getProperty("Name");
		String BaseURL = prop.getProperty("baseURL");
		return BaseURL;

	}

}
