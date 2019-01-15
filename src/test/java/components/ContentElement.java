package components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.base.BaseUtil;

public class ContentElement extends BaseUtil {
    private BaseUtil base;
    private WebElement webElement;

    public ContentElement(BaseUtil base, WebElement webElement){
        this.base = base;
        this.webElement = webElement;
    }

    //Focus
    public void HoverToElement(){
        Actions builder = new Actions(base.driver);
        builder.moveToElement(webElement).perform();
    }

    //Scroll Element Into View
    public void ScrollElementIntoView(){
        ((JavascriptExecutor) base.driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    //Click with script
    //Perform Click on LOGIN button using JavascriptExecutor
    public void ClickElemntWithScript(){
        ((JavascriptExecutor) base.driver).executeScript("arguments[0].click();", webElement);
    }

    //Get Attribute Value
    public String GetElementAttributeValue(String attributeName){
        return webElement.getAttribute(attributeName);
    }

    //Get Element Text
    public String GetElementText(){
        return webElement.getText();
    }

    public boolean IsElementDisplayed(){
        boolean isExists = true;
        try {
            webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            isExists = false;
        } catch (Exception e) {
            isExists = false;
        }
        return isExists;
    }

    public boolean IsElementEnabled(){
        try
        {
            if(webElement.isEnabled())
                return true;
            else
                return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public boolean IsElementSelected(){
        try
        {
            if(webElement.isSelected())
                return true;
            else
                return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    //waits
    public void waitForVisibility() throws Error{
        new WebDriverWait(base.driver, 60)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForElementIsClickable() throws Error{
        new WebDriverWait(base.driver, 60)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForElementTextEquals(String text) throws Error{
        new WebDriverWait(base.driver, 60)
                .until(ExpectedConditions.textToBePresentInElement(webElement,text));
    }

    public void checkJavascriptIsLoaded() {

        JavascriptExecutor js = (JavascriptExecutor)base.driver;

        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")){
            System.out.println("Page Is loaded.");
            return;
        }

        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i=0; i<25; i++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
        }
    }

    public void checkJQueryIsLoaded() {

        JavascriptExecutor js = (JavascriptExecutor)base.driver;

        //Initially bellow given if condition will check ready state of page.
        if ((Long)js.executeScript("return jQuery.active") == 0){
            System.out.println("Page Is loaded.");
            return;
        }

        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i=0; i<25; i++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            //To check page ready state.
            if ((Long)js.executeScript("return jQuery.active") == 0){
                break;
            }
        }
    }

    public void threadSleep(int sec) throws Error{
        //new WebDriverWait(base.driver, sec);
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
