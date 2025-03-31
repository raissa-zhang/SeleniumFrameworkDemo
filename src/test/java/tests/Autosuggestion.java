package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class Autosuggesting {
    public static void main(String[] args) {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Step 1: Open the practice page
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            wait.until(ExpectedConditions.titleContains("Practice"));

            // Step 2: Locate and type "united" in the suggestion box
            WebElement suggestionBox = driver.findElement(By.id("autocomplete"));
            suggestionBox.sendKeys("united");

            // Wait for suggestions to appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("ul.ui-autocomplete li")));

            // Step 3: Select "United Kingdom (UK)" from suggestions
            List<WebElement> suggestions = driver.findElements(
                    By.cssSelector("ul.ui-autocomplete li"));

            for (WebElement suggestion : suggestions) {
                if (suggestion.getText().equals("United Kingdom (UK)")) {
                    suggestion.click();
                    break;
                }
            }

            // Verify selection
            String selectedValue = suggestionBox.getAttribute("value");
            System.out.println("Selected country: " + selectedValue);

            if (selectedValue.equals("United Kingdom (UK)")) {
                System.out.println("Successfully selected United Kingdom (UK)");
            } else {
                System.out.println("Failed to select United Kingdom (UK)");
            }

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}