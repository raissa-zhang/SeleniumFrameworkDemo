package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.Collections;

public class BaseTest {
     public WebDriver webDriver;
    @BeforeSuite
    public void setupSuite(){

    }

    @BeforeTest
    public void setupTest(){
         webDriver = new ChromeDriver();
         webDriver.manage().window().maximize();

    }

    @AfterTest
    public void teardownTest(){
        if(webDriver != null){
            webDriver.quit();
        }
    }

    @AfterSuite
    public void teardownSuit(){

    }


}
