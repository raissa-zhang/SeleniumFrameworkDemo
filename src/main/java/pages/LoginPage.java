package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver webDriver;

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.cssSelector("button.el-button--primary span");
    private final By dashboardHeader = By.xpath("//div[contains(@class, 'layout-title') and text()='学习教程']");

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get("https://www.macrozheng.com/admin/index.html");
    }

    public  void enterUsername(String username){
        webDriver.findElement(this.usernameField).sendKeys(username);
    }

    public  void enterPassword(String password){
        webDriver.findElement(this.passwordField).sendKeys(password);
    }

    public void clickLogin(){
        webDriver.findElement(loginButton).click();
    }

    public void login(String username, String password) throws InterruptedException {
        WebElement webElementUsername = webDriver.findElement(usernameField);
        String currentValue = webElementUsername.getAttribute("value");

        if (!"admin".equals(currentValue)) {
            webElementUsername.clear();
            enterUsername(username);
            System.out.println("输入用户名: " + username);
        } else {
            System.out.println("用户名已为admin，跳过输入");
        }
        enterPassword(password);
        Thread.sleep(10000);
        clickLogin();
        Thread.sleep(10000);
    }

    public boolean isDashboardDisplayed(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));;
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader))
                .isDisplayed();
    }



}
