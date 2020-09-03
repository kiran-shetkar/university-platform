package com.my.common.config;

import com.my.college.api.CollegeApiResource;
import com.my.department.api.DepartmentApiResource;
import com.my.employee.api.EmployeeApiResource;
import com.my.student.api.StudentApiResource;
import com.my.employee.temprory.api.TemporaryEmployeeApiResource;
import com.my.university.api.UniversityApiResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/")
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        register(UniversityApiResource.class);
        register(CollegeApiResource.class);
        register(DepartmentApiResource.class);
        register(StudentApiResource.class);
        register(EmployeeApiResource.class);
        register(TemporaryEmployeeApiResource.class);
    }

}
