package com.amazon.utilities;

import com.amazon.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    static HomePage homePage = new HomePage();
    //sleep
    public static void sleep(int seconds){

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {

        }
    }


    public static void priceOfItems(){

        List<Double> prices = new ArrayList<>();

        List<WebElement> price = Driver.getDriver().findElements(By.xpath("(//span[@class='a-price-whole'])"));
        List<WebElement> franctionPrice = Driver.getDriver().findElements(By.xpath("//span[@class='a-price-fraction']"));

        System.out.println(price.size());
        System.out.println(franctionPrice.size());

        try{
            for (int i = 0; i < price.size(); i++) {

                String value = price.get(i).getText()+"."+franctionPrice.get(i).getText();
                prices.add(Double.parseDouble(value));
                System.out.println("prices = " + prices);
            }
        }catch (Exception e){

        }
    }


    public static Integer searchResultNumber(){
        //1-12 of 242 results for

        String result = homePage.searchResultNumber.getText();
        System.out.println("result = " + result);
        String[] response = result.split(" ");
        System.out.println("response[0] = " + response[0]);
        String[] actualResult = response[0].split("-");
        result = actualResult[1];

        return Integer.parseInt(result);

    }


    public static void navigateTo(String URL){

        try{
            Driver.getDriver().navigate().to(URL);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("URL didn't load properly");
        }
    }
}
