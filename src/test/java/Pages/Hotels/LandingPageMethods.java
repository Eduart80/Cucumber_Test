package Pages.Hotels;

import Pages.BasePage;
import WebDriver.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class LandingPageMethods extends BasePage {

    // Locators
    By enterInSearch = By.xpath("//input[@id='qf-0q-destination']");
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
    By selPriceLowToHigh = By.id("//ul[@id='sort-submenu-price']//li[2]");
    By mouseoverPrice = By.id("//a[@data-menu='sort-submenu-price']");



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
        return Web.getDriver().findElement(enterInSearch).equals("Lake George, New York, United States of America");
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
    public void selectPriceLowHigh(){
        WebElement select = Web.getDriver().findElement(selPriceLowToHigh);
        Actions etc = new Actions(Web.getDriver());
        etc.moveToElement(select).build().perform();
    }
    public void checkLowP(){
        String bb = Web.getDriver().findElement(selPriceLowToHigh).getText();
        System.out.println(bb);
    }
    public void mouseOver(){
       WebElement select = Web.getDriver().findElement(mouseoverPrice);
       Actions etc = new Actions(Web.getDriver());
       etc.moveToElement(select).build().perform();
    }

}
