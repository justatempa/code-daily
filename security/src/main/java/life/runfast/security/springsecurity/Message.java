package life.runfast.security.springsecurity;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/26 17:11
 */
public class Message {

    private final String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
