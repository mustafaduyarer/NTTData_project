package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.GooglePage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Buscar_en_Google_SD {

    GooglePage googlePage = new GooglePage();
    Actions actions= new Actions(Driver.getDriver());



    @Given("user should be able to go url")
    public void userShouldBeAbleToGoUrl() {
        Driver.getDriver().get("https://www.google.com/");
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(googlePage.acceptTodas);
        BrowserUtils.waitFor(2);


    }

    @When("user should be able to write {string} search input")
    public void userShouldBeAbleToWriteSearchInput(String inputPalabra) {
       googlePage.googleInput.sendKeys(inputPalabra);
       actions.sendKeys(Keys.ENTER).perform();

    }
    @When("user search wikipedia link")
    public void userSearchWikipediaLink() {
        WebElement Links= Driver.getDriver().findElement(By.partialLinkText("https://es.wikipedia.org"));
        String href = Links.getAttribute("Href");
        System.out.println("LinkOfWikipedia ="+ href);
        BrowserUtils.waitFor(2);
        Links.click();


    }

    @Then("take a screen shot wikipeda")
    public void takeAScreenShotWikipeda() throws IOException {
        File scrFile = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/src/test/resources/screenshot.png"));
    }

}





