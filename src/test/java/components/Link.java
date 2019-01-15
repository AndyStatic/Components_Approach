package components;

import org.openqa.selenium.WebElement;
import steps.base.BaseUtil;

public class Link extends ContentElement {

    private WebElement webElement;

    public Link(BaseUtil base, WebElement webElement) {
        super(base, webElement);
        this.webElement=webElement;
    }

    public void Click(){
        webElement.click();
    }
}
