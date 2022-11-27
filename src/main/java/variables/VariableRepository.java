package variables;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the Variable Repository.
 */
@XmlRootElement(name = "variables")
public class VariableRepository {

    private List<FeatureElement> featureElements;

    @XmlElement(name = "feature")
    public List<FeatureElement> getFeatureElements() {
        return this.featureElements;
    }

    public void setFeatureElements(List<FeatureElement> featureElements) {
        this.featureElements = featureElements;
    }

    public String toString() {
        return "VariableRepository [featureElements=" + this.featureElements + "]";
    }

}
