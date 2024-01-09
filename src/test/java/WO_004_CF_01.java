import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select "HomeDecor"
 * from Product dropdown. 6-) Enter "5" as quantity number. 7-) Enter "15" as discount
 * percentage. 8-) Click on the "Calculate" button. 9-) Verify that the total amount is
 * successfully displayed
 */

public class WO_004_CF_01 extends Hooks {

	List<String> orderInformation = new ArrayList<>();

	@Test
	void VerifyCalculateFunctionalityInOrderPage() throws InterruptedException {
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

		WebElement productDropdown = driver.findElement(By.xpath("//*[@id=\"productSelect\"]")); ///////////////////
		Select productSelect = new Select(productDropdown);
		productSelect.selectByVisibleText("HomeDecor");

		orderInformation.add("FamilyAlbum");

		WebElement quantityInputField = driver.findElement(By.id("quantityInput"));
		quantityInputField.sendKeys("5");

		WebElement discountPercentageInputField = driver.findElement(By.id("discountInput"));
		discountPercentageInputField.sendKeys("15");

		WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
		calculateButton.click();

		// Thread.sleep(2000);
		WebElement totalAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalInput")));
		String displayedTotalAmount = totalAmount.getText();

	}

}
