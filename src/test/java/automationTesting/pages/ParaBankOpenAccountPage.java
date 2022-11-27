package automationTesting.pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.support.ui.Select;
import repository.RepositoryContext;
import wrappers.SeleniumWrapper;
import wrappers.WrapperConstants;

public class ParaBankOpenAccountPage extends SeleniumWrapper {
    public RepositoryContext context = new RepositoryContext();

    public ParaBankOpenAccountPage() throws InterruptedException {

        context.setContextCurrentPage("open_new_account");
        context.loadRepository();
        waitForTitleToLoad("ParaBank | Open Account", WrapperConstants.MEDIUM_WAIT);

    }

    @And("User select the Saving Account")
    public void userSelectTheSavingAccount() {
        waitUntilElementVisible(context.getElement("selectSavingAccount"),  WrapperConstants.MEDIUM_WAIT);
        Select selectElement = new Select(locateElement(context.getElement("selectSavingAccount")));
        selectElement.selectByVisibleText("SAVINGS");

    }

    @And("User clicks on new open account link")
    public void userClicksOnNewOpenAccountLink() {
        waitUntilElementVisible(context.getElement("accountOpenButton"),  WrapperConstants.MEDIUM_WAIT);
        click(context.getElement("accountOpenButton"), "User clicks on the Open new account");
    }

    @And("User saves the new open account id")
    public void userSavesTheNewOpenAccountId() {
        waitUntilElementVisible(context.getElement("newAccountId"),  WrapperConstants.MEDIUM_WAIT);
        String accountId = getText(locateElement(context.getElement("newAccountId")));
        frameworkData.put("newAccountId",accountId);
    }
}

