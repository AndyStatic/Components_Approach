package pages;

import components.Button;
import components.Link;
import components.TextBox;
import locators.AuthenticationLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import steps.base.BaseUtil;

public class AuthenticationPage {

    AuthenticationLocators authenticationLocators;
    WebDriver driver;

    //Elements
    TextBox emailCreateInput;
    Button submitCreateButton;
    TextBox emaiInput;
    TextBox passwdInput;
    Button submitLoginButton;

    public AuthenticationPage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;

        //Elements
        emailCreateInput = new TextBox(base, driver.findElement(By.id(authenticationLocators.EMAIL_CREATE_INPUT_ID)));
        submitCreateButton = new Button(base, driver.findElement(By.id(authenticationLocators.SUBMIT_CREATE_BTN_ID)));
        emaiInput = new TextBox(base, driver.findElement(By.id(authenticationLocators.EMAIL_REGISTERED_INPUT_ID)));
        passwdInput = new TextBox(base, driver.findElement(By.id(authenticationLocators.PASSWORD_REGISTERED_INPUT_ID)));
        submitLoginButton = new Button(base, driver.findElement(By.id(authenticationLocators.SUBMIT_REGISTERED_BTN_ID)));
    }

    //CREATE AN ACCOUNT Business Logic
    public void iEnterEmailForCreateAnAccount(String email){
        emailCreateInput.waitForVisibility();
        emailCreateInput.SetText(email);
    }

    public void iPressSubmitForCreateAnAccount(){
        submitCreateButton.waitForElementIsClickable();
        submitCreateButton.Submit();
    }

    //ALREADY REGISTERED? Business Logic
    public void iEnterEmailForRegisteredUser(String email){
        emaiInput.waitForVisibility();
        emaiInput.SetText(email);
    }

    public void iEnterPasswordForRegisteredUser(String password){
        passwdInput.waitForVisibility();
        passwdInput.SetText(password);
    }

    public void iPressSubmitForRegisteredUser(){
        submitLoginButton.waitForElementIsClickable();
        submitLoginButton.Click();
    }
}
