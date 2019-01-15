package pages;

import components.Link;
import locators.HomeLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import steps.base.BaseUtil;

public class HomePage {

    static HomeLocators homeLocators;
    static WebDriver driver;
    static BaseUtil base;

    //Elements
    Link signInLink;

    // static variable single_instance of type Singleton
    private static Link single_instance=null;

    public HomePage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;
        this.base = base;

        //Elements
        signInLink = new Link(base, driver.findElement(By.className(homeLocators.SIGN_IN_LINK_CLASSNAME)));
    }

    // static method to create instance of Singleton class
    public static Link Singleton()
    {
        // To ensure only one instance is created
        if (single_instance == null)
        {
            single_instance = new Link(base, driver.findElement(By.className(homeLocators.SIGN_IN_LINK_CLASSNAME)));
        }
        return single_instance;
    }

    //Business Logic

    public void iClickSignInLink(){
        //signInLink.waitForElementIsClickable();
        //signInLink.Click();
        single_instance = Singleton();
        single_instance.waitForElementIsClickable();
        single_instance.Click();
    }
}
