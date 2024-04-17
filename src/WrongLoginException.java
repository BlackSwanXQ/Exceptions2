public class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
