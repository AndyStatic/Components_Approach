package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import steps.base.BaseUtil;

public class CartSteps extends BaseUtil {

    private BaseUtil base;
    private CartPage cartPage;

    public CartSteps(BaseUtil base){
        this.base = base;
        cartPage = new CartPage(base);
    }

    @Then("^Cart page heading is displayed$")
    public void iNavigateToCartPage() throws Throwable {
        Assert.assertTrue(cartPage.isPageWithHeadingTextDisplayed());
    }

    @Then("^I navigate to Cart page with title \"([^\"]*)\"$")
    public void iNavigateToPageWithTitle(String cartPageTitle) throws Throwable {
        Assert.assertTrue(base.driver.getTitle().equals(cartPageTitle));
    }

    @And("^Cart contains \"([^\"]*)\" dress$")
    public void cartContain(String dressName) throws Throwable {
        Assert.assertEquals(cartPage.cartContainsDressName(),dressName);
    }

    @When("^I click Sign out link$")
    public void iClickSignInLink() throws Throwable {
        cartPage.iClickSignOutLink();
    }
}
