/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientasync;

import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.async.TypeListener;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.client.non.blocking.NonBlockingClient;
import com.sun.jersey.client.non.blocking.config.DefaultNonBlockingClientConfig;
import com.sun.jersey.client.non.blocking.config.NonBlockingClientConfig;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author remon
 */
public class ClientAsync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClientConfig cc = new DefaultNonBlockingClientConfig();

        cc.getProperties().put(NonBlockingClientConfig.PROPERTY_THREADPOOL_SIZE, 10);
        Client c = NonBlockingClient.create(cc);

        String url = "http://localhost:8084/Employee/emp/";

        AsyncWebResource awr = c.asyncResource(url);

        AsyncWebResource.Builder awr2 = awr.accept(MediaType.APPLICATION_JSON);

        awr2.get(new TypeListener<ClientResponse>(ClientResponse.class) {
            @Override
            public void onComplete(Future<ClientResponse> future) throws InterruptedException {
                try {
                    ClientResponse response = future.get();
                    if (response.getStatus() != 200) {
                        throw new RuntimeException("HTTP Error " + response.getStatus());
                    }

                    List<Employee> employees = response.getEntity(new GenericType<List<Employee>>() {

                    });
                    System.out.println("Response from the server: ");
                    employees.forEach((employee -> {
                        System.err.println(employee);
                    }));
                } catch (ExecutionException ex) {
                    Logger.getLogger(ClientAsync.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

}
