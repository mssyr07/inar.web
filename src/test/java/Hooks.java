import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {

	protected static WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@BeforeAll
	public static void setUpBeforeTest() {
		String browser = System.getProperty("browserType", "chrome");

		switch (browser.toLowerCase()) {
			case "firefox":
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--width=1920");
				firefoxOptions.addArguments("--height=1080");
				driver = new FirefoxDriver(firefoxOptions);
				break;
			case "edge":
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("--start-maximized");
				edgeOptions.addArguments("--ignore-certificate-errors");
				break;
			case "chrome":
			default:
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("--ignore-certificate-errors");
				driver = new ChromeDriver(chromeOptions);
				break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
	}

	@AfterAll
	public static void tearDown() {
		if (driver != null)
			driver.quit();
	}

}