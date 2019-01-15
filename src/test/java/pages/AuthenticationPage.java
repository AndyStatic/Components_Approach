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

    static AuthenticationLocators authenticationLocators;
    static WebDriver driver;
    static BaseUtil base;

    //Elements
    private static TextBox emailCreateInput=null;
    private static Button submitCreateButton=null;
    private static TextBox emaiInput=null;
    private static TextBox passwdInput=null;
    private static Button submitLoginButton=null;

    public AuthenticationPage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;
        this.base = base;
    }

    public static TextBox emailCreateInputSingleton()
    {
        // To ensure only one instance is created
        if (emailCreateInput == null)
        {
            emailCreateInput = new TextBox(base, driver.findElement(By.id(authenticationLocators.EMAIL_CREATE_INPUT_ID)));
        }
        return emailCreateInput;
    }

    public static Button submitCreateButtonSingleton()
    {
        // To ensure only one instance is created
        if (submitCreateButton == null)
        {
            submitCreateButton = new Button(base, driver.findElement(By.id(authenticationLocators.SUBMIT_CREATE_BTN_ID)));
        }
        return submitCreateButton;
    }

    public static TextBox emaiInputSingleton()
    {
        // To ensure only one instance is created
        if (emaiInput == null)
        {
            emaiInput = new TextBox(base, driver.findElement(By.id(authenticationLocators.EMAIL_REGISTERED_INPUT_ID)));
        }
        return emaiInput;
    }

    public static TextBox passwdInputSingleton()
    {
        // To ensure only one instance is created
        if (passwdInput == null)
        {
            passwdInput = new TextBox(base, driver.findElement(By.id(authenticationLocators.PASSWORD_REGISTERED_INPUT_ID)));
        }
        return passwdInput;
    }

    public static Button submitLoginButtonSingleton()
    {
        // To ensure only one instance is created
        if (submitLoginButton == null)
        {
            submitLoginButton = new Button(base, driver.findElement(By.id(authenticationLocators.SUBMIT_REGISTERED_BTN_ID)));
        }
        return submitLoginButton;
    }

    //CREATE AN ACCOUNT Business Logic
    public void iEnterEmailForCreateAnAccount(String email){
        emailCreateInput = emailCreateInputSingleton();
        emailCreateInput.waitForVisibility();
        emailCreateInput.SetText(email);
    }

    public void iPressSubmitForCreateAnAccount(){
        submitCreateButton = submitCreateButtonSingleton();
        submitCreateButton.waitForElementIsClickable();
        submitCreateButton.Submit();
    }

    //ALREADY REGISTERED? Business Logic
    public void iEnterEmailForRegisteredUser(String email){
        emaiInput = emaiInputSingleton();
        emaiInput.waitForVisibility();
        emaiInput.SetText(email);
    }

    public void iEnterPasswordForRegisteredUser(String password){
        passwdInput = passwdInputSingleton();
        passwdInput.waitForVisibility();
        passwdInput.SetText(password);
    }

    public void iPressSubmitForRegisteredUser(){
        submitLoginButton = submitLoginButtonSingleton();
        submitLoginButton.waitForElementIsClickable();
        submitLoginButton.Click();
    }
}
