package SDFiles.Hotels;

import Pages.Hotels.LandingPageMethods;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class hotelsLocation  {
    LandingPageMethods lp = new LandingPageMethods();

    @When("^i enter '(.+)' in search bar$")
    public void searchPlace(String name){
        lp.enterInField(name);
        //lp.waitMe();
    }
    @When("^i select '(.+)' from autosuggestion$")
    public void findText(String name){
        lp.selectTheLine(name);
    }
    @And("^i click search button$")
    public void checkList(){
        lp.clickSearch();
    }
    @And("^i verify search header contains text selected from autosuggestion$")
    public void doubleCheck(){
        lp.verify();
    }
    @And("^i verify text under 'Destination, property, or landmark is the same text selected from autosuggestion$")
    public void verifySecond(){
        lp.verify2();
    }




}
/**
 * Verify user selection from autosuggestion appears on search page
 * i am on hotel landing page
 * i enter 'york' in search
 * i select 'Lake George, New York, Unite' from autosuggestion
 * i click search button
 * i verify search header contains text selected from autosuggestion
 * i verify text under 'Destination, property, or landmark is the same text selected from autosuggestion
 */
