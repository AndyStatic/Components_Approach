package pages;

import components.Link;
import locators.AfterSignOutLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import steps.base.BaseUtil;

import java.util.concurrent.TimeUnit;

public class AfterSignOutPage {

    static AfterSignOutLocators afterSignOutLocators;
    static WebDriver driver;
    static BaseUtil base;

    //Elements
    private static Link signInLink=null;

    public AfterSignOutPage(BaseUtil base){
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
            signInLink = new Link(base, driver.findElement(By.xpath(afterSignOutLocators.SIGN_IN_LINK_XPATH)));
        }
        return signInLink;
    }

    //Sign in business login
    public boolean signInLinkIsDisplayed() {
        signInLink = signInLinkSingleton();
        return signInLink.IsElementDisplayed();
    }
}
