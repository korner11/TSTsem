package tst.sem.Exceptions;

/**
 * Created by Michal on 27.03.2017.
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        getMessage();
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
