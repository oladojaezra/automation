package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * This wrapper class is specifically for TestNG framework.
 */
public class TestNgWrapper extends SeleniumWrapper {

    /**
     * This method gets executed by the fromework before the test suite.
     */
    @BeforeSuite
    public void beforeSuite() {
        startResult();
    }

    /**
     * This method is mainly to set the right enviornment before executing the tests.
     *
     * @throws Exception This exception is thrown when framework runs into error.
     */
    @BeforeMethod
    @Parameters("environment")
    public void setEnvironment(String environment) throws Exception {
        environmentType = environment;
        System.out.println("Env" + environment);
        if (!(regionList.contains(REGION_NAME))) {
            regionList.add(REGION_NAME);
        }
//    	testCaseName = sc.getName();
        invokeApp();
//        startTestCase(sc.getName(), sc.getId(), environmentType);
//        startNode(REGION_NAME);
//        reportBrowserLaunch();
    }

    @BeforeTest
    public void beforeMethod() {

    }

    /**
     * This method is executed once the test suite execution is done.
     *
     * @throws Exception This exception could be thrown when we are cleaning up environment and run into problem.
     */
    @AfterSuite
    public void afterSuite() throws Exception {
        endResult();

    }

    @AfterTest(alwaysRun = true)
    public void afterTest() throws Exception {
        environmentType = null;
    }

    @AfterMethod
    public void afterMethod() {

    }
}
