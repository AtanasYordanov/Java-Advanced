package t06_OpenClosedLiskov.p01_Logger.model.files;

import t06_OpenClosedLiskov.p01_Logger.api.File;

public class LogFile implements File {

    private int size;
    private StringBuilder content;

    public LogFile() {
        this.content = new StringBuilder();
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void write(String message) {
        this.content.append(message);
        this.size += this.getMessageSize(message);
    }

    private int getMessageSize(String message) {
        return message.chars().filter(Character::isAlphabetic).sum();
    }
}
