package pages;

import components.Label;
import components.Link;
import components.TextBox;
import locators.CartLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import steps.base.BaseUtil;

public class CartPage {

    static CartLocators cartLocators;
    static WebDriver driver;
    static BaseUtil base;

    //Elements
    private static Label dressInCart=null;
    private static Label cartPageHeading=null;
    private static Link logoutLink=null;

    public CartPage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;
        this.base = base;

        //Elements
        dressInCart = new Label(base, driver.findElement(By.xpath(cartLocators.DRESS_IN_CART_XPATH)));
        cartPageHeading = new Label(base, driver.findElement(By.xpath(cartLocators.CART_PAGE_HEADING_LABEL_XPATH)));
        logoutLink = new Link(base, driver.findElement(By.className(cartLocators.LOGOUT_LINK_CLASSNAME)));
    }

    public static Label dressInCartSingleton()
    {
        // To ensure only one instance is created
        if (dressInCart == null)
        {
            dressInCart = new Label(base, driver.findElement(By.xpath(cartLocators.DRESS_IN_CART_XPATH)));
        }
        return dressInCart;
    }

    public static Label cartPageHeadingSingleton()
    {
        // To ensure only one instance is created
        if (cartPageHeading == null)
        {
            cartPageHeading = new Label(base, driver.findElement(By.xpath(cartLocators.CART_PAGE_HEADING_LABEL_XPATH)));
        }
        return cartPageHeading;
    }

    public static Link logoutLinkSingleton()
    {
        // To ensure only one instance is created
        if (logoutLink == null)
        {
            logoutLink = new Link(base, driver.findElement(By.className(cartLocators.LOGOUT_LINK_CLASSNAME)));
        }
        return logoutLink;
    }

    //Dress in cart Business Logic
    public String cartContainsDressName(){
        dressInCart = dressInCartSingleton();
        try
        {
            if(dressInCart.IsElementDisplayed())
                return dressInCart.GetElementText();
            else
                return "Element not found";
        }
        catch(Exception e)
        {
            return "Element not found";
        }
    }

    //Misc Business Logic
    public boolean isPageWithHeadingTextDisplayed(){
        cartPageHeading = cartPageHeadingSingleton();
        return cartPageHeading.IsElementDisplayed();
    }

    //Logout Business Logic
    public void iClickSignOutLink(){
        logoutLink = logoutLinkSingleton();
        logoutLink.waitForElementIsClickable();
        logoutLink.Click();
    }
}
