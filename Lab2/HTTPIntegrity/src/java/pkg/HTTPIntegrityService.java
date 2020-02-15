/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author remon
 */
public class HTTPIntegrityService {

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Employee addEmployee(Employee emp, @Context HttpServletRequest request) {
        request.getSession().setAttribute("name", "Remon");
        System.out.println(request.getSession().getId());
        return emp;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Employee> getEmployees(@Context UriInfo ui, @Context HttpHeaders hh, @Context HttpServletRequest request) {
        List<Employee> listOfEmps = Employee.getAllEmployees();
        return listOfEmps;
    }
}
