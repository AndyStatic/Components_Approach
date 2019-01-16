package pages;

import components.Link;
import locators.AfterSignOutLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import steps.base.BaseUtil;

public class AfterSignOutPage {

    AfterSignOutLocators afterSignOutLocators;
    WebDriver driver;

    //Elements
    Link signInLink;

    public AfterSignOutPage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;

        //Elements
        signInLink = new Link(base, driver.findElement(By.xpath(afterSignOutLocators.SIGN_IN_LINK_XPATH)));
    }

    //Sign in business login
    public boolean signInLinkIsDisplayed() {
        return signInLink.IsElementDisplayed();
    }
}
