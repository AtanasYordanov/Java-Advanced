package t06_OpenClosedLiskov.p01_Logger.model.appenders;

import t06_OpenClosedLiskov.p01_Logger.api.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    protected void append(String message) {
        System.out.println(message);
    }
}
