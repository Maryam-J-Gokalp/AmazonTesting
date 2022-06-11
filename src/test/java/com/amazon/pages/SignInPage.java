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

    @FindBy(xpath = "(//a[@class='a-link-normal'])[4]")
    public WebElement conditionOfUseLinkUnderCreateButton;

    @FindBy(xpath = "(//a[@class='a-link-normal'])[5]")
    public WebElement privacyNoticeLinkUnderCreateButton;

    @FindBy(xpath = "(//a[@class='a-link-normal'])[6]")
    public WebElement helpLinkUnderCreateButton;

    @FindBy(xpath = "//a[.='Conditions of Use']")
    public WebElement conditionOfUseLinkAboveCreateButton;

    @FindBy(xpath = "//a[.='Privacy Notice']")
    public WebElement privacyNoticeLinkAboveCreateButton;

    @FindBy(xpath = "//span[@class='a-expander-prompt']")
    public WebElement needHelpAboveCreateButton;

    @FindBy(xpath = "//h1[.='Conditions of Use']")
    public WebElement conditionOfUseHeader;

    


}
