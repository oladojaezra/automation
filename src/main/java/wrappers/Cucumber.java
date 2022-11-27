package wrappers;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gherkin.ast.Step;

/**
 * This class represents the cucumber framework.
 */
public class Cucumber extends TestNgWrapper{

    /**
     * This method is launch before the test case to just setup the environment.
     *
     * @param sc Scenarios object that will be executed.
     *
     * @throws InterruptedException This can be thrown when the test execution is interrupted.
     */
    @Before
    public void launchBrowser(Scenario sc) throws InterruptedException {
        testCaseName = sc.getName();
//        invokeApp();
        startTestCase(sc.getName(), sc.getId(), environmentType);
        startNode(REGION_NAME);
        reportBrowserLaunch();
    }

    @After
    public void executeAfterScenario() {
        quitBrowser();
    }


}
