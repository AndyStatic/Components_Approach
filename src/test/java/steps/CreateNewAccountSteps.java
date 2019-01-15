package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.CreateNewAccountPage;
import steps.base.BaseUtil;

public class CreateNewAccountSteps extends BaseUtil {

    private BaseUtil base;
    private CreateNewAccountPage createNewAccountPage;

    public CreateNewAccountSteps(BaseUtil base){
        this.base = base;
        createNewAccountPage = new CreateNewAccountPage(base);
    }

    @Then("^Create New Account page heading is displayed$")
    public void iNavigateToCreateNewAccountPage() throws Throwable {
        Assert.assertTrue(createNewAccountPage.isPageWithHeadingTextDisplayed());
    }

    @When("^I enter \"([^\"]*)\" first name for new account$")
    public void iEnterFirstNameForNewAccount(String firstName) throws Throwable {
        createNewAccountPage.iEnterFirstNameForCreateAnAccount(firstName);
    }

    @And("^I enter \"([^\"]*)\" last name for new account$")
    public void iEnterLastNameForNewAccount(String lastName) throws Throwable {
        createNewAccountPage.iEnterLastNameForCreateAnAccount(lastName);
    }

    @And("^I enter \"([^\"]*)\" password for new account$")
    public void iEnterPasswordForNewAccount(String password) throws Throwable {
        createNewAccountPage.iEnterPasswordForCreateAnAccount(password);
    }

    @And("^I enter \"([^\"]*)\" address 1 for new account$")
    public void iEnterAddress1ForNewAccount(String address1) throws Throwable {
        createNewAccountPage.iEnterAddress1ForCreateAnAccount(address1);
    }

    @And("^I enter \"([^\"]*)\" city for new account$")
    public void iEnterCityForNewAccount(String city) throws Throwable {
        createNewAccountPage.iEnterCityForCreateAnAccount(city);
    }

    @And("^I select \"([^\"]*)\" state for new account$")
    public void iSelectStateForNewAccount(String state) throws Throwable {
        createNewAccountPage.iSelectStateForCreateAnAccount(state);
    }

    @And("^I enter \"([^\"]*)\" post code for new account$")
    public void iEnterPostCodeForNewAccount(String postCode) throws Throwable {
        createNewAccountPage.iEnterPostCodeForCreateAnAccount(postCode);
    }

    @And("^I enter \"([^\"]*)\" mobile phone for new account$")
    public void iEnterPMobilePhoneForNewAccount(String mobilePhone) throws Throwable {
        createNewAccountPage.iEnterMobilePhoneForCreateAnAccount(mobilePhone);
    }

    @And("^I press the submit account button$")
    public void iPressSubmitAccountButton() throws Throwable {
        createNewAccountPage.iPressSubmitAccountButton();
    }
}
