package t03_Inheritance.p05_OnlineRadioDatabase.exceptions;

public class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException() {
        super("Invalid song.");
    }

    protected InvalidSongException(String message) {
        super(message);
    }
}
