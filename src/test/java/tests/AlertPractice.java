package tests;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPracticeAlert {
    public static void main(String[] args) {
        // Initialize WebDriver (Chrome)
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Open the practice page
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            System.out.println("Opened: " + driver.getTitle());
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Step 2: Select any option from Checkbox Example and click
            // Let's select Option2 as an example
            WebElement option2Checkbox = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"checkBoxOption2\"]")));
            option2Checkbox.click();

            // Step 3: Grab the label of the selected checkbox
            WebElement option2Label = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/following-sibling::label"));
            String selectedOption = option2Label.getText();
            System.out.println("Selected checkbox label: " + selectedOption);

            // Step 4: Select the same option from Dropdown Example
            WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
            Select select = new Select(dropdown);
            select.selectByVisibleText(selectedOption);

            // Step 5: Enter the label value into the edit-box and click "Alert"
            WebElement alertInput = driver.findElement(By.id("name"));
            alertInput.sendKeys(selectedOption);

            WebElement alertButton = driver.findElement(By.id("alertbtn"));
            alertButton.click();

            Thread.sleep(10000);

            // Step 6: Verify the text in the popup message
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);

            // Verify the expected text format
            String expectedText = "Hello " + selectedOption + ", share this practice page and share your knowledge";
            if(alertText.equals(expectedText)) {
                System.out.println("Alert message verification PASSED");
            } else {
                System.out.println("Alert message verification FAILED");
                System.out.println("Expected: " + expectedText);
                System.out.println("Actual: " + alertText);
            }

            // Accept the alert
            alert.accept();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
