/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author remon
 */
@Path("/emp")
public class EmployeeService {

    private static List<Employee> employees = new ArrayList<>();

    private Employee getEmpById(String id) {

        Employee temp = null;
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                temp = e;
            }
        }
        return temp;
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Employee addEmployee(Employee emp) {
        employees.add(emp);
        return emp;
    }

    @GET
    @Path("/getall")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employee> getEmployees() {
        return employees;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Employee getEmployee(@PathParam("id") String empId) {
        return getEmpById(empId);
    }

    @PUT
    @Path("/up")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateEmployee(Employee updatedEmp) {
        int index = employees.indexOf(getEmpById(updatedEmp.getId()));
        employees.set(index, updatedEmp);
    }

    @Path("/del/{id}")
    @DELETE
    public void delteEmployee(@PathParam("id") String id) {
        employees.remove(getEmpById(id));
    }
}
