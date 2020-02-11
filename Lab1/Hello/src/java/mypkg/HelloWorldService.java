package mypkg;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author remon
 */
@Path("/hello")
public class HelloWorldService {

    @GET
    public String sayHello(@QueryParam("name") String name) {
        return "Hello there, " + name;
    }

    @GET
    @Path("/{name}")
    public String sayBye(@PathParam("name") String name) {
        return "Goodbye, " + name;
    }
}
