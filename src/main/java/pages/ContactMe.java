package pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.BrowserMgr;
import utils.ReadPropertyFile;

public class ContactMe {
	public static WebDriver driver;
	public static WebElement element;
	public static List<WebElement> elements;
    private static String expected;
    private static String actual;
	public static void openURL(String browser) throws IOException {
		driver = BrowserMgr.setProperty(driver, ReadPropertyFile.readFileBrwoserProperty(browser));
		driver.get(ReadPropertyFile.readFileBaseURLProperty());
	}

	public static WebElement nameField(WebDriver driver) {
		String xPath = "//*[@id='name']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement emailField(WebDriver driver) {
		String id = "email";
		element = driver.findElement(By.id(id));
		return element;
	}

	public static WebElement gender(WebDriver driver) {
		String xPath = "//input[@type='radio' and @id='radio']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static void enterName(String name) {
		ContactMe.nameField(ContactMe.driver).sendKeys(name);
	}

	public static void sendEmail(String mail) {
		ContactMe.emailField(driver).sendKeys(mail);
		;
	}

	public static void chooseGender() {
		ContactMe.gender(driver).click();
	}

	public static WebElement dropDown(WebDriver driver) {
		String xPath = "/html/body/center/table/tbody/tr/td//select";
		driver.findElement(By.xpath(xPath));
		return element;

	}

	public static WebElement frame(WebDriver driver) {
		String xPath = "//iframe[@id='dropdown']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement simpleAlert(WebDriver driver) {
		String xPath = "//button[@id='alert']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement dismssAlert(WebDriver driver) {
		String xPath = "//button[@id='alertD']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement mouseOverTo(WebDriver driver) {
		String xPath = "//img[@id='fourth']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static List<WebElement> options(WebDriver driver) {
		String xPath = "/html/body/center/table/tbody/tr/td//select/option";
		elements = driver.findElements(By.xpath(xPath));
		return elements;
	}

	public static void selectForJobs() throws InterruptedException {

		ContactMe.driver.switchTo().frame(ContactMe.frame(driver));
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/center/table/tbody/tr/td/select")))
				.click();
		for (WebElement element : ContactMe.options(driver)) {
			if (element.getText().equals("For job")) {
				element.click();
			}

		}
		driver.switchTo().parentFrame();

	}

	public static void acceptSimpleAlert() {
		ContactMe.simpleAlert(driver).click();
		driver.switchTo().alert().accept();
	}

	public static void dismissPrompt() {
		ContactMe.dismssAlert(driver).click();
		driver.switchTo().alert().dismiss();
	}

	public static void moveToElem() {
		Actions action = new Actions(driver);
		action.moveToElement(ContactMe.mouseOverTo(driver)).perform();
	}

	public static void refreshBrowser() {
		ContactMe.driver.navigate().refresh();
		ContactMe.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// ContactMe.driver.close();
	}
	public static void confirmCorrectUrl() {
		expected="ContactMe";
		actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		System.out.println("On correct page");
		
	}

}
