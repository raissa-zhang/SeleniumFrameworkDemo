package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityDialogPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // 定位器
    private final By titleInput = By.xpath("//label[contains(text(),'活动标题')]/following-sibling::div//input");
    private final By startDateInput = By.xpath("//label[contains(text(),'开始时间')]/following-sibling::div//input");
    private final By endDateInput = By.xpath("//label[contains(text(),'结束时间')]/following-sibling::div//input");
    private final By onlineRadio = By.xpath("//span[contains(text(),'上线')]/preceding-sibling::span/input");
    private final By offlineRadio = By.xpath("//span[contains(text(),'下线')]/preceding-sibling::span/input");
    private final By confirmButton = By.xpath("//span[@class='dialog-footer']//span[text()='确 定']/parent::button");

    public ActivityDialogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void setActivityTitle(String title) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(titleInput));
        input.clear();
        input.sendKeys(title);
    }

    public void setStartDate(String date) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(startDateInput));
        input.clear();
        input.sendKeys(date);
    }

    public void setEndDate(String date) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(endDateInput));
        input.clear();
        input.sendKeys(date);
    }

    public void setStatus(boolean isOnline) {
        WebElement radio = isOnline ?
                wait.until(ExpectedConditions.elementToBeClickable(onlineRadio)) :
                wait.until(ExpectedConditions.elementToBeClickable(offlineRadio));
        if (!radio.isSelected()) {
            radio.click();
        }
    }

    public void clickConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }

    public void fillForm(String title, String startDate, String endDate, boolean isOnline) {
        setActivityTitle(title);
        setStartDate(startDate);
        setEndDate(endDate);
        setStatus(isOnline);
    }
}
