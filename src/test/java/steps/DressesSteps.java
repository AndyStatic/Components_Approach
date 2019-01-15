package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.DressesPage;
import steps.base.BaseUtil;

public class DressesSteps extends BaseUtil {

    private BaseUtil base;
    private DressesPage dressesPage;

    public DressesSteps(BaseUtil base){
        this.base = base;
        dressesPage = new DressesPage(base);
    }

    @Then("^Dresses page subheading is displayed$")
    public void iNavigateToCreateNewAccountPage() throws Throwable {
        Assert.assertTrue(dressesPage.isPageWithSubHeadingTextDisplayed());
    }

    @When("^I select Sort by Price: Highest First$")
    public void iSelectStateForNewAccount() throws Throwable {
        dressesPage.iSelectSortByPriceHighestFirst();
    }

    @And("^I click first item in grid image$")
    public void iClickSignInLink() throws Throwable {
        dressesPage.iClickFirstItemInGridImage();
    }

}
