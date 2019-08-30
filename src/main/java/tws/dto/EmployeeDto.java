package tws.dto;

import tws.entity.Employee;

import java.io.Serializable;

public class EmployeeDto implements Serializable {

    private Employee employee;

    private String description;

    public EmployeeDto() {
    }

    public EmployeeDto(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDto(Employee employee, String description) {
        this.employee = employee;
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
