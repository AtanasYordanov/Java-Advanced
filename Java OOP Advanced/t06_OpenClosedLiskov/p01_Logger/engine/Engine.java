package t06_OpenClosedLiskov.p01_Logger.engine;

import t06_OpenClosedLiskov.p01_Logger.api.Appender;
import t06_OpenClosedLiskov.p01_Logger.api.Layout;
import t06_OpenClosedLiskov.p01_Logger.api.Logger;
import t06_OpenClosedLiskov.p01_Logger.enums.ReportLevel;
import t06_OpenClosedLiskov.p01_Logger.model.loggers.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Engine implements Runnable {
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int appendersCount = Integer.parseInt(reader.readLine());
            Appender[] appenders = new Appender[appendersCount];
            for (int i = 0; i < appendersCount; i++) {
                String[] tokens = reader.readLine().split("\\s+");
                Layout layout = this.getLayout(tokens[1]);
                ReportLevel reportLevel = tokens.length == 3 ? ReportLevel.valueOf(tokens[2]) : ReportLevel.INFO;
                Appender appender = this.getAppender(layout, tokens[0]);
                appender.setReportLevel(reportLevel);
                appenders[i] = appender;
            }
            Logger logger = new MessageLogger(appenders);
            for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
                String[] tokens = line.split("\\|");
                ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
                String dateTime = tokens[1];
                String message = tokens[2];
                this.logMessage(logger, reportLevel, dateTime, message);
            }
            System.out.println(logger.getLogInfo());
        } catch (IOException | InstantiationException | NoSuchMethodException
                | InvocationTargetException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void logMessage(Logger logger, ReportLevel reportLevel, String dateTime, String message)
            throws InvocationTargetException, IllegalAccessException {
        Class loggerClass = logger.getClass();
        Method method = Arrays.stream(loggerClass.getMethods())
                .filter(m -> m.getName().equalsIgnoreCase("log" + reportLevel))
                .findFirst()
                .orElseThrow();
        method.invoke(logger, dateTime, message);
    }

    private Appender getAppender(Layout layout, String appenderName) throws NoSuchMethodException, ClassNotFoundException
            , IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("t06_OpenClosedLiskov.p01_Logger.model.appenders." + appenderName);
        return (Appender) clazz.getConstructor(Layout.class).newInstance(layout);
    }

    private Layout getLayout(String layoutName) throws ClassNotFoundException, NoSuchMethodException
            , IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("t06_OpenClosedLiskov.p01_Logger.model.layouts." + layoutName);
        return (Layout) clazz.getConstructor().newInstance();
    }
}
