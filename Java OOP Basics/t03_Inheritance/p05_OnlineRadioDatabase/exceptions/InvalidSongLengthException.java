package t03_Inheritance.p05_OnlineRadioDatabase.exceptions;

public class InvalidSongLengthException extends InvalidSongException {
    public InvalidSongLengthException() {
        super("Invalid song length.");
    }

    protected InvalidSongLengthException(String message) {
        super(message);
    }
}
