package com.amazon.pages;

import com.amazon.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;

    @FindBy(xpath = "//div[contains(@data-component-type,'s-search-result')]")
    public List<WebElement> searchedElements;

    @FindBy(id = "searchDropdownBox")
    public WebElement dropDownAllCategories;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]")
    public WebElement searchResultNumber;

    @FindBy(xpath = "//div[@class='nav-line-1-container']")
    public WebElement hoverAccountAndList;

    @FindBy(id = "nav-flyout-ya-signin")
    public WebElement signInButton;

    @FindBy(xpath = "//h4[@class='a-alert-heading']")
    public WebElement alertMessageInSignInScreen;

    @FindBy(id = "ap_email")
    public WebElement signInInputBoxForEmail;

    @FindBy(id = "ap_password")
    public WebElement signInInputBoxForPassword;

    @FindBy(id = "signInSubmit")
    public WebElement signInButtonInTheSignInScreen;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement checkNameAfterSignIn;

    @FindBy(id = "continue")
    public WebElement signInContinueButton;
}
