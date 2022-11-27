package wrappers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import repository.PageElement;

/**
 * This is an interface for testing framework.
 */
public interface SeleniumWrapperContext {

    RemoteWebDriver getDriver();

    void setDriver(SeleniumWrapper wrappers);

    RemoteWebDriver invokeApp();

    WebElement locateElement(PageElement pageElement);

    void waitUntilElementVisible(PageElement pageElement, long timeOutInSeconds);

    void waitUntilElementClickable(PageElement pageElement, long timeOutInSeconds);

    void typeInput(PageElement pageElement, String data, String description);

    void click(PageElement pageElement, String description);
}
