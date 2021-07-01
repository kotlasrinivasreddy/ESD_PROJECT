package erp.controller;

import erp.model.ButtonsRequest;
import erp.model.Courses;
import erp.model.StudentOutput;
import erp.services.AdminServicesImpl;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("buttonsdynamically")
//controller goes to this particular part
public class AdminController {

    //CourseService courseService = new CourseService();
    AdminServicesImpl adminService= new AdminServicesImpl();

    @GET
    @Path("/get/domains")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDomains() {
        List<String> domains = adminService.getDomains();
        return Response.ok().entity(domains).build();
    }


    @GET
    @Path("/get/faculty")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFaculty() {
        List<String> departments = adminService.getFaculty();
        return Response.ok().entity(departments).build();
    }

    @GET
    @Path("/get/specialization")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecialization() {
        List<String> spec = adminService.getSpecializations();
        return Response.ok().entity(spec).build();
    }

    @GET
    @Path("/get/years")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getYears()
    {
        List<Integer> years= adminService.getYears();
        return Response.ok().entity(years).build();
    }

    @GET
    @Path("/get/capacity")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCapacity()
    {
        List<Integer> capacity= adminService.getCapacity();
        return Response.ok().entity(capacity).build();
    }

    @POST
    @Path("/get/getCourses")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCourses(ButtonsRequest buttonsRequest)
    {
        List<Courses> courses= adminService.getCourses(buttonsRequest);
        return Response.ok().entity(courses).build();
    }


    // get course names dropdown call
    @POST
    @Path("/get/getCourseNamesDropdown")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCourseNamesDropdown(ButtonsRequest buttonsRequest)
    {
        List<String> course_names= adminService.getCourseNamesDropdown(buttonsRequest);
        return Response.ok().entity(course_names).build();
    }


    //get students based on subject by ordering on subjectgrade and cgpa
    @POST
    @Path("/get/getStudentsByOrdering")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getStudentsByOrdering(ButtonsRequest buttonsRequest)
    {
        List<StudentOutput> course_names= adminService.getStudentsByOrdering(buttonsRequest);
        return Response.ok().entity(course_names).build();
    }

    @POST
    @Path("/get/checkStudentEmail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response checkStudentEmail(ButtonsRequest buttonsRequest)
    {
        List<String> res= adminService.checkStudentEmail(buttonsRequest);
        return Response.ok().entity(res).build();
    }

    @POST
    @Path("/get/checkAdminEmail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response checkAdminEmail(ButtonsRequest buttonsRequest)
    {
        List<String> res= adminService.checkAdminEmail(buttonsRequest);
        return Response.ok().entity(res).build();
    }

}
