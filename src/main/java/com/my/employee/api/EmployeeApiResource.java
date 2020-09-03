package com.my.employee.api;

import com.my.employee.data.AllEmployeeData;
import com.my.employee.data.EmployeeData;
import com.my.employee.service.EmployeeReadPlatformService;
import com.my.employee.service.EmployeeWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("departments/{departmentId}/employees")
@RestController
public class EmployeeApiResource {

    private final EmployeeWritePlatformService employeeWritePlatformService;
    private final EmployeeReadPlatformService employeeReadPlatformService;

    @Autowired
    public EmployeeApiResource(EmployeeWritePlatformService employeeWritePlatformService, EmployeeReadPlatformService employeeReadPlatformService) {
        this.employeeWritePlatformService = employeeWritePlatformService;
        this.employeeReadPlatformService = employeeReadPlatformService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Long create(@PathParam("departmentId") Long departmentId, final String apiRequestJsonData) {
        return this.employeeWritePlatformService.create(departmentId, apiRequestJsonData);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeData retrieveOne(@PathParam("id") final Long id) {
        return this.employeeReadPlatformService.retrieveOne(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AllEmployeeData retrieveAll(@PathParam("departmentId") Long departmentId){
        return this.employeeReadPlatformService.retrieveAll(departmentId);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Long update(@PathParam("departmentId") Long departmentId, @PathParam("id") final Long id, final String apiRequestJsonData){
        return this.employeeWritePlatformService.update(departmentId, id, apiRequestJsonData);
    }

    @DELETE
    @Path("{id}")
    public Long delete(@PathParam("departmentId") Long departmentId, @PathParam("id") final Long id){
        return this.employeeWritePlatformService.delete(departmentId, id);
    }

}
