package com.amazon.pages;

import com.amazon.utilities.Driver;
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

    @FindBy(id = "glow-ingress-block")
    public WebElement deliverToLocation;

    @FindBy(id = "GLUXZipUpdateInput")
    public WebElement deliverToZipCodeInputBox;

    @FindBy(xpath = "//*[@id=\"GLUXZipUpdate\"]/span/input")
    public WebElement zipCodeApplyButton;

    @FindBy(xpath = "//button[@name='glowDoneButton']")
    public WebElement deliverDoneButton;

    @FindBy(id = "glow-ingress-line2")
    public WebElement zipCodeAddressNameCheck;

    @FindBy(xpath = "(//input[@id='GLUXConfirmClose'])[2]")
    public WebElement zipCodeContinueButton;

    @FindBy(id = "a-popover-header-1")
    public WebElement zipPopUp;

    @FindBy(id = "nav-item-signout")
    public WebElement signOutWithHoverElement;

    @FindBy(xpath = "//div[@class=' a-declarative']")
    public WebElement dropdownOnLocation;

    @FindBy(xpath = "//title[@dir='ltr']")
    public WebElement titleOfPage;

    @FindBy(xpath = "(//div[@id=\"nav-main\"]//div)[1]")
    public WebElement hamburgerAllMenu;

    @FindBy(xpath = "//div[@id='hmenu-canvas-background']//div")
    public WebElement hamburgerCloseSign;

    @FindBy(id = "hmenu-content")
    public WebElement hamburgerMenuContent;

    @FindBy(xpath = "(//input[@class='a-button-input'])[1]")
    public WebElement dontChangeButton;

    @FindBy(xpath = "(//input[@class='a-button-input'])[2]")
    public WebElement changeAddressButton;

    @FindBy(xpath = "//span[@class='action-inner']")
    public WebElement bottomSignInButton;

}
