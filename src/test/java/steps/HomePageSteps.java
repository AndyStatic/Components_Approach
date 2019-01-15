package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.HomePage;
import steps.base.BaseUtil;

public class HomePageSteps extends BaseUtil {

    private BaseUtil base;
    private HomePage homePage;

    public HomePageSteps(BaseUtil base){
        this.base = base;
    }

    @Given("^I navigate to automation practice home page$")
    public void iNavigateToAutomationPracticeHomePage() throws Throwable {
        base.driver.navigate().to("http://automationpractice.com/index.php");
    }

    @When("^I click Sign in link$")
    public void iClickSignInLink() throws Throwable {
        homePage = new HomePage(base);
        homePage.iClickSignInLink();
    }
}
