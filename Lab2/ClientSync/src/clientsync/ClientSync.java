/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsync;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author remon
 */
public class ClientSync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Client client = Client.create();

        String url = "http://localhost:8084/Employee/emp/";

        WebResource webResource = client.resource(url);

        WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);

        ClientResponse response = builder.get(ClientResponse.class);
        
        if(response.getStatus() != 200) {
            throw new RuntimeException("HTTP Error" + response.getStatus());
        }
        
        Employee employee = response.getEntity(Employee.class);

    }

}
