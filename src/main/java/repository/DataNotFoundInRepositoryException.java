package repository;

/**
 * This method is a runtime exectpion and it is thrown when We don't find the repository file.
 */
public class DataNotFoundInRepositoryException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_MESSAGE = "Data not found in Repository";

    public DataNotFoundInRepositoryException() {
        super(DEFAULT_MESSAGE);
    }

    public DataNotFoundInRepositoryException(String message) {
        super(message);
    }
}
