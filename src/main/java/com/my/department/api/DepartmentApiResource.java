package com.my.department.api;

import com.my.department.data.DepartmentData;
import com.my.department.service.DepartmentReadPlatformService;
import com.my.department.service.DepartmentWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("colleges/{collegeId}/departments")
@RestController
public class DepartmentApiResource {

    private final DepartmentWritePlatformService departmentWritePlatformService;
    private final DepartmentReadPlatformService departmentReadPlatformService;

    @Autowired
    public DepartmentApiResource(final DepartmentWritePlatformService departmentWritePlatformService, final DepartmentReadPlatformService departmentReadPlatformService) {
        this.departmentWritePlatformService = departmentWritePlatformService;
        this.departmentReadPlatformService = departmentReadPlatformService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Long create(@PathParam("collegeId") final Long collegeId, final String apiRequestJsonData) {
        return departmentWritePlatformService.create(collegeId, apiRequestJsonData);

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DepartmentData retrieveOne(@PathParam("id") final Long id) {
        return this.departmentReadPlatformService.retrieveOne(id);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DepartmentData> retrieveAll() {
        return this.departmentReadPlatformService.retrieveAll();

    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Long update(@PathParam("id") final Long id, final String apiRequestJsonData) {
        return this.departmentWritePlatformService.update(id, apiRequestJsonData);
    }


    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Long delete(@PathParam("id") final Long id) {
        return this.departmentWritePlatformService.delete(id);
    }

}
