/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orchestrator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hassa
 */

@Path("generate-id")
public class GenerateID {
    @Context
    private UriInfo context;
    
    final URL url = new URL("https://www.random.org/integers/?num=1&min=0&max=9999&col=1&base=10&format=plain&rnd=new");

    /**
     * Creates a new instance of GenerateID
     * @throws java.lang.Exception
     */
    public GenerateID() throws Exception {
    }
    
    /**
     * Retrieves representation of an instance of orchestrator.GenerateID
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        try{
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/plain");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(in);
                String output;
                String id = "";

                while ((output = br.readLine()) != null) {
                    id += output;
                }
                conn.disconnect();
                String json = "{'idNumber': '" + id + "'}";
                return json;
            }
        } catch (IOException | RuntimeException e){
            System.out.println("Exception");
            return null;
        }    
    }
}
