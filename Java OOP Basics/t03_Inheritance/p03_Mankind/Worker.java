package t03_Inheritance.p03_Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double getSalaryPerHour() {
        return this.weekSalary / (this.workHoursPerDay * 7.0);
    }

    @Override
    public String toString() {
        return String.format
                ("First Name: %s%nLast Name: %s%nWeek Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f"
                        , super.getFirstName(), super.getLastName(), this.weekSalary
                        , this.workHoursPerDay, this.getSalaryPerHour());
    }
}
