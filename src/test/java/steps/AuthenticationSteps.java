package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.AuthenticationPage;
import steps.base.BaseUtil;

public class AuthenticationSteps extends BaseUtil {

    private BaseUtil base;
    private AuthenticationPage authenticationPage;

    public AuthenticationSteps(BaseUtil base){
        this.base = base;
        authenticationPage = new AuthenticationPage(base);
    }

    @Then("^I navigate to page with title \"([^\"]*)\"$")
    public void iNavigateToPageWithTitle(String linkText) throws Throwable {
        Assert.assertTrue(base.driver.getTitle().equals(linkText));
    }

    //Create account
    @When("^I enter \"([^\"]*)\" email address for new account$")
    public void iEnterEmailForNewAccount(String email) throws Throwable {
        authenticationPage.iEnterEmailForCreateAnAccount(email);
    }

    @And("^I press the Create an account button$")
    public void iPressTheCreateAnAccBtn() throws Throwable {
        authenticationPage.iPressSubmitForCreateAnAccount();
    }

    //Login
    @When("^I enter \"([^\"]*)\" email address for registered account$")
    public void iEnterEmailForRegisteredAcc(String email) throws Throwable {
        authenticationPage.iEnterEmailForRegisteredUser(email);
    }

    @And("^I enter \"([^\"]*)\" password for registered account$")
    public void iEnterPasswdForRegisteredAcc(String password) throws Throwable {
        authenticationPage.iEnterPasswordForRegisteredUser(password);
    }

    @And("^I press the Sign in button$")
    public void iPressTheSignInBtn() throws Throwable {
        authenticationPage.iPressSubmitForRegisteredUser();
    }

}
