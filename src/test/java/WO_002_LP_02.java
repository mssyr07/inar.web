import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter invalid username
 * "InvalidUserName" and/or password "InvalidPassword". 4-) Click on the "Login" button
 * 5-) Verify that the appropriate error message is displayed.
 */

public class WO_002_LP_02 extends Hooks {

	@Test
	void testVerifyLoginFailure() {
		WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderLink.click();

		WebElement InvalidUsernameInputField = driver.findElement(By.id("login-username-input"));
		WebElement InvalidPasswordInputField = driver.findElement(By.id("login-password-input"));

		InvalidUsernameInputField.sendKeys("InvalidUserName");
		InvalidPasswordInputField.sendKeys("InvalidPassword");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement userNameError = driver.findElement(By.id("username-error-alert"));
		String nameError = userNameError.getText();
		String expectedMessage = "Invalid username";
		Assertions.assertEquals(expectedMessage, nameError, "Wrong match");

		WebElement userPasswordError = driver.findElement(By.id("password-error-alert"));
		String passwordError = userPasswordError.getText();
		String expectedPasswordMessage = "Invalid password";
		Assertions.assertEquals(expectedPasswordMessage, passwordError, "Wrong match");

	}

}
