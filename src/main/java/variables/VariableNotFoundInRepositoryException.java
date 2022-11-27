package variables;

/**
 * This class represents the exception class which is thrown when variable is not found in the DOM.
 */
public class VariableNotFoundInRepositoryException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_MESSAGE = "Variable not found in Repository";

    public VariableNotFoundInRepositoryException() {
        super(DEFAULT_MESSAGE);
    }

    public VariableNotFoundInRepositoryException(String message) {
        super(message);
    }


}
