/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package orchestrator;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hassaan naveed
 */
@Path("trips")
public class Trips {  
    @Context
    private UriInfo context;
    
    final static Gson gson = new Gson();
    final static String WEATHER_API_URL = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=0657231642764c08909220246220301&cc=no&mca=yes&tp=24&format=json&";
    
    static RabbitMQOffersConsumer consumer = new RabbitMQOffersConsumer();
    static List<String> allTravels = new ArrayList<>();
    
    /**
     * Creates a new instance of Trips
     * @throws java.lang.Exception
     */
    public Trips() throws Exception {
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
        
        if(!allTravels.isEmpty()) {
            
            for (int i = 0; i < allTravels.size(); i++) {
                
                String trip = allTravels.get(i);
                
                Map<String, Object> tripObject = new Gson().fromJson(trip, Map.class);
                String tripDate = tripObject.get("date").toString();
                String tripLoc = ((Map)tripObject.get("locationData")).get("location").toString();
                String tripLat = ((Map)tripObject.get("locationData")).get("latitude").toString();
                String tripLon = ((Map)tripObject.get("locationData")).get("longitude").toString();
                
                String weatherJson = getWeatherName(tripLoc, tripDate);
                if (weatherJson == null) {
                   weatherJson = getWeatherCoord(tripLat, tripLon, tripDate);
                }
                
                String fullTrip = trip.substring(0, trip.length() - 1) + ", 'weatherData': " + weatherJson + "}";
                
                if(i == 0) {
                    json += String.format("'%s': %s", i, fullTrip);
                } else {
                    json += String.format(", '%s': %s", i, fullTrip);
                }   
            }
        }
        
        json += "}";
        return json;
    }

    /**
     * PUT method for updating or creating an instance of Trips
     * @param content representation for the resource
     * @throws java.net.MalformedURLException
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) throws MalformedURLException{
        System.out.println(content);
        
        TravelDetails travelDetails = gson.fromJson(content, TravelDetails.class);
        RabbitMQSender.sendTravelExchange(travelDetails);
    }
    
    
    public String getWeatherCoord(String lat, String lon, String date) throws MalformedURLException {
        String extension = String.format("q=%s,%s&date=%s", lat, lon, date);
        URL url = new URL(WEATHER_API_URL + extension);
        
        Map<String, Object> weatherObject;

        try{
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(in);
                String output;
                String json = "";

                while ((output = br.readLine()) != null) {
                    json += output;
                }
                conn.disconnect();
                weatherObject = gson.fromJson(json, Map.class);
            }
        } catch (IOException | RuntimeException e){
            System.out.println("Exception" + e);
            return null;
        }
        
        String temp = ((Map)((List)((Map)((List)((Map) (weatherObject.get("data"))).get("weather")).get(0)).get("hourly")).get(0)).get("tempC").toString();
        String wind = ((Map)((List)((Map)((List)((Map) (weatherObject.get("data"))).get("weather")).get(0)).get("hourly")).get(0)).get("windspeedKmph").toString();
        String rain = ((Map)((List)((Map)((List)((Map) (weatherObject.get("data"))).get("weather")).get(0)).get("hourly")).get(0)).get("chanceofrain").toString();
        String snow = ((Map)((List)((Map)((List)((Map) (weatherObject.get("data"))).get("weather")).get(0)).get("hourly")).get(0)).get("chanceofsnow").toString();
        String desc = ((Map)((List)((Map)((List)((Map)((List)((Map) (weatherObject.get("data"))).get("weather")).get(0)).get("hourly")).get(0)).get("weatherDesc")).get(0)).get("value").toString();
        
        String weatherJson = String.format("{'tempC': '%s', 'windspeedKmh': '%s', 'chanceOfRain': '%s', 'chanceOfSnow': '%s', 'description': '%s'}", temp, wind, rain, snow, desc);
                
        return weatherJson;
    }
    
    public String getWeatherName(String loc, String date) throws MalformedURLException{ 
        String extension = String.format("q=%s&date=%s", loc, date);
        URL url = new URL(WEATHER_API_URL + extension);
                
        Map<String, Object> weatherObject;

        try{
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(in);
                String output;
                String json = "";

                while ((output = br.readLine()) != null) {
                    json += output;
                }
                conn.disconnect();
                weatherObject = gson.fromJson(json, Map.class);
            }
        } catch (IOException | RuntimeException e){
            System.out.println("Exception" + e);
            return null;
        }
        
        String temp = ((Map)((List)((Map)((List)((Map) (weatherObject.get("data"))).get("weather")).get(0)).get("hourly")).get(0)).get("tempC").toString();
        String wind = ((Map)((List)((Map)((List)((Map) (weatherObject.get("data"))).get("weather")).get(0)).get("hourly")).get(0)).get("windspeedKmph").toString();
        String rain = ((Map)((List)((Map)((List)((Map) (weatherObject.get("data"))).get("weather")).get(0)).get("hourly")).get(0)).get("chanceofrain").toString();
        String snow = ((Map)((List)((Map)((List)((Map) (weatherObject.get("data"))).get("weather")).get(0)).get("hourly")).get(0)).get("chanceofsnow").toString();
        String desc = ((Map)((List)((Map)((List)((Map)((List)((Map) (weatherObject.get("data"))).get("weather")).get(0)).get("hourly")).get(0)).get("weatherDesc")).get(0)).get("value").toString();
        
        String weatherJson = String.format("{'tempC': '%s', 'windspeedKmh': '%s', 'chanceOfRain': '%s', 'chanceOfSnow': '%s', 'description': '%s'}", temp, wind, rain, snow, desc);
        
        return weatherJson;
    }
}
