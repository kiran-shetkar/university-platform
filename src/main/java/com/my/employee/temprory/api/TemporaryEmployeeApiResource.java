package com.my.employee.temprory.api;

import com.my.employee.data.EmployeeData;
import com.my.employee.temprory.service.TemporaryEmployeeReadPlatformService;
import com.my.employee.temprory.service.TemporaryEmployeeWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("departments/{departmentId}/temporaryemployees")
@RestController
public class TemporaryEmployeeApiResource {

    private final TemporaryEmployeeWritePlatformService temporaryEmployeeWritePlatformService;
    private final TemporaryEmployeeReadPlatformService temporaryEmployeeReadPlatformService;

    @Autowired
    public TemporaryEmployeeApiResource(TemporaryEmployeeWritePlatformService temporaryEmployeeWritePlatformService, TemporaryEmployeeReadPlatformService temporaryEmployeeReadPlatformService) {
        this.temporaryEmployeeWritePlatformService = temporaryEmployeeWritePlatformService;
        this.temporaryEmployeeReadPlatformService = temporaryEmployeeReadPlatformService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Long create(@PathParam("departmentId") final Long departmentId, final String apiRequestJsonData) {
        return this.temporaryEmployeeWritePlatformService.create(departmentId, apiRequestJsonData);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeData retrieveOne(@PathParam("departmentId") Long departmentId, @PathParam("id") final Long id) {
        return this.temporaryEmployeeReadPlatformService.retrieveOne(departmentId, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeData> retrieveAll(@PathParam("departmentId") Long departmentId) {
        return this.temporaryEmployeeReadPlatformService.retrieveAll(departmentId);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Long update(@PathParam("departmentId") final Long departmentId, @PathParam("id") final Long id, final String apiRequestJsonData) {
        return this.temporaryEmployeeWritePlatformService.update(departmentId, id, apiRequestJsonData);
    }

    @DELETE
    @Path("{id}")
    public Long delete(@PathParam("departmentId") final Long departmentId, @PathParam("id") final Long id) {
        return this.temporaryEmployeeWritePlatformService.delete(departmentId, id);
    }

}
