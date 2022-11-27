package variables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * TODO: Not sure where this is used. If it is not used we can remove this in subsequent cleanup task.
 */
public class VariableContext {

    private String contextCurrentFeature = "default";
    private VariableRepository variableRepository;
    private JAXBContext jaxbContext;
    private Marshaller jaxbMarshaller;
    private Unmarshaller jaxbUnmarshaller;

    public String getContextCurrentFeature() {
        return this.contextCurrentFeature;
    }

    public void setContextCurrentFeature(String contextCurrentFeature) {
        this.contextCurrentFeature = contextCurrentFeature;
    }

    /**
     * This method is used to load the varilable respository from the xml file.
     *
     * @throws FileNotFoundException This exception is thrown when variable repository file is not found.
     */
    public void loadVariableRepository() throws FileNotFoundException {

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            final File objectRepositoryfile = new File(classLoader.getResource("VariableRepository.xml").getFile());
            final FileInputStream fis = new FileInputStream(objectRepositoryfile);
            this.jaxbContext = JAXBContext.newInstance(VariableRepository.class);
            this.jaxbMarshaller = jaxbContext.createMarshaller();
            this.jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            this.variableRepository = (VariableRepository) jaxbUnmarshaller.unmarshal(fis);
        } catch (JAXBException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * This method get the varilable value.
     *
     * @param variableName varialbe name.
     * @return return the varialble value
     */
    public String getVariableValue(final String variableName) {
        String value = null;
        try {
            value = this.getVariableElement(this.getFeatureElement(this.contextCurrentFeature),
                    variableName).getVariableValue();
        } catch (VariableNotFoundInRepositoryException var8) {
            var8.printStackTrace();
        }
        return value;
    }

    /**
     *  This method is a helper method that sets the variable value.
     *
     * @param variableName Variable name whose value will be set.
     *
     * @param variableValue The value that will be used to set the variable.
     *
     * @throws Exception it will be thrown if we run into any error issue while setting the value.
     */
    public void setVariableValue(String variableName, String variableValue) throws Exception {
        VariableElement element;
        try {
            element = this.getVariableElement(this.getFeatureElement(this.getContextCurrentFeature()), variableName);
            element.setVariableValue(variableValue);
        } catch (VariableNotFoundInRepositoryException var8) {
            try {
                element = this.getVariableElement(this.getFeatureElement("default"), variableName);
                element.setVariableValue(variableValue);
            } catch (VariableNotFoundInRepositoryException var7) {


                element = new VariableElement();
                element.setVariableName(variableName);
                element.setVariableValue(variableValue);
                final FeatureElement defaultFeature = this.getFeatureElement("default");
                defaultFeature.getVariables().add(element);
            }

        }
        ClassLoader classLoader = getClass().getClassLoader();
        File objectRepositoryfile = new File(classLoader.getResource("VariableRepository.xml").getFile());
        this.jaxbMarshaller.marshal(this.variableRepository, objectRepositoryfile);
    }

    private VariableElement getVariableElement(FeatureElement featureElement, String variableName) {
        Iterator<VariableElement> itr = featureElement.getVariables().iterator();
        VariableElement element;
        do {
            if (!itr.hasNext()) {
                throw new VariableNotFoundInRepositoryException("variable " + variableName + " not found in section");
            }
            element = itr.next();
        } while (!element.getVariableName().equalsIgnoreCase(variableName));

        return element;
    }

    private FeatureElement getFeatureElement(String featureName) {
        if (this.variableRepository == null) {
            try {
                ClassLoader classLoader = getClass().getClassLoader();
                File objectRepositoryfile = new File(classLoader.getResource("VariableRepository.xml").getFile());
                FileInputStream fis = new FileInputStream(objectRepositoryfile);
                this.jaxbContext = JAXBContext.newInstance(VariableRepository.class);
                this.jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                this.variableRepository = (VariableRepository) jaxbUnmarshaller.unmarshal(fis);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Iterator<FeatureElement> itr = this.variableRepository.getFeatureElements().iterator();
        FeatureElement element;
        do {
            if (!itr.hasNext()) {
                throw new VariableNotFoundInRepositoryException();
            }
            element = itr.next();
        } while (!element.getFeatureName().equalsIgnoreCase(featureName));

        return element;
    }
}
