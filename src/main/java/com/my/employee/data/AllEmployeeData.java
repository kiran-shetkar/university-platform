package com.my.employee.data;

import java.util.List;

public class AllEmployeeData {

    private final List<EmployeeData> permanentEmployees;

    private final List<EmployeeData> temporaryEmployees;

    private AllEmployeeData(List<EmployeeData> permanentEmployees, List<EmployeeData> temporaryEmployees) {
        this.permanentEmployees = permanentEmployees;
        this.temporaryEmployees = temporaryEmployees;
    }

    public static AllEmployeeData initData(List<EmployeeData> permanentEmployees, List<EmployeeData> temporaryEmployees) {
        return new AllEmployeeData(permanentEmployees, temporaryEmployees);
    }

    public List<EmployeeData> getPermanentEmployees() {
        return permanentEmployees;
    }

    public List<EmployeeData> getTemporaryEmployees() {
        return temporaryEmployees;
    }
}
