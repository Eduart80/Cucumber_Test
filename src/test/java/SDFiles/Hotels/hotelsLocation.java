package SDFiles.Hotels;

import Pages.Hotels.LandingPageMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import org.openqa.selenium.By;


public class hotelsLocation  {
    LandingPageMethods lp = new LandingPageMethods();
//////////////////////////////////////////////////////////////
    //first homeWork
    @When("^remove add popup$")
    public void addRemove(){
        lp.closeFormAdd();
    }
    @When("^i enter '(.+)' in search bar$")
    public void searchPlace(String name){
        lp.enterInField(name);
        lp.waitASec();
    }
    @When("^i select '(.+)' from autosuggestion$")
    public void findText(String name){
        lp.selectTheLine(name);
        lp.waitForMe();
    }
    @And("^i click search button$")
    public void checkList(){
        lp.clickSearch();
        lp.waitForMe();
    }
    @And("^i verify search header contains text selected from autosuggestion$")
    public void doubleCheck(){
        lp.verify();
    }
    @And("^i verify text under 'Destination, property, or landmark is the same text selected from autosuggestion$")
    public void verifySecond(){
        lp.verify2();
    }
///////////////////////////////////////////////////////////////
    //second HomeWork
    @When("^i select (.+) in children$")
    public void selectChildren(String name){
        lp.sendAge(name);
    }
    @And("^i enter children 1 age as (.+)$")
    public void enterAgeA(String name){
        lp.sendAgeCH1(name);
    }
    @And("^i enter children 2 age as (.+)$")
    public void enterAgeB(String name){
        lp.sendAgeCH2(name);
    }
    @And("^i click search to find$")
    public void checkList2(){
        lp.clickSearch();
        lp.waitForMe();
    }
    @When("^i sort the result by \"Price (.+)\"$")
    public void selectPrice(){
        lp.mouseOver();
        lp.selectPriceLowHigh();
    }
    @And("^i print the (.+) price and hotel name in the console$")
    public void printPrice(){
        lp.checkLowP();
    }



}

/**
 * Verify the cheapest hotel is less than $100
 * i am on hotel landing page
 * i enter 'york' in search
 * i select 'Lake George, New York, Unite' from autosuggestion
 * i select 2 in children dropdown
 * i enter children 1 age as "4"
 * i enter children 2 age as "<1"
 * i click search button
 * i sort the result by "Price (Low to high)"
 * i print the lowest price and hotel name in the console
 * i verify the lowest price id less than $100
 */
