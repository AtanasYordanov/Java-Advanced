package t06_OpenClosedLiskov.p01_Logger.model.appenders;

import t06_OpenClosedLiskov.p01_Logger.api.File;
import t06_OpenClosedLiskov.p01_Logger.api.Layout;
import t06_OpenClosedLiskov.p01_Logger.model.files.LogFile;

public class FileAppender extends BaseAppender {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.setFile(new LogFile());
    }

    @Override
    protected void append(String message) {
        this.file.write(message);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return String.format("%s, File size: %d", super.toString(), this.file.getSize());
    }
}