import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter "Inar" as username
 * and "Academy" password. 4-) Click on the "Login" button. 5-) Verify that the use
 */
public class WO_001_LP_01 extends Hooks {

	@Test
	void testLoginProcessWithValidCredentials() {

		WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderLink.click();

		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement userPasswordInputField = driver.findElement(By.id("login-password-input"));

		userNameInputField.sendKeys("Inar");
		userPasswordInputField.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

	}

}
