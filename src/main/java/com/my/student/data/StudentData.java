package com.my.student.data;

public class StudentData {

    private Long departmentId;
    private String firstName;
    private String lastName;
    private Long mobileNo;

    private StudentData(Long departmentId, String firstName, String lastName, Long mobileNo) {
        this.departmentId = departmentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
    }

    public static StudentData initData(Long departmentId, String firstName, String lastName, Long mobileNo){
        return  new StudentData(departmentId, firstName, lastName, mobileNo);
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }
}
