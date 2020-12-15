package Pages.Hotels;

import Pages.BasePage;
import WebDriver.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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
}
