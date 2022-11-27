package variables;

/**
 * This class represents the exception which get thrown when Variable repository is not found.
 */
public class VariableRepositoryNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_MESSAGE = "Variable Repository not found in classpath";

    public VariableRepositoryNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public VariableRepositoryNotFoundException(String message) {
        super(message);
    }


}
