package components;

import org.openqa.selenium.WebElement;
import steps.base.BaseUtil;

public class Label extends ContentElement {

    private WebElement webElement;

    public Label(BaseUtil base, WebElement webElement) {
        super(base, webElement);
        this.webElement=webElement;
    }

}
