package com.my.employee.data;

import com.my.department.data.DepartmentData;

public class EmployeeData {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Long mobileNo;
    private final Long salary;
    private final String dob;
    private final DepartmentData departmentData;

    private EmployeeData(final Long id, final String firstName, final String lastName, final Long mobileNo, final Long salary, final String dob, final DepartmentData departmentData) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.salary = salary;
        this.dob = dob;
        this.departmentData = departmentData;
    }

    public static EmployeeData initData(final Long id, final String firstName, final String lastName, final Long mobileNo, final Long salary, final String dob, final DepartmentData departmentData) {
        return new EmployeeData(id, firstName, lastName, mobileNo, salary, dob, departmentData);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public Long getSalary() {
        return salary;
    }

    public String getDob() {
        return dob;
    }

    public DepartmentData getDepartmentData() {
        return departmentData;
    }
}
