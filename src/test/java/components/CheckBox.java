package components;

import org.openqa.selenium.WebElement;
import steps.base.BaseUtil;

public class CheckBox extends ContentElement {

    private WebElement webElement;

    public CheckBox(BaseUtil base, WebElement webElement) {
        super(base, webElement);
        this.webElement=webElement;
    }

    public void Check()
    {
        if (!webElement.isSelected())
        {
            webElement.click();
        }
    }
    public void Uncheck()
    {
        if (webElement.isSelected())
        {
            webElement.click();
        }
    }
}
