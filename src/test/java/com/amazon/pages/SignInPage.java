package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //locators

    @FindBy(xpath = "//h1[@class='a-spacing-small']")
    public WebElement signInHeader;

    @FindBy(id = "ap_email")
    public WebElement emailAndPhoneNumberInputBox;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "auth-create-account-link")
    public WebElement createAmazonAccountButton;

    


}
