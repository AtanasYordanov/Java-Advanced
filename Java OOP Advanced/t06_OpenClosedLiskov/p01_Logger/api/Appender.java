package t06_OpenClosedLiskov.p01_Logger.api;

import t06_OpenClosedLiskov.p01_Logger.enums.ReportLevel;

public interface Appender {
    void appendMessage(String dateTime, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);
}
