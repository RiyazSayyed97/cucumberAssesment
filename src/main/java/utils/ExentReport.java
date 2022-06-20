package utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ExentReport {
	public static ExtentReports init() {
		return new ExtentReports(System.getProperty("user.dir")+"\\outputs\\Reports\\Extent.html",false);
	}

}
