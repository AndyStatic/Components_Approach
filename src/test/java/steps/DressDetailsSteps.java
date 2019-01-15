package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.DressDetailsPage;
import pages.DressesPage;
import steps.base.BaseUtil;

public class DressDetailsSteps extends BaseUtil {

    private BaseUtil base;
    private DressDetailsPage dressDetailsPage;

    public DressDetailsSteps(BaseUtil base){
        this.base = base;
        dressDetailsPage = new DressDetailsPage(base);
    }

    @Then("^Dress details with name \"([^\"]*)\" are displayed$")
    public void dressDetailsAreDisplayed(String dressName) throws Throwable {
        Assert.assertEquals(dressDetailsPage.dressNameIs(),dressName);
    }

    @When("^I press Add to cart button$")
    public void iPressAddToCartBtn() throws Throwable {
        dressDetailsPage.iPressAddToCartBtn();
    }

    @And("^I click Proceed To Checkout button on overlay$")
    public void iClickProceedToCheckOutBtnOnOverlay() throws Throwable {
        dressDetailsPage.iClickProceedToCheckOutBtnOnOverlay();
    }
}
