package pages;

import components.Label;
import components.Link;
import locators.MyAccountLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import steps.base.BaseUtil;

public class MyAccountPage {

    MyAccountLocators myAccountLocators;
    WebDriver driver;

    //Elements
    Link dressesLink;
    Link cart;
    Label accountWelcomeMsg;

    public MyAccountPage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;

        //Elements
        dressesLink = new Link(base, driver.findElement(By.xpath(myAccountLocators.DRESS_LINK_XPATH)));
        cart = new Link(base, driver.findElement(By.xpath(myAccountLocators.CART_LINK_XPATH)));
        accountWelcomeMsg = new Label(base, driver.findElement(By.className(myAccountLocators.ACC_WELCOME_MSG_LABEL_CLASSNAME)));
    }

    //Links Business Logic
    public void iClickDressesLink(){
        dressesLink.waitForElementIsClickable();
        dressesLink.Click();
    }

    //Cart Business Logic
    public void iClickCart(){
        cart.waitForElementIsClickable();
        cart.Click();
    }

    //Misc Business Logic
    public boolean isPageWithAccWelcomeTextDisplayed(){
        return accountWelcomeMsg.IsElementDisplayed();
    }
}
