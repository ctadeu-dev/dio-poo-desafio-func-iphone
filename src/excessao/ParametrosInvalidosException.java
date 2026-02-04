package excessao;

public class ParametrosInvalidosException extends Exception {
    @java.io.Serial
    static final long serialVersionUID = -3387516993124229948L;

    /**
     * Constructs a new exception.
     */
    public ParametrosInvalidosException() {
        super();
    }
    public ParametrosInvalidosException(String message) {
        super(message);
    }
    public ParametrosInvalidosException(String message, Throwable cause) {
        super(message, cause);
    }
    public ParametrosInvalidosException(Throwable cause) {
        super(cause);
    }

}
