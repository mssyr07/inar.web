import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 1-) Open the URL 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
 * "Inar" and password "Academy". 4-) Navigate to the view all order page. 5-) Click
 * "AddMore Data" "4" times. 6-) Click "Check All" button. 7-) Verify all orders selected.
 */
public class WO_010_VAO_01 extends Hooks {

    @Test
    void testVerifyCheckAllFunctionalityInViewAllOrderPage() {
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

        for (int i = 0; i < 4; i++) {
            WebElement addMore4Data = driver.findElement(By.xpath("//button[text()='Add More Data']"));
            addMore4Data.click();
        }
    }

}
