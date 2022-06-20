package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static String takeScreenshotAs(WebDriver driver, String file1) throws IOException {
		String logFileName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
		file1 += logFileName;
		String Directory = System.getProperty("user.dir") + "\\outputs\\Screenshot\\";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(Directory + file1));
		String destination = Directory + file1;
		return destination;

	}

}
