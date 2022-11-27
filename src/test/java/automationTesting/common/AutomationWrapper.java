package automationTesting.common;

import org.openqa.selenium.WebElement;
import repository.PageElement;
import wrappers.SeleniumWrapper;

import java.util.List;

public class AutomationWrapper extends SeleniumWrapper {

    public AutomationWrapper() {
    }
        public void verifyHomePageHeaders(PageElement element, List<String> verticalHeaderList) {

            List<WebElement> locatedHeaderElements = locateElements(element);

            if(locatedHeaderElements.size() == verticalHeaderList.size()) {
                reportStep("Actual "+ locatedHeaderElements.size() + " vertical header of home page count matched with expected count " + verticalHeaderList.size(), Status.PASS);
            }else {
                reportStep("Actual "+ locatedHeaderElements.size() + " vertical header of home page count matched with expected count " + verticalHeaderList.size(), Status.WARN);
            }

            for (String headerText : verticalHeaderList) {
                String text = headerText;
                boolean flag = true;
                String verticalHeaderText = "";
                for (WebElement webElement : locatedHeaderElements) {
                    if(webElement.getText().equals(text.trim())) {
                        verticalHeaderText = webElement.getText();
                        flag = true;
                        break;
                    }else {
                        flag = false;
                    }
                }

                if(flag)
                    reportStep("Actual "+ text + " vertical header matched with expected " + verticalHeaderText, Status.PASS);
                else
                    reportStep("Expected "+ text + " vertical header is not present ", Status.WARN);
            }
        }

    }

