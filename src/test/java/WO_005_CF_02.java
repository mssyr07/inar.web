import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select "ScreenSaver"
 * from Product dropdown. 6-) Leave blank the quantity box. 7-) Enter "20" as discount
 * percentage. 8-) Click on the "Calculate" button. 9-) Verify the invalid Quantity error
 * message is displayed.
 */

public class WO_005_CF_02 extends Hooks {

	List<String> orderInformation = new ArrayList<>();

	@Test
	void testVerifyCalculateFunctionalityInOrderPageInvalidInput() {

		orderInformation.add("ScreenSaver");

		WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderLink.click();

		WebElement validUserNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement validPasswordInputField = driver.findElement(By.id("login-password-input"));

		validUserNameInputField.sendKeys("Inar");
		validPasswordInputField.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement orderButton = driver.findElement(By.xpath("//a[@href='/weborder/order']"));
		orderButton.click();

		WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
		Select productDropdown = new Select(productDropdownElement);

		productDropdown.selectByVisibleText("ScreenSaver"); // orderInformation.get(0)

		WebElement quantityInputField = driver.findElement(By.id("quantityInput"));
		quantityInputField.sendKeys(" ");

		WebElement discountInputField = driver.findElement(By.id("discountInput"));
		discountInputField.sendKeys("20");

		WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
		calculateButton.click();

		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		WebElement warningMessageBox = driver
			.findElement(By.xpath("//em[contains(text(),\"Field 'Quantity' must be greater than zero.\")]"));
		String actualText = warningMessageBox.getText();
		String expectedText = "Field 'Quantity' must be greater than zero.";
		Assertions.assertEquals(expectedText, actualText);

	}

}
