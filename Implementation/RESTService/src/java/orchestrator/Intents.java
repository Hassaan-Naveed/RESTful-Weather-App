/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orchestrator;

import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author hassa
 */
@Path("intents")
public class Intents {
    
    final static Gson gson = new Gson();
    
    static RabbiqMQIntentConsumer consumer = new RabbiqMQIntentConsumer();
    static List<String> allIntents = new ArrayList<>();
    
    
    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of Intents
     * @throws java.lang.Exception
     */
    public Intents() throws Exception {
        consumer.run();
    }
    
    /**
    * Retrieves representation of an instance of orchestrator.TravelDetails
    * @return an instance of java.lang.String
    * @throws java.net.MalformedURLException
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws MalformedURLException {
        String json = "{";
        
        if(!allIntents.isEmpty()) {
            
            for (int i = 0; i < allIntents.size(); i++) {
                String intent = allIntents.get(i);
                if(i == 0) {
                    json += String.format("'%s': %s", i, intent);
                } else {
                    json += String.format(", '%s': %s", i, intent);
                }   
            }
        }
        
        json += "}";
        return json;
    }
    
    
    /**
    * PUT method for updating or creating an instance of Intents
    * @param content representation for the resource
     * @throws java.net.MalformedURLException
    */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) throws MalformedURLException {
        IntentDetails intentDetails = gson.fromJson(content, IntentDetails.class);
        RabbitMQSender.sendTravelIntent(intentDetails);
    }
}
