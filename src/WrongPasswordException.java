public class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
