package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.MyAccountPage;
import steps.base.BaseUtil;

public class MyAccountSteps extends BaseUtil {

    private BaseUtil base;
    private MyAccountPage myAccountPage;

    public MyAccountSteps(BaseUtil base){
        this.base = base;
        myAccountPage = new MyAccountPage(base);
    }

    @Then("^My Account page with welcome text is displayed$")
    public void iNavigateToCreateNewAccountPage() throws Throwable {
        Assert.assertTrue(myAccountPage.isPageWithAccWelcomeTextDisplayed());
    }

    @When("^I click Dresses link$")
    public void iClickSignInLink() throws Throwable {
        myAccountPage.iClickDressesLink();
    }

    @When("^I click Cart$")
    public void iClickCart() throws Throwable {
        myAccountPage.iClickCart();
    }
}
