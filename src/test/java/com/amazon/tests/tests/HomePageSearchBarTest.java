package com.amazon.tests.tests;

import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import com.amazon.tests.base.TestBase;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomePageSearchBarTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    WebDriverWait wait;
    Actions actions;
    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        homePage = new HomePage();
        signInPage = new SignInPage();
        wait = new WebDriverWait(Driver.getDriver(),10);
        actions = new Actions(Driver.getDriver());
    }


    @AfterMethod
    public void tearDown(){
        Driver.stopSession();
    }


    @Test
    public void login_function_test(){

        //hover account and list title and see the sign in button
        //click the sign in button
        //see the sign in screen properly
        //enter valid mail address in the input box
        //click the continue button
        //enter valid password in the input box
        //click the sign in button
        //verify:
        //Your name is appeared on the homepage.


        Driver.getDriver().manage().deleteAllCookies();

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(homePage.hoverAccountAndList).perform();

        homePage.signInButton.click();
        BrowserUtils.sleep(1);

        homePage.signInInputBoxForEmail.sendKeys("yasin.deger48@gmail.com");
        homePage.signInContinueButton.click();

        homePage.signInInputBoxForPassword.sendKeys("Fethiye15");
        homePage.signInButtonInTheSignInScreen.click();

        String actualText = homePage.checkNameAfterSignIn.getText();
        String expectedText = "Hello";

        Assert.assertTrue(actualText.substring(0,5).equals(expectedText),"Name is disappeard on the home page");

    }

    @Test
    public void log_out_function_test(){
        login_function_test();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(homePage.hoverAccountAndList).perform();
        homePage.signOutWithHoverElement.click();

        String expectedURL = "https://www.amazon.com/ap/signin";
        String actualURL= Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedURL),"Sign Out process can not applied");

    }

    @Test
    public void search_and_compare_result_numbers_test()  {

        //first search hats on the search bar
        //then select electronic in dropdown
        //then search iphone on the search bar
        //Assert result number and actual results

        homePage.searchBox.sendKeys("hats");
        homePage.searchButton.click();
        Select select = new Select(homePage.dropDownAllCategories);

        select.selectByValue("search-alias=electronics-intl-ship");

        homePage.searchBox.clear();
        homePage.searchBox.sendKeys("iphone");
        homePage.searchButton.click();
        BrowserUtils.sleep(2);

        List<WebElement> searchedElements = homePage.searchedElements;
        Integer searchResultNumberText = BrowserUtils.searchResultNumber();

        Assert.assertTrue(searchedElements.size() == searchResultNumberText,"searchResult is not matching");

    }

    @Test
    public void hover_account_and_verify_alert_message_test(){

        //hover account and list title and see the sign in button
        //click the sign in button
        //see the sign in screen properly
        //enter wrong mail address in the input box
        //click the continue button
        //see the alert message
        //verify that alert message says 'There was a problem'

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(homePage.hoverAccountAndList).perform();

        homePage.signInButton.click();
        BrowserUtils.sleep(1);

        homePage.signInInputBoxForEmail.sendKeys("yasin.deger48@gmail.co");
        homePage.signInContinueButton.click();

        String expectedWarn = "There was a problem";
        String actualWarn = homePage.alertMessageInSignInScreen.getText();

        Assert.assertTrue(actualWarn.equals(expectedWarn),"Warning message is not matching");


    }

    @Test
    public void deliverTo_location_choose_test(){

        //click the deliver to location
        //enter the input box as '11102' as Astoria in USA
        //then click the apply button
        //then click the done button
        //verify:
        //location title changed as Astoria 11102

        homePage.deliverToLocation.click();
        homePage.deliverToZipCodeInputBox.sendKeys("11102");
        homePage.zipCodeApplyButton.click();
        homePage.zipCodeContinueButton.click();
        BrowserUtils.sleep(1);
        String[] address = homePage.zipCodeAddressNameCheck.getText().split(" ");
        String expectedAddress = "Astoria";
        System.out.println("address[0] = " + address[0]);
        Assert.assertTrue(address[0].equals(expectedAddress),"Address is not matching with the zip code");



    }

    @Test
    public void deliverTo_location_choose_on_dropdown_test(){

        //after successful login, click the Deliver to 'Location' link
        //then see the "choose your location" screen
        //select location with the dropdown as 'Japan'
        //click done button
        //verify:
        //location should be changed as 'Japan'



        //login_function_test();
        homePage.deliverToLocation.click();
        String country="Japan";
        /*Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(homePage.dropdownOnLocation).click().perform();*/
        homePage.dropdownOnLocation.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("(//a[.='"+country+"'])[1]")).click();
        homePage.deliverDoneButton.click();
        BrowserUtils.sleep(2);
        String actualCountryName = homePage.zipCodeAddressNameCheck.getText();
        String expectedCountryName ="Japan";
        Assert.assertTrue(actualCountryName.equals(expectedCountryName),"Country name is not correct");


    }

    @Test
    public void legal_policies_test(){

        //this test include and verify condition of use and Privacy notice is shown properly
        //go to sign in page
        //click the condition of use link
        //verify:
        //see the condition of use page and verify with title and header
        //go back for sign in page
        //click the Privacy Notice link
        //verify:
        //see the privacy notice page and verify with title and header
        //go back to sign in page

        Driver.getDriver().manage().deleteAllCookies();

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(homePage.hoverAccountAndList).perform();

        homePage.signInButton.click();
        BrowserUtils.sleep(1);

        signInPage.conditionOfUseLinkAboveCreateButton.click();

        String actualConditionOfUseTitle = Driver.getDriver().getTitle();
        String expectedConditionOfUseTitle = "Conditions of Use - Amazon Customer Service";
        Assert.assertTrue(actualConditionOfUseTitle.equals(expectedConditionOfUseTitle),"Condition of Use page title is not correct");
        String actualConditionOfHeader = signInPage.conditionOfUseHeader.getText();
        String expectedConditionOfHeader = "Conditions of Use";
        Assert.assertTrue(actualConditionOfHeader.equals(expectedConditionOfHeader),"Condiion of Use page header is not found");
        Driver.getDriver().navigate().back();
        signInPage.privacyNoticeLinkAboveCreateButton.click();

        String actualPrivacyNoticeTitle = Driver.getDriver().getTitle();
        String expectedPrivacyNoticeTitle = "Amazon.com Privacy Notice - Amazon Customer Service";
        Assert.assertTrue(actualPrivacyNoticeTitle.equals(expectedPrivacyNoticeTitle),"Privacy Notice page title is not correct");
        Driver.getDriver().navigate().back();

        signInPage.needHelpAboveCreateButton.click();




    }

    @Test
    public void hamburger_menu_test(){

        //click the don't change location button
        //click the hamburger menu
        //check each category one by one
        //verify:
        //make sure that each link is executeable

        //login_function_test();
        homePage.dontChangeButton.click();
        boolean testResult = BrowserUtils.hamburgerMenuLinkTest(); //if test is successful, result must be return true
        Assert.assertTrue(testResult,"Link test fail");


    }

    @Test
    public void bottom_sign_in_button_test(){


        //scroll down on the bottom sign in button
        //verify:
        // bottom sign in button is clickable

        Driver.getDriver().manage().deleteAllCookies();
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollBy(0,4000)");
        actions.moveToElement(homePage.bottomSignInButton).click().perform();
        Assert.assertTrue(homePage.signInInputBoxForEmail.isDisplayed(),"Sign in page doesnt appeared properly");
    }



}
