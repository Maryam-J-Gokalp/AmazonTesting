package com.amazon.tests.tests;

import com.amazon.pages.HomePage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePageSearchBarTest {


    @Test
    public void test1() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        HomePage homePage = new HomePage();

        homePage.searchBox.sendKeys("hats");
        homePage.searchButton.click();


        List<WebElement> searchedElements = Driver.getDriver().findElements(By.xpath("//div[contains(@data-component-type,'s-search-result')]"));

        BrowserUtils.priceOfItems();

        Driver.stopSession();
    }
}
