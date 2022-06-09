package com.amazon.tests.tests;

import com.amazon.pages.HomePage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class HomePageSearchBarTest {
    HomePage homePage;
    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        homePage = new HomePage();
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
    public void hover_account_and_list_test(){

        //hover account and list title and see the sign in button
        //click the sign in button
        //see the sign in screen properly
        //enter wrong mail adress in the input box
        //click the continue button
        //see the alert message
        //verfity that alert message says 'There was a problem'

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
}
