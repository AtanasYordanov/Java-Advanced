package t06_OpenClosedLiskov.p01_Logger.model.layouts;

import t06_OpenClosedLiskov.p01_Logger.api.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
