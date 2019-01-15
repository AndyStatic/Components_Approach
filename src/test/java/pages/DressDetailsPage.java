package pages;

import components.Button;
import components.Label;
import components.Link;
import locators.DressDetailsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import steps.base.BaseUtil;

public class DressDetailsPage {

    DressDetailsLocators dressDetailsLocators;
    WebDriver driver;

    //Elements
    Button addToCartBtn;
    Label dressesNameHeading;
    Link proceedToCheckOutBtnOnOverlay;

    public DressDetailsPage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;

        //Elements
        addToCartBtn = new Button(base, driver.findElement(By.xpath(dressDetailsLocators.ADD_TO_CART_BTN_XPATH)));
        dressesNameHeading = new Label(base, driver.findElement(By.xpath(dressDetailsLocators.DRESS_NAME_XPATH)));
        proceedToCheckOutBtnOnOverlay = new Link(base, driver.findElement(By.xpath(dressDetailsLocators.PROCEED_TO_CHECKOUT_BTN_XPATH)));
    }

    //Dress details Business Logic
    public String dressNameIs(){
        //return driver.getTitle();
        dressesNameHeading.waitForVisibility();
        try
        {
            if(dressesNameHeading.IsElementDisplayed())
                return dressesNameHeading.GetElementText();
            else
                return "Element not found";
        }
        catch(Exception e)
        {
            return "Element not found";
        }
    }

    //Add to Cart Business Logic
    public void iPressAddToCartBtn(){
        addToCartBtn.waitForElementIsClickable();
        addToCartBtn.Submit();
    }

    //Cart Overlay Business Logic
    public void iClickProceedToCheckOutBtnOnOverlay(){
        try {
            proceedToCheckOutBtnOnOverlay.waitForVisibility();
            proceedToCheckOutBtnOnOverlay.Click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            //continue
        }
    }
}
