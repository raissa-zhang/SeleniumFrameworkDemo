package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActivityDialogPage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));;
         LoginPage loginPage = new LoginPage(webDriver);
         String username = "admin";
         String password = "macro123";

         loginPage.login(username,password);

        Assert.assertTrue(loginPage.isDashboardDisplayed());

        // 营销
        By marketingMenu = By.xpath( "//*[@id=\"app\"]/div/div[1]/div/ul/div/li[4]/div"
        );
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(marketingMenu));
        menu.click();
        Thread.sleep(10000);

        // 秒杀活动列表
        By miaosha = By.xpath( "//*[@id=\"app\"]/div/div[1]/div/ul/div/li[4]/ul/a[1]/li");
        WebElement webElementMiaosha =  wait.until(ExpectedConditions.visibilityOfElementLocated(miaosha));
        webElementMiaosha.click();
        Thread.sleep(10000);

        //添加活动
        By addElement = By.xpath( "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/button[1]/span");
        WebElement webElementAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(addElement));
        webElementAdd.click();
        Thread.sleep(10000);

        // 填写表格 提交
        ActivityDialogPage activityDialogPage = new ActivityDialogPage(webDriver);
        activityDialogPage.fillForm(
                "test123",
                "2025-04-01",
                "2025-04-30",
                true  // 上线状态
        );
    }

}
