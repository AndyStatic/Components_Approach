package components;

import org.openqa.selenium.WebElement;
import steps.base.BaseUtil;

public class TextBox extends ContentElement {

    private WebElement webElement;

    public TextBox(BaseUtil base, WebElement webElement) {
        super(base, webElement);
        this.webElement=webElement;
    }

    public void Clear(){
        webElement.clear();
    }

    public void SetText(String text){
        webElement.sendKeys(text);
    }
}
