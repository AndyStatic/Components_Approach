package components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import steps.base.BaseUtil;

public class Dropdown extends ContentElement {

    private WebElement webElement;

    public Dropdown(BaseUtil base, WebElement webElement) {
        super(base, webElement);
        this.webElement=webElement;
    }

    public void SelectByVisibleText(String visibleText){
        Select dropdown = new Select(webElement);
        dropdown.selectByVisibleText(visibleText);
    }

    public void SelectByIndex(int index){
        Select dropdown = new Select(webElement);
        dropdown.selectByIndex(index);
    }

    //selects an option by the value of its "value" attribute
    public void SelectByValue(String value){
        Select dropdown = new Select(webElement);
        dropdown.selectByValue(value);
    }
}
