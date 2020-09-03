package com.my.student.api;

import com.my.student.data.StudentData;
import com.my.student.service.StudentReadPlatformService;
import com.my.student.service.StudentWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("departments/{departmentId}/students")
@RestController
public class StudentApiResource {

    private final StudentWritePlatformService studentWritePlatformService;
    private final StudentReadPlatformService studentReadPlatformService;

    @Autowired
    public StudentApiResource(final StudentWritePlatformService studentWritePlatformService, final StudentReadPlatformService studentReadPlatformService) {
        this.studentWritePlatformService = studentWritePlatformService;
        this.studentReadPlatformService = studentReadPlatformService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Long create(@PathParam("departmentId") final Long departmentId, final String apiRequestJsonData) {
        return studentWritePlatformService.create(departmentId, apiRequestJsonData);

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentData retrieveOne(@PathParam("id") final Long id) {
        return this.studentReadPlatformService.retrieveOne(id);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentData> retrieveAll() {
        return this.studentReadPlatformService.retrieveAll();

    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Long update(@PathParam("id") final Long id, final String apiRequestJsonData) {
        return this.studentWritePlatformService.update(id, apiRequestJsonData);
    }


    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Long delete(@PathParam("id") final Long id) {
        return this.studentWritePlatformService.delete(id);
    }

}
