package variables;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents Variable element in the DOM.
 */
@XmlRootElement(name = "variable")
public class VariableElement {

    private String variableName;
    private String variableValue;

    @XmlAttribute(name = "name")
    public String getVariableName() {
        return this.variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    @XmlElement(name = "value")
    public String getVariableValue() {
        return this.variableValue;
    }

    public void setVariableValue(String variableValue) {
        this.variableValue = variableValue;
    }

    public String toString() {
        return "VariableElement [VariableName=" + this.variableName + ", VariableValue=" + this.variableValue + "]";
    }
}
