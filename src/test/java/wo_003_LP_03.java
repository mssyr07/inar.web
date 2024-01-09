import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1-) Open the URL 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
 * "Inar" and password "Academy". 4-) Click "Logout" button. 5-) Verify logout su
 */

public class wo_003_LP_03 extends Hooks {

	@Test
	void testVerifyLogoutFunctionality() {
		WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderLink.click();

		WebElement validUserNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement validPasswordInputField = driver.findElement(By.id("login-password-input"));

		validUserNameInputField.sendKeys("Inar");
		validPasswordInputField.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement logOutButton = driver.findElement(By.id("logout-button"));
		logOutButton.click();

	}

}
