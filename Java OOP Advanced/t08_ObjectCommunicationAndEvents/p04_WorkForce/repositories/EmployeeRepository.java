package t08_ObjectCommunicationAndEvents.p04_WorkForce.repositories;

import t08_ObjectCommunicationAndEvents.p04_WorkForce.model.employees.BaseEmployee;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmployeeRepository {

    private Map<String, BaseEmployee> employees;

    public EmployeeRepository() {
        this.employees = new LinkedHashMap<>();
    }

    public void addEmployee(BaseEmployee employee){
        this.employees.put(employee.getName(), employee);
    }

    public BaseEmployee getEmployee(String name){
        return this.employees.get(name);
    }
}
