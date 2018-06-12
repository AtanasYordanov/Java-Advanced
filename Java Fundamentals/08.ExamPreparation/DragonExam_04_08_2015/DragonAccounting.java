package ExamPreparation.DragonExam_04_08_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class DragonAccounting {

    private static final double SALARY_RAISE = 1.006;
    private static final int DAYS_IN_MONTH = 30;
    private static final int DAYS_IN_YEAR = 365;

    private static Map<Integer, DayInfo> employeesByDay = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal capital = new BigDecimal(reader.readLine());
        int day = 1;
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            // Parse input
            String[] data = line.split(";");
            long hired = Long.parseLong(data[0]);
            long fired = Long.parseLong(data[1]);
            BigDecimal salary = new BigDecimal(data[2]);
            // Hire employees
            if (hired > 0) {
                employeesByDay.put(day, new DayInfo(hired, salary));
            }
            // Check for raise
            if (employeesByDay.containsKey(day - DAYS_IN_YEAR + 1)) {
                raiseSalaries(day);
            }
            // Give salaries
            if (day % DAYS_IN_MONTH == 0) {
                capital = giveSalaries(capital, day);
            }
            // Fire employees
            fireEmployees(fired);
            // Check for additional income/expense
            capital = processEvents(capital, data);
            // Check for bankruptcy
            if (checkForBankruptcy(capital)) return;
            // Increment counter
            day++;
        }
        long employeesLeft = employeesByDay.values().stream().mapToLong(DayInfo::getHiredCount).sum();
        capital = capital.setScale(4, RoundingMode.DOWN);
        System.out.printf("%d %s%n", employeesLeft, capital);
    }

    private static void raiseSalaries(int day) {
        DayInfo dayInfo = employeesByDay.get(day - DAYS_IN_YEAR + 1);
        BigDecimal increasedSalary = dayInfo.getSalary().multiply(BigDecimal.valueOf(SALARY_RAISE));
        employeesByDay.get(day - DAYS_IN_YEAR + 1).setSalary(increasedSalary);
    }

    private static boolean checkForBankruptcy(BigDecimal capital) {
        if (capital.compareTo(BigDecimal.ZERO) < 0) {
            capital = capital.setScale(4, RoundingMode.DOWN);
            System.out.printf("BANKRUPTCY: %s%n", capital.abs());
            return true;
        }
        return false;
    }

    private static void fireEmployees(long fired) {
        Set<Integer> entriesToRemove = new HashSet<>();
        for (Map.Entry<Integer, DayInfo> pair : employeesByDay.entrySet()) {
            if (pair.getValue().getHiredCount() <= fired) {
                entriesToRemove.add(pair.getKey());
                fired -= pair.getValue().getHiredCount();
                if (fired == 0) {
                    break;
                }
            } else {
                long employeesLeft = pair.getValue().getHiredCount() - fired;
                pair.getValue().setHiredCount(employeesLeft);
                break;
            }
        }
        for (Integer entry : entriesToRemove) {
            employeesByDay.remove(entry);
        }
    }

    private static BigDecimal giveSalaries(BigDecimal capital, int day) {
        for (Map.Entry<Integer, DayInfo> pair : employeesByDay.entrySet()) {
            int dayHired = pair.getKey();
            int workingDays = day - dayHired + 1;
            workingDays = Math.min(DAYS_IN_MONTH, workingDays);

            BigDecimal totalPaid = pair.getValue().getSalary()
                    .divide(BigDecimal.valueOf(DAYS_IN_MONTH), 9, RoundingMode.UP)
                    .setScale(7, RoundingMode.DOWN)
                    .multiply(BigDecimal.valueOf(workingDays))
                    .multiply(BigDecimal.valueOf(pair.getValue().getHiredCount()));

            capital = capital.subtract(totalPaid);
        }
        return capital;
    }

    private static BigDecimal processEvents(BigDecimal capital, String[] data) {
        for (int i = 3; i < data.length; i++) {
            String[] tokens = data[i].split(":");
            String event = tokens[0];
            String amount = tokens[1];
            switch (event) {
                case "Previous years deficit":
                    capital = capital.subtract(new BigDecimal(amount));
                    break;
                case "Machines":
                    capital = capital.subtract(new BigDecimal(amount));
                    break;
                case "Product development":
                    capital = capital.add(new BigDecimal(amount));
                    break;
                case "Taxes":
                    capital = capital.subtract(new BigDecimal(amount));
                    break;
                case "Unconditional funding":
                    capital = capital.add(new BigDecimal(amount));
                    break;
            }
        }
        return capital;
    }

    private static class DayInfo {

        private long hiredCount;
        private BigDecimal salary;

        DayInfo(long hiredCount, BigDecimal salary) {
            this.hiredCount = hiredCount;
            this.salary = salary;
        }

        long getHiredCount() {
            return hiredCount;
        }

        void setHiredCount(long hiredCount) {
            this.hiredCount = hiredCount;
        }

        BigDecimal getSalary() {
            return salary;
        }

        void setSalary(BigDecimal salary) {
            this.salary = salary;
        }
    }
}