package steps.hooks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import steps.base.BaseUtil;

public class DragAndDrop extends BaseUtil {

    private BaseUtil base;
    private WebElement webElementFrom;
    private WebElement webElementTo;

    public DragAndDrop(BaseUtil base, WebElement webElementFrom, WebElement webElementTo){
        this.base = base;
        this.webElementFrom = webElementFrom;
        this.webElementTo = webElementTo;

        //Dragged and dropped
        Actions builder = new Actions(driver);
        builder.dragAndDrop(this.webElementFrom, this.webElementTo).build().perform();
    }
}
