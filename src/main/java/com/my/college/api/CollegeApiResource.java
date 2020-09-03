package com.my.college.api;

import com.my.college.data.CollegeData;
import com.my.college.service.CollegeReadPlatformService;
import com.my.college.service.CollegeWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("universities/{universityId}/colleges")
@RestController
public class CollegeApiResource {

    private final CollegeWritePlatformService collegeWritePlatformService;
    private final CollegeReadPlatformService collegeReadPlatformService;

    @Autowired
    public CollegeApiResource(final CollegeWritePlatformService collegeWritePlatformService, final CollegeReadPlatformService collegeReadPlatformService) {
        this.collegeWritePlatformService = collegeWritePlatformService;
        this.collegeReadPlatformService = collegeReadPlatformService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Long create(@PathParam("universityId") final Long universityId, final String apiRequestJsonData) {
        return this.collegeWritePlatformService.create(universityId, apiRequestJsonData);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CollegeData retriveOne(@PathParam("id") final Long id) {
        return this.collegeReadPlatformService.retrieveOne(id);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CollegeData> retrieveAll() {
        return this.collegeReadPlatformService.retrieveAll();

    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Long update(@PathParam("id") final Long id, final String apiRequestJsonData) {
        return this.collegeWritePlatformService.update(id, apiRequestJsonData);
    }


    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Long delete(@PathParam("id") final Long id) {
        return this.collegeWritePlatformService.delete(id);
    }

}
