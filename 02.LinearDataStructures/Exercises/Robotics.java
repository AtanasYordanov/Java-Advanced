package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(";");
        String startTime = reader.readLine();
        long time = getTime(startTime);
        Map<String, Long> robotTimes = new HashMap<>();
        Map<String, Long> robotsProcessTimes = new HashMap<>();
        List<String> robotsByAppearance = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            String[] data = token.split("-");
            String name = data[0];
            long processTime = Long.parseLong(data[1]);
            robotsByAppearance.add(name);
            robotsProcessTimes.put(name, processTime);
            robotTimes.put(name, 0L);
        }
        Deque<String> productsQueue = new ArrayDeque<>();
        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            productsQueue.offer(line);
        }
        while (!productsQueue.isEmpty()) {
            time++;
            String product = productsQueue.poll();
            boolean found = false;
            long minTime = Long.MAX_VALUE;
            for (String robot : robotsByAppearance) {
                long robotTime = robotTimes.get(robot);
                if (robotTime <= time) {
                    String timeAsStr = getTimeAsStr(time);
                    sb.append(robot).append(" - ").append(product).append(" [")
                            .append(timeAsStr).append("]").append(System.lineSeparator());
                    robotTimes.put(robot, time + robotsProcessTimes.get(robot));
                    found = true;
                    break;
                } else if (robotTime < minTime) {
                    minTime = robotTime;
                }
            }
            if (!found) {
                minTime--;
                productsQueue.offer(product);
                long diff = minTime - time;
                for (int i = 0; i < diff; i++) {
                    productsQueue.offer(productsQueue.poll());
                }
                time = minTime;
            }
        }
        System.out.print(sb);
    }

    private static String getTimeAsStr(long time) {
        long hours = (time / 3600) % 24;
        time %= 3600;
        long minutes = time / 60;
        time %= 60;
        long seconds = time;
        StringBuilder sb = new StringBuilder();
        addZeroes(hours, sb);
        sb.append(":");
        addZeroes(minutes, sb);
        sb.append(":");
        addZeroes(seconds, sb);
        return sb.toString();
    }

    private static void addZeroes(long value, StringBuilder sb) {
        if (value == 0) {
            sb.append("00");
        } else if (value < 10) {
            sb.append("0").append(value);
        } else {
            sb.append(value);
        }
    }

    private static long getTime(String startTime) {
        String[] tokens = startTime.split(":");
        long hours = Integer.parseInt(tokens[0]);
        long minutes = Integer.parseInt(tokens[1]);
        long seconds = Integer.parseInt(tokens[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }
}