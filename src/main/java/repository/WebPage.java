package repository;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is a webpage class repreesnting a webpage.
 */
@XmlRootElement(name = "page")
public class WebPage {

    private WebPageElement webPageElement;
    private String pageName;

    @XmlAttribute(name = "name")
    public String getPageName() {
        return this.pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @XmlElement(name = "uiElements")
    public WebPageElement getWebPageElement() {
        return this.webPageElement;
    }

    public void setWebPageElement(WebPageElement webPageElement) {
        this.webPageElement = webPageElement;
    }

    public String toString() {
        return "WebPage [webPageElements=" + this.webPageElement + ", pageName=" + this.pageName + "]";
    }
}
