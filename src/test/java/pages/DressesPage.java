package pages;

import components.Label;
import components.Link;
import locators.DressesLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import steps.base.BaseUtil;

public class DressesPage {

    static DressesLocators dressesLocators;
    static WebDriver driver;
    static BaseUtil base;

    //Elements
    private static Link sortByOverlay=null;
    private static Link sortByOption3=null;
    private static Link firstItemInGridImg=null;
    private static Label dressesPageSubHeading=null;
    private static Label firstItemInGrid=null;

    public DressesPage(BaseUtil base){
        //Initialize the page object
        //PageFactory.initElements(new AjaxElementLocatorFactory(base.driver, 15), this);
        driver = base.driver;
        this.base = base;

        //Elements
        sortByOverlay = new Link(base, driver.findElement(By.id(dressesLocators.SORT_BY_OVERLAY_ID)));
        sortByOption3 = new Link(base, driver.findElement(By.xpath(dressesLocators.SORT_BY_OPTION_3_XPATH)));
        firstItemInGridImg = new Link(base, driver.findElement(By.xpath(dressesLocators.FIRST_ITEM_IN_GRID_IMG_XPATH)));
        dressesPageSubHeading = new Label(base, driver.findElement(By.xpath(dressesLocators.DRESSES_SUBHEADING_LABEL_XPATH)));
        firstItemInGrid = new Label(base, driver.findElement(By.xpath(dressesLocators.FIRST_ITEM_IN_GRID_XPATH)));
    }

    //Sort Business Logic
    public void iSelectSortByPriceHighestFirst(){
        firstItemInGridImg.ScrollElementIntoView();

        sortByOverlay.waitForVisibility();
        sortByOverlay.Click();

        sortByOption3.waitForVisibility();
        sortByOption3.Click();

        //sort is broken or unknown algorithm
        //Here need to have waittime for sorting script to FINISH
    }

    //Select Business Logic
    public void iClickFirstItemInGridImage(){
        firstItemInGridImg.HoverToElement();
        firstItemInGridImg.ClickElemntWithScript();
    }

    //Misc Business Logic
    public boolean isPageWithSubHeadingTextDisplayed(){
        return dressesPageSubHeading.IsElementDisplayed();
    }

}
