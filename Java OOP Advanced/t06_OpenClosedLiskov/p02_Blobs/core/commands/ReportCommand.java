package t06_OpenClosedLiskov.p02_Blobs.core.commands;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Executable;
import t06_OpenClosedLiskov.p02_Blobs.notifiers.BlobStateNotifier;

import java.lang.reflect.Field;

public class ReportCommand implements Executable {

    @Override
    public void execute(String[] args) {
        Class<BlobStateNotifier> notifierClass = BlobStateNotifier.class;

        try {
            Field reportField = notifierClass.getDeclaredField("reportMode");
            reportField.setAccessible(true);
            reportField.set(null, true);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
