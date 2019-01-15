package components;

import org.openqa.selenium.WebElement;
import steps.base.BaseUtil;

public class RadioButton extends ContentElement {

    private WebElement webElement;

    public RadioButton(BaseUtil base, WebElement webElement) {
        super(base, webElement);
        this.webElement=webElement;
    }

    public void Select()
    {
        if (!webElement.isSelected())
        {
            webElement.click();
        }
    }
    public void Deselect()
    {
        if (webElement.isSelected())
        {
            webElement.click();
        }
    }
}
