package com.amazon.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.ObjectInputFilter;
import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver(){}

    static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){

            String browser = ConfigurationReader.getProperty("browser1");

            switch (browser){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }
        return driver;
    }

    public static void stopSession(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
