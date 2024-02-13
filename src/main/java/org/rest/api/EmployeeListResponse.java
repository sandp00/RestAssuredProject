package org.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EmployeeListResponse {

    @JsonProperty("employee")
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
