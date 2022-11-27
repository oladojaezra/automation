package repository;

import java.io.File;
import java.util.Iterator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * This class provides the repository context so you can fetch context for all the pages.
 */
public class RepositoryContext {

    private String contextCurrentPage = "Home";
    private WebRepository webRepository;


    public String getContextCurrentPage() {
        return this.contextCurrentPage;
    }

    public void setContextCurrentPage(String contextCurrentPage) {
        this.contextCurrentPage = contextCurrentPage;
    }


    /**
     * This method loads the object repository from the provided repository file.
     */
    public void loadRepository() {

        try {

//            ClassLoader classLoader = getClass().getClassLoader();
            String path = System.getProperty("user.dir") + "/src/main/resources/ObjectRepository.xml";
            File objectRepositoryfile = new File(path);
            System.out.println("File path" + objectRepositoryfile.getAbsolutePath());
            JAXBContext jaxbContext = JAXBContext.newInstance(WebRepository.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            this.webRepository = (WebRepository) jaxbUnmarshaller.unmarshal(objectRepositoryfile);
        } catch (JAXBException exception) {
            exception.printStackTrace();
        }

    }

    /**
     * This method fetches the webpage object based on the page name.
     *
     * @param pageName The page name for which we want to receive the page object.
     * @return Webpage object for the given page name.
     */
    public WebPage getWebPage(String pageName) {

        Iterator<WebPage> itr = this.webRepository.getWebPages().iterator();

        WebPage page;

        do {
            if (!itr.hasNext()) {
                throw new DataNotFoundInRepositoryException("Given page not found in the repository->" + pageName);
            }
            page = (WebPage) itr.next();
        } while (!page.getPageName().equals(pageName));

        System.out.println(page.getPageName());

        return page;

    }

    /**
     * This method provides the page element object when the page and element name is provided.
     *
     * @param pageName Page name for which we want to fetch the page element.
     *
     * @param elementName Element name for which we want to fetch the page element.
     *
     * @return Page element for the given page name and element name.
     */
    public PageElement getElement(String pageName, String elementName) {

        PageElement element = null;

        try {
            element = this.getWebElement(pageName, elementName);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return element;

    }


    /**
     * The method provides the page element object based on the element name.
     *
     * @param elementName Element name for which we want to fetch the page element.
     *
     * @return  Page element for the given element name.
     */
    public PageElement getElement(String elementName) {
        return this.getElement(this.contextCurrentPage, elementName);
    }

    /**
     * This method provides the Page element object based on the page name and element name.
     *
     * @param pageName Page name for which we want to fetch the Page element object
     * @param elementName Element name for which we want to fetch the page element object.
     * @return Page element for the the given page name and element name.
     */
    public PageElement getWebElement(String pageName, String elementName) {

        Iterator<PageElement> itr = this.getWebPage(pageName).getWebPageElement().getWebElements().iterator();

        PageElement element;

        do {
            if (!itr.hasNext()) {
                throw new DataNotFoundInRepositoryException("Given element not found in the repository->"
                        + elementName);
            }
            element = itr.next();

        } while (!element.getElementName().equals(elementName));

        return element;
    }
}
