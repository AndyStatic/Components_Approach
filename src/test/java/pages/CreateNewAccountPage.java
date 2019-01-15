package pages;

import components.Button;
import components.Label;
import components.Link;
import components.TextBox;
import locators.CreateNewAccountLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import steps.base.BaseUtil;

public class CreateNewAccountPage {

    static CreateNewAccountLocators createNewAccountLocators;
    static WebDriver driver;
    static BaseUtil base;

    //Elements
    private static TextBox firstNameInput=null;
    private static TextBox lastNameInput=null;
    private static TextBox passwordInput=null;
    private static TextBox addressInput=null;
    private static TextBox cityInput=null;
    private static Link stateSelectorOverlay=null;
    private static Link stateOption2=null;
    private static TextBox postCodeInput=null;
    private static TextBox mobilePhoneInput=null;
    private static Button submitAccountButton=null;
    private static Label createNewAccPageHeading=null;


    public CreateNewAccountPage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;
        this.base = base;

        //Elements
        firstNameInput = new TextBox(base, driver.findElement(By.id(createNewAccountLocators.FIRST_NAME_INPUT_ID)));
        lastNameInput = new TextBox(base, driver.findElement(By.id(createNewAccountLocators.LAST_NAME_INPUT_ID)));
        passwordInput = new TextBox(base, driver.findElement(By.id(createNewAccountLocators.PASSWD_INPUT_ID)));
        addressInput = new TextBox(base, driver.findElement(By.id(createNewAccountLocators.ADDRESS_INPUT_ID)));
        cityInput = new TextBox(base, driver.findElement(By.id(createNewAccountLocators.CITY_INPUT_ID)));
        stateSelectorOverlay = new Link(base, driver.findElement(By.id(createNewAccountLocators.STATE_SELECTOR_OVERLAY_ID)));
        stateOption2 = new Link(base, driver.findElement(By.xpath(createNewAccountLocators.STATE_SELECTOR_OPTION_2_XPATH)));
        postCodeInput = new TextBox(base, driver.findElement(By.id(createNewAccountLocators.POSTCODE_INPUT_ID)));
        mobilePhoneInput = new TextBox(base, driver.findElement(By.id(createNewAccountLocators.MOBILE_PHONE_INPUT_ID)));
        submitAccountButton = new Button(base, driver.findElement(By.id(createNewAccountLocators.CREATE_NEW_ACC_BTN_ID)));
        createNewAccPageHeading = new Label(base, driver.findElement(By.xpath(createNewAccountLocators.CREATE_NEW_ACC_PAGE_HEAD_LABEL_XPATH)));
    }

    //YOUR PERSONAL INFORMATION Business Logic
    public void iEnterFirstNameForCreateAnAccount(String firstName){
        firstNameInput.waitForVisibility();
        firstNameInput.SetText(firstName);
    }

    public void iEnterLastNameForCreateAnAccount(String lastName){
        lastNameInput.waitForVisibility();
        lastNameInput.SetText(lastName);
    }
    public void iEnterPasswordForCreateAnAccount(String password){
        passwordInput.waitForVisibility();
        passwordInput.SetText(password);
    }

    //YOUR ADDRESS Business Logic
    public void iEnterAddress1ForCreateAnAccount(String address1){
        addressInput.waitForVisibility();
        addressInput.SetText(address1);
    }

    public void iEnterCityForCreateAnAccount(String city){
        cityInput.waitForVisibility();
        cityInput.SetText(city);
    }

    public void iSelectStateForCreateAnAccount(String state){
        stateSelectorOverlay.waitForVisibility();
        stateSelectorOverlay.Click();

        stateOption2.waitForVisibility();
        stateOption2.Click();
    }

    public void iEnterPostCodeForCreateAnAccount(String postCode){
        postCodeInput.waitForVisibility();
        postCodeInput.SetText(postCode);
    }

    public void iEnterMobilePhoneForCreateAnAccount(String mobilePhone){
        mobilePhoneInput.waitForVisibility();
        mobilePhoneInput.SetText(mobilePhone);
    }

    //Misc
    public void iPressSubmitAccountButton(){
        submitAccountButton.waitForElementIsClickable();
        submitAccountButton.Click();
    }

    public boolean isPageWithHeadingTextDisplayed(){
        return createNewAccPageHeading.IsElementDisplayed();
    }
}
