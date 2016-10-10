package in.co.codenation.ws;

/**
 * Created by mnganesh on 04/10/16.
 */
public class GreetModel {
    private final String type, message;

    public GreetModel(String message) {
        this.message = message;
        this.type = "greet";
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
