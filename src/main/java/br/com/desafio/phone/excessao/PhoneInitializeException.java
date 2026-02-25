package br.com.desafio.phone.excessao;

public class PhoneInitializeException extends Exception {
    @java.io.Serial
    static final long serialVersionUID = -3387516993124229948L;

    /**
     * Constructs a new exception.
     */
    public PhoneInitializeException() {
        super();
    }
    public PhoneInitializeException(String message) {
        super(message);
    }
    public PhoneInitializeException(String message, Throwable cause) {
        super(message, cause);
    }
    public PhoneInitializeException(Throwable cause) {
        super(cause);
    }

}
