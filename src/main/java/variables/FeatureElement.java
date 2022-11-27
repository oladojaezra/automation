package variables;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the feature element.
 */
@XmlRootElement(name = "feature")
public class FeatureElement {

    private List<VariableElement> variables;
    private String featureName;

    @XmlElement(name = "variable")
    public List<VariableElement> getVariables() {
        return this.variables;
    }

    public void setVariables(List<VariableElement> variables) {
        this.variables = variables;
    }

    @XmlAttribute(name = "name")
    public String getFeatureName() {
        return this.featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String toString() {
        return "FeatureElement [FeatureName=" + this.featureName + ", variables=" + this.variables + "]";
    }

}
