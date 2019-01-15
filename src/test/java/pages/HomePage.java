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

    private static Link signInLink=null;

    public HomePage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;
        this.base = base;
    }

    public static Link signInLinkSingleton()
    {
        // To ensure only one instance is created
        if (signInLink == null)
        {
            signInLink = new Link(base, driver.findElement(By.className(homeLocators.SIGN_IN_LINK_CLASSNAME)));
        }
        return signInLink;
    }

    //Business Logic

    public void iClickSignInLink(){
        signInLink = signInLinkSingleton();
        signInLink.waitForElementIsClickable();
        signInLink.Click();
    }
}
