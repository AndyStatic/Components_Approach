package pages;

import components.Link;
import locators.HomeLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import steps.base.BaseUtil;

public class HomePage {

    HomeLocators homeLocators;
    WebDriver driver;

    //Elements
    Link signInLink;

    // static variable single_instance of type Singleton
    private static Link single_instance=null;

    public HomePage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;

        //Elements
        signInLink = new Link(base, driver.findElement(By.className(homeLocators.SIGN_IN_LINK_CLASSNAME)));
    }

    //Business Logic

    public void iClickSignInLink(){
        signInLink.waitForElementIsClickable();
        signInLink.Click();
    }
}
