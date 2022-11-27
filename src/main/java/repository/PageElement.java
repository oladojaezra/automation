package repository;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class is a generic class which represents various page elements.
 */
@XmlRootElement(name = "uiobject")
public class PageElement {

    private String elementName;
    private String locatorType;
    private String locator;

    @XmlAttribute(name = "name")
    public String getElementName() {
        return this.elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    @XmlAttribute(name = "locatorType")
    public String getLocatorType() {
        return this.locatorType;
    }

    public void setLocatorType(String locatorType) {
        this.locatorType = locatorType;
    }

    @XmlElement(name = "locator")
    public String getLocator() {
        return this.locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    /**
     * This method repsents the current object in a string format.
     *
     * @return String representatio nof page element.
     */
    public String toString() {
        return "WebElement [elementName=" + this.elementName + ", locatorType=" + this.locatorType + ", locator="
                + this.locator + "]";
    }
}
