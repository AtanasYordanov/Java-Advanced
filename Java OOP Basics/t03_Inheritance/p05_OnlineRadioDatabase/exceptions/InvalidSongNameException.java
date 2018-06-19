package t03_Inheritance.p05_OnlineRadioDatabase.exceptions;

public class InvalidSongNameException extends InvalidSongException {
    public InvalidSongNameException() {
        super("Song name should be between 3 and 30 symbols.");
    }
}
