package io.lofrattini.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtils {
	
	public static File takeScreenshot(WebDriver driver, String filename) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File(filename);
		FileUtils.copyFile(scrFile, screenshotFile);
		return screenshotFile;
	}

}
