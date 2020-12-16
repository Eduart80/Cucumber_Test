package Pages.Hotels;

import Pages.BasePage;
import WebDriver.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class LandingPageMethods extends BasePage {

    // Locators
    By enterInSearch = By.xpath("//input[@id='qf-0q-destination']");
    By nextPageSearchBar = By.id("q-destination");
    By searchButton = By.xpath("//button[@type='submit']");
    By checkInCalendar = By.id("qf-0q-localised-check-in");
    By checkOutCalendar = By.id("qf-0q-localised-check-out");
    By allCalenderDates = By.xpath("//td[starts-with(@data-date,'2020-11')]");
    By briefcase = By.xpath("//span[@class='widget-query-num-nights']");
    By listActive =By.xpath("//tbody[@class='autosuggest-city']//tr");
    By theMess = By.xpath("//tbody[@class='autosuggest-city']//div[@class='autosuggest-category-result']");
    By destinationTitle = By.xpath("//h1[@class='destination-title']");
    By closeOverlay = By.xpath("//button[@aria-label='Close overlay']");
    By isShown = By.xpath("//div[@id='managed-overlay']");
    By childrens = By.id("qf-0q-room-0-children");
    By Child1 = By.id("qf-0q-room-0-child-0-age");
    By Child2 = By.id("qf-0q-room-0-child-1-age");
    By selPriceLowToHigh = By.xpath("//div[@class='submenu-wrap']//li[2]//a[contains(text(),'Price (low to high)')]");
    By mouseoverPrice = By.xpath("//li[@class='sort-option']//a[contains(text(),'Price')]");
    By getTextPrice = By.xpath("//ol[@class='listings infinite-scroll-enabled']//li[1]//aside[1]//div[@class='price']//ins[1]");



    // Method to interact with webElement (represent by above Locators)
    public void clickSearch() {
        clickThis(searchButton);
    }
    public void enterInField(String name){
        enterField(enterInSearch,name);
    }

    public boolean isSearchButtonEnabled() {
        return Web.getDriver().findElement(searchButton).isEnabled();
    }
    public boolean checkIsTrue(){
        return Web.getDriver().findElement(enterInSearch).isDisplayed();
    }

    public void selectTheLine(String name) {
        List<WebElement> myList = Web.getDriver().findElements(theMess);
        for (WebElement div : myList) {
            if (div.getText().contains(name)) {
                div.click();
                break;
            }
        }
    }

    public String getBriefcaseText() {
        return Web.getDriver().findElement(briefcase).getText();
    }
    public boolean verify(){
        return Web.getDriver().findElement(destinationTitle).equals("Lake George, New York, United States of America");
    }
    public boolean verify2(){
        return Web.getDriver().findElement(nextPageSearchBar).equals("Lake George, New York, United States of America");
    }
    public void closeFormAdd(){
        boolean checkIf = Web.getDriver().findElement(isShown).isEnabled();
        if(checkIf){
            Web.getDriver().findElement(closeOverlay).click();
        }
    }
    public void sendAge(String name){
        selectDropDown(childrens,name);
    }
    public void sendAgeCH1(String name){
        selectDropDown(Child1,name);
    }public void sendAgeCH2(String name){
        selectDropDown(Child2,name);
    }
    public void PriceOver(){
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("scrollBy(0,200)");
       WebElement select = Web.getDriver().findElement(mouseoverPrice);
       select.click();
    }
    public void selectPriceLowHigh(){
        WebElement select = Web.getDriver().findElement(selPriceLowToHigh);
        select.click();
    }
    public void checkLowP(){
        String bb = Web.getDriver().findElement(getTextPrice).getText();
        System.out.println("The lowest price for hotels is $"+bb);
    }
    public void checkEquals(String name){
        String bb = Web.getDriver().findElement(getTextPrice).getText();
        Assert.assertEquals(name, bb, "Price is not the same as input");
    }

}
