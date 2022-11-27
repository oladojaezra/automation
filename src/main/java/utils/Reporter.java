package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * This is an abstract class for Reporter. It provides some common functionalities to its subclasses.
 */
public abstract class Reporter {

    /**
     * This enum represents the status of each test cases.
     */
    public enum Status {
        FAIL,
        INFO,
        PASS,
        WARN
    }

    public static final String REGION_NAME = "Automation";
    public static ExtentHtmlReporter html;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentTest suiteTest;
    public static String testCaseName;
    public static String jenkinsBuildNumber;
    public static List<String> regionList;
    private static Map<RemoteWebDriver, ExtentTest> testDriver;
    private static Map<RemoteWebDriver, ExtentTest> nodeDriver;

    /**
     * This method provides remote web driver based on the underlying platform.
     *
     * @return The platform and browser specific driver.
     */
    public abstract RemoteWebDriver getDriver();

    /**
     * This method is provides the snap number that could be used to name the screenshot.
     *
     * @return A random snap number.
     */
    public abstract long getScreenshotNumber();

    /**
     * This method initializes the test report data structure.
     */
    public void startResult() {
        testDriver = new HashMap<RemoteWebDriver, ExtentTest>();
        nodeDriver = new HashMap<RemoteWebDriver, ExtentTest>();
        regionList = new ArrayList<String>();
//        html.loadXMLConfig("./src/main/resources/runnerconfig/extent.xml");
        String currentPAth = System.getProperty("user.dir");
        html = new ExtentHtmlReporter(currentPAth + "/reports/result.html");
        html.loadXMLConfig(currentPAth + "/src/main/resources/runnerconfig/extent.xml");
        html.setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(html);
        extent.setSystemInfo("Application", "Automation");
//        extent.setSystemInfo("Environment", "Dev");
    }

    /**
     * This method starts the test case and record the result in the report.
     *
     * @param testCaseName The name of the test case.
     * @param testDescription Test description.
     * @param platform Platform on which we are running the test.
     * @return ExtentTest item that gets added to the test report.
     */
    public synchronized ExtentTest startTestCase(String testCaseName, String testDescription, String platform) {
        suiteTest = extent.createTest(testCaseName, testDescription);
        suiteTest.assignCategory(platform);
        suiteTest.assignAuthor(REGION_NAME + "_" + platform);
        testDriver.put(getDriver(), suiteTest);
        return test;
    }

    /**
     * This method initializes specific node that runs the test.
     *
     * @param region Basically the project name.
     *
     * @return returns ExtentTest that could be used to generate the report.
     */
    public synchronized ExtentTest startNode(String region) {
        ExtentTest createNode = testDriver.get(getDriver()).createNode(region);
        nodeDriver.put(getDriver(), createNode);
        return nodeDriver.get(getDriver());
        

    }

    /**
     * This method add the test step in the report.
     *
     * @param desc Descrition of the step.
     * @param status Status of the step.
     * @param snap a flag to enable or disable screenshot capturing.
     */
    public void reportStep(String desc, Status status, boolean snap) {
        MediaEntityModelProvider img = null;
        if (snap && !status.equals(Status.INFO)) {
            long snapNumber = getScreenshotNumber();
            try {
                img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/" + snapNumber + ".jpg")
                        .build();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (status.equals(Status.PASS)) {
            nodeDriver.get(getDriver()).pass(desc, img);
        } else if (status.equals(Status.FAIL)) {
            nodeDriver.get(getDriver()).fail(desc, img);
            throw new RuntimeException();
        } else if (status.equals(Status.WARN)) {
            nodeDriver.get(getDriver()).pass(desc, img);
        } else if (status.equals(Status.INFO)) {
            nodeDriver.get(getDriver()).info(desc);
        }
    }


    public void reportStep(String desc, Status status) {
        reportStep(desc, status, true);
    }

    /**
     * This method sets the domain name and other meta information in the report.
     */
    public void setRegionNamesInReport() {
        String regions = "";
        for (String eachRegion : regionList) {
            regions = eachRegion + "/" + regions;
        }
        extent.setSystemInfo("Region", regions.substring(0, regions.length() - 1));
        if (jenkinsBuildNumber == null) {
            jenkinsBuildNumber = "Local Execution";
        }
        extent.setSystemInfo("Build Number", jenkinsBuildNumber);
    }

    /**
     * This method finalizes the report.
     */
    public void endResult() {
        setRegionNamesInReport();
        extent.flush();
    }
}