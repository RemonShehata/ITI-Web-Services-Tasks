/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 *
 * @author remon
 */
@Path("/calc")
public class Calculator {

//    @GET
//    @Path("/sum")
//    public String add(@QueryParam("first") int first, @QueryParam("second") int second) {
//        int res = first + second;
//        return "" + res;
//    }
//
//    @GET
//    @Path("/sub")
//    public String sub(@QueryParam("first") int first, @QueryParam("second") int second) {
//        int res = first - second;
//        return "" + res;
//    }
//
//    @GET
//    @Path("/mul")
//    public String mul(@QueryParam("first") int a, @QueryParam("second") int b) {
//        return "" + a * b;
//    }
//
//    @GET
//    @Path("/div")
//    public String div(@QueryParam("first") int a, @QueryParam("second") int b) {
//        return "" + a / b;
//    }

    @GET
    @Path("/{op}")
    public String doOp(@PathParam("op") String op, @QueryParam("first") int first, @QueryParam("second") int second) {
        int res = 0;
        switch (op) {
            case "sum":
                res = first + second;
                break;
            case "sub":
                res = first - second;
                break;
            case "mul":
                res = first * second;
                break;
            case "div":
                res = first / second;
                break;
        }
        return "" + res;
    }
}
