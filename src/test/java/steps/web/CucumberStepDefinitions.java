package steps.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

/**
 * All Cucumber steps are implemented in this class.
 */
public class CucumberStepDefinitions {
    /**
     * Cucumber "Before" hook that is executed before each suite run.
     * Set's up browser for Selenide.
     */
    @Before
    public void setUp(){
        //Set up Browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        Configuration.browser = "chrome";
        Configuration.reportsFolder = "build/allure-results";
        Configuration.timeout = 30000;
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "normal";
        Configuration.browserCapabilities = capabilities;
    }

    /**
     * Cucumber "After" hook that is executed after each suite run.
     */
    @After
    public void tearDown() {
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    /**
     * @param relativeOrAbsoluteUrl -
     *  If not starting with "http://" or "https://" or "file://", it's considered to be relative URL.
     *  In this case, it's prepended by baseUrl
     */
    @Given("I open \"([^\"]*)\" url")
    public void openPage(String relativeOrAbsoluteUrl) {
        open(relativeOrAbsoluteUrl);
    }


    @Then("I should see \"([^\"]*)\" page title")
    public void iShouldSeePageTitle(String pageTitle) {
        $("title").shouldHave(attribute("text", pageTitle));
    }
}
