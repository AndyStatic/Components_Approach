package pages;

import components.Label;
import components.Link;
import locators.CartLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import steps.base.BaseUtil;

public class CartPage {

    CartLocators cartLocators;
    WebDriver driver;

    //Elements
    Label dressInCart;
    Label cartPageHeading;
    Link logoutLink;

    public CartPage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;

        //Elements
        try {
            dressInCart = new Label(base, driver.findElement(By.xpath(cartLocators.DRESS_IN_CART_XPATH)));
        } catch (NoSuchElementException e) {
            dressInCart=null;
        } catch (Exception e) {
            dressInCart=null;
        }
        //dressInCart = new Label(base, driver.findElement(By.xpath(cartLocators.DRESS_IN_CART_XPATH)));
        try {
            cartPageHeading = new Label(base, driver.findElement(By.xpath(cartLocators.CART_PAGE_HEADING_LABEL_XPATH)));
        } catch (NoSuchElementException e) {
            cartPageHeading=null;
        } catch (Exception e) {
            cartPageHeading=null;
        }
        //cartPageHeading = new Label(base, driver.findElement(By.xpath(cartLocators.CART_PAGE_HEADING_LABEL_XPATH)));
        logoutLink = new Link(base, driver.findElement(By.className(cartLocators.LOGOUT_LINK_CLASSNAME)));
    }

    //Dress in cart Business Logic
    public String cartContainsDressName(){
        try
        {
            if(dressInCart!=null) {
                if (dressInCart.IsElementDisplayed())
                    return dressInCart.GetElementText();
                else
                    return "Element not found";
            }
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
        if(cartPageHeading!=null)
            return cartPageHeading.IsElementDisplayed();
        else
            return false;
    }

    //Logout Business Logic
    public void iClickSignOutLink(){
        logoutLink.waitForElementIsClickable();
        logoutLink.Click();
    }
}
