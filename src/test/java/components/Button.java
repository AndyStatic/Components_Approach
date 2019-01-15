package components;

import org.openqa.selenium.WebElement;
import steps.base.BaseUtil;

public class Button extends ContentElement {

    private WebElement webElement;

    public Button(BaseUtil base, WebElement webElement) {
        super(base, webElement);
        this.webElement=webElement;
    }

    public void Submit(){
        webElement.submit();
    }

    public void Click(){
        webElement.click();
    }
}
