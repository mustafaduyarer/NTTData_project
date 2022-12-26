package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ApiUtilities;



public class petShopApiSD {
    @Given("user connects to the {string} api")
    public void userConnectsToTheApi(String endPoint) {
        ApiUtilities.connectWithGetMethod(endPoint);


    }

    @Then("user verifys satatus code is {int}")
    public void userVerifysSatatusCodeIs(int statusCode) {
        ApiUtilities.verifyStatusCode(statusCode);

    }


}

