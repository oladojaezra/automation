package automationTesting.pages;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.interactions.Actions;
import repository.RepositoryContext;
import wrappers.SeleniumWrapper;
import wrappers.WrapperConstants;

import java.util.Iterator;
import java.util.Set;

public class ParaBankSignUpPage extends SeleniumWrapper {
    public RepositoryContext context = new RepositoryContext();
    Faker faker = new
            Faker();

    public ParaBankSignUpPage() {
        context.setContextCurrentPage("sign_up");
        context.loadRepository();
        waitForTitleToLoad("ParaBank | Register for Free Online Account Access", WrapperConstants.MEDIUM_WAIT);
    }

    @And("User enters the enters the first name")
    public void userEntersTheEntersTheFirstName() {
        waitUntilElementVisible(context.getElement("firstName"),  WrapperConstants.MEDIUM_WAIT);
        typeInput(context.getElement("firstName"),faker.name().firstName(), "User enters first name as : "+ faker.name().firstName());
    }

    @And("User enters the enters the last name")
    public void userEntersTheEntersTheLastName() {
        waitUntilElementVisible(context.getElement("lastName"),  WrapperConstants.MEDIUM_WAIT);
        typeInput(context.getElement("lastName"),faker.name().lastName(), "User enters last name as : "+ faker.name().lastName());
    }

    @And("User enters the enters the address")
    public void userEntersTheEntersTheAddress() {
        waitUntilElementVisible(context.getElement("address"),  WrapperConstants.MEDIUM_WAIT);
        typeInput(context.getElement("address"),faker.address().streetAddress(), "User enters address as : "+ faker.address().streetAddress());
    }

    @And("User enters the enters the city")
    public void userEntersTheEntersTheCity() {
        waitUntilElementVisible(context.getElement("city"),  WrapperConstants.MEDIUM_WAIT);
        typeInput(context.getElement("city"),faker.address().city(), "User enters city as : "+ faker.address().city());
    }

    @And("User enters the enters the state")
    public void userEntersTheEntersTheState() {
        waitUntilElementVisible(context.getElement("state"),  WrapperConstants.MEDIUM_WAIT);
        typeInput(context.getElement("state"),faker.address().state(), "User enters state as : "+ faker.address().state());

    }

    @And("User enters the enters the zipcode")
    public void userEntersTheEntersTheZipcode() {
        waitUntilElementVisible(context.getElement("zipcode"),  WrapperConstants.MEDIUM_WAIT);
        typeInput(context.getElement("zipcode"),faker.address().zipCode(), "User enters zipcode as : "+ faker.address().zipCode());
    }

    @And("User enters the enters the phone")
    public void userEntersTheEntersThePhone() {
        waitUntilElementVisible(context.getElement("phone"),  WrapperConstants.MEDIUM_WAIT);
        typeInput(context.getElement("phone"),faker.phoneNumber().phoneNumber(), "User enters phone as : "+ faker.phoneNumber().phoneNumber());
    }

    @And("User enters the enters the ssn")
    public void userEntersTheEntersTheSsn() {
        waitUntilElementVisible(context.getElement("ssn"),  WrapperConstants.MEDIUM_WAIT);
        typeInput(context.getElement("ssn"),"1234", "User enters SSN as : 1234");
    }

    @And("User enters the enters the username")
    public void userEntersTheEntersTheUsername() {
        waitUntilElementVisible(context.getElement("username"),  WrapperConstants.MEDIUM_WAIT);
        typeInput(context.getElement("username"),faker.name().username(), "User enters Username as : "+ faker.name().username());
        frameworkData.put("username",faker.name().username());

    }

    @And("User enters the enters the password")
    public void userEntersTheEntersThePassword() {
        waitUntilElementVisible(context.getElement("password"),  WrapperConstants.MEDIUM_WAIT);
        typeInput(context.getElement("password"),"1234", "User enters password as : 1234");
        frameworkData.put("password","1234");
    }

    @And("User enters the enters the confirm password")
    public void userEntersTheEntersTheConfirmPassword() {
        waitUntilElementVisible(context.getElement("confirmPassword"),  WrapperConstants.MEDIUM_WAIT);
        typeInput(context.getElement("confirmPassword"),"1234", "User enters confirm password as : 1234");

    }

    @When("User clicks on Register link")
    public void userClicksOnRegisterLink() {
        waitUntilElementVisible(context.getElement("register"),  WrapperConstants.MEDIUM_WAIT);
        click(context.getElement("register"), "User clicks on Register link");
    }
}
