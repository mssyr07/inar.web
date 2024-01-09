import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1-) Open the URL 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
 * "Inar" and password "Academy". 4-) Navigate to the view all order page. 5-) Click "Add
 * More Data" "8" times. 6-) Click 1st, 3rd and 5th orders checkbox's. 7-) Click "Delete
 * All" button. 8-) Verify the orders are deleted.
 */
public class WO_012_VAO_03 extends Hooks {

    @Test
    void testVerifyDeleteFunctionalityInViewAllOrderPage() {
        // 2. Click on weborder link
        WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderLink.click();

        // 3. Enter "Inar" as username and "Academy" password.
        WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
        WebElement passwordInputField = driver.findElement(By.id("login-password-input"));

        userNameInputField.sendKeys("Inar");
        passwordInputField.sendKeys("Academy");

        // Click on the "Login" button.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        for (int i = 0; i < 6; i++) {
            WebElement addMore4Data = driver.findElement(By.xpath("//button[text()='Add More Data']"));
            addMore4Data.click();
        }
        WebElement allOrdersSelected_1 = driver.findElement(By.xpath("(//input[@class='form-check-input'])[1]"));
        allOrdersSelected_1.click();

        WebElement allOrdersSelected_3 = driver.findElement(By.xpath("(//input[@class='form-check-input'])[3]"));
        allOrdersSelected_3.click();

        WebElement allOrdersSelected_5 = driver.findElement(By.xpath("(//input[@class='form-check-input'])[5]"));
        allOrdersSelected_5.click();
    }

}
