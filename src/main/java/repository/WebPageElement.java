package repository;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * This class represents the various UI elements present on the Webpage.
 */
@XmlRootElement(name = "uiElements")
public class WebPageElement {

    private List<PageElement> webElements;

    @XmlElement(name = "uiobject")
    public List<PageElement> getWebElements() {
        return this.webElements;
    }

    public void setWebElements(List<PageElement> webElements) {
        this.webElements = webElements;
    }

    public String toString() {
        return "WebPageElement [webElements=" + this.webElements + "]";
    }

}
