package Pages;

import WebDriver.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class BasePage {

    public void clickThis(By locator) {
        Web.getDriver().findElement(locator).click();
    }
    public void enterField(By locator, String name){
        Web.getDriver().findElement(locator).sendKeys(name);
    }
    public void dropDown(By locator, String Month){
       WebElement at = Web.getDriver().findElement(locator);
        Select sMonth = new Select(at);
        sMonth.selectByValue(Month);
    }
    public void waitMe(){
        Web.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
}

