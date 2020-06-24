package steps.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.Random;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

/**
 * All Cucumber steps are implemented in this class.
 */
public class CucumberStepDefinitions {
    String randomCityName;

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

    @And("I open city choice menu")
    public void iOpenCityChoiceMenu() {
        String menuXpath = "//div[contains(@class, 'region')]//a[contains(@class, 'chooseRepresent')]";

        $(By.xpath(menuXpath)).click();
    }

    @Then("I should see \"([^\"]*)\" text")
    public void iShouldSeeText(String text) {
        String textXpath = "//*[contains(., \"" + text + "\")]";

        $(By.xpath(textXpath)).shouldBe(appears);
    }

    @And("I add item to shopping cart by sale price")
    public void iAddItemToShoppingCartBySalePrice() {
        String buttonXpath = "//div[@id=\"goods-analog\"]//a[contains(@data-behavior, \"add-to-cart\")]";

        $(By.xpath(buttonXpath)).click();
    }

    @And("I choose random city with delivery")
    public void iChooseDeliveryToRandomCity() {
        String citiesXpath = "//div[contains(@class, 'deliveryCourierConteiner')]//a[not(contains(@class, 'fs-14 fst-b'))]";
        int index;

        int numberOfCities = $$(By.xpath(citiesXpath)).size();
        if (numberOfCities>1) {
            index = (new Random()).nextInt(numberOfCities - 1);
        } else {
            index = 1;
        }

        SelenideElement randomCity = $(By.xpath(citiesXpath), index);
        randomCityName = randomCity.getText();
        randomCity.click();
    }

    @Then("I should see random city chosen")
    public void iShouldSeeCityChosen() {
        String actualCityXpath = "//div[contains(@class, 'region')]//a[contains(@class, 'chooseRepresent')]/span";

        String actualCityName = $(By.xpath(actualCityXpath)).getText();

        Assert.assertEquals(actualCityName, randomCityName);
    }

    @And("I choose random item with best price")
    public void iChooseRandomItemWithBestPrice() {
        String bestPriceItemsXpath = "//div[contains(@class, 'tile-box product') and .//a[contains(., 'Лучшая цена')]]//a[contains(., 'В корзину')]";
        int index;

        int numberOfItems = $$(By.xpath(bestPriceItemsXpath)).size();
        if (numberOfItems>1) {
            index = (new Random()).nextInt(numberOfItems - 1);
        } else {
            index = 1;
        }

        $(By.xpath(bestPriceItemsXpath), index).click();
    }

    @Then("I should see \"([^\"]*)\" phone number for \"([^\"]*)\" department")
    public void iShouldSeePhoneNumberForDepartment(String phoneNumber, String departmentName) {
        String phoneXpath = "//tr[contains(@class, 'contact_page_table_line') and .//td[contains(., '" + departmentName + "')]]//td[contains(@class, 'contact_info_table_telefon')]";

        Assert.assertEquals($(By.xpath(phoneXpath)).getText(), phoneNumber);
    }
}
