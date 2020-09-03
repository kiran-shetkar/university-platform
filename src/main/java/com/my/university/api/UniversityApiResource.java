package com.my.university.api;

import com.my.university.data.UniversityData;
import com.my.university.service.UniversityReadPlatformService;
import com.my.university.service.UniversityWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("universities")
@RestController
public class UniversityApiResource {

    private final UniversityWritePlatformService universityWritePlatformService;
    private final UniversityReadPlatformService universityReadPlatformService;

    @Autowired
    public UniversityApiResource(final UniversityWritePlatformService universityWritePlatformService, final UniversityReadPlatformService universityReadPlatformService) {

        this.universityWritePlatformService = universityWritePlatformService;
        this.universityReadPlatformService = universityReadPlatformService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Long create(final String apiRequestJsonData) {
        return this.universityWritePlatformService.create(apiRequestJsonData);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UniversityData retrieveOne(@PathParam("id") final Long id) {
        return this.universityReadPlatformService.retrieveOne(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UniversityData> retriveAll() {

        return this.universityReadPlatformService.retrieveAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Long update(@PathParam("id") final Long id, final String apiRequestJsonData) {
        return this.universityWritePlatformService.update(id, apiRequestJsonData);
    }

    @DELETE
    @Path("{id}")
    public Long delete(@PathParam("id") final Long id) {
        return this.universityWritePlatformService.delete(id);
    }

}



