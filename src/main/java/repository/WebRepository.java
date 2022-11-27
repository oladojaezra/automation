package repository;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the web repository and contains various helper method to access it.
 */
@XmlRootElement(name = "pages")
public class WebRepository {

    private List<WebPage> webPages;

    @XmlElement(name = "page")
    public List<WebPage> getWebPages() {
        return this.webPages;
    }

    public void setWebPages(List<WebPage> webPages) {
        this.webPages = webPages;
    }

    public String toString() {
        return "WebRepository [webPages=" + this.webPages + "]";
    }

}
