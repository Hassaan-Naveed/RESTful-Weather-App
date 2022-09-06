/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientapplication;

import com.google.gson.Gson;
import java.util.List;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author hassa
 */
public class ClientApplication {
    static MainScreen mainGUI = new MainScreen();
    
    final static String URL = "http://localhost:8080/RESTService/webresources/";
    final static String ID_EXT = "generate-id";
    final static String TRIP_EXT = "trips";
    final static String INT_EXT = "intents";
    
    final static Gson gson = new Gson();
    
    static String userID = "";
    static List<TravelDetails> allTravelDetails = new ArrayList<>();
    static List<IntentDetails> allIntentDetails = new ArrayList<>();
    
    
    public ClientApplication() throws Exception {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mainGUI.setVisible(true);
    }
    
    public static String getJson(URL url){
        try{            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline = "";
                try (Scanner scanner = new Scanner(url.openStream())) {
                    while (scanner.hasNext()) {
                        inline += scanner.nextLine();
                    }
                }
                conn.disconnect();
                return inline;
            }
        } catch (IOException | RuntimeException e) {
            System.out.println("Exception: " + e);
            return null;
        }
    }
    
    public static void postJson(URL url, String query) {
        try{            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.connect();
            
            OutputStream output = conn.getOutputStream();
            output.write(query.getBytes());
            
            conn.getResponseCode();
            conn.disconnect();

        } catch (IOException | RuntimeException e){
            System.out.println("Exception: " + e);
        }
    }
        
    public static String generateID() throws MalformedURLException {
        URL url = new URL(URL+ID_EXT);
        String json = getJson(url);
        
        ID id = gson.fromJson(json, ID.class);
                
        return id.idNumber;
    }
    
    public static void submitProposal(String messageID, String location, String lat, String lon, String date) throws MalformedURLException {
        String locationJson = String.format("{'location': '%s', 'latitude': '%s', 'longitude': '%s'}", location, lat, lon);
        String proposalJson = String.format("{'userID': '%s', 'messageID': '%s', 'locationData': %s, 'date': '%s'}",userID, messageID, locationJson, date);
                        
        URL url = new URL(URL+TRIP_EXT);
        postJson(url, proposalJson);
    }
    
    public static List<TravelDetails> getProposals() throws MalformedURLException {
        URL url = new URL(URL+TRIP_EXT);
        String json = getJson(url);
        
        Map<String, Object> travelDetailsObject =  gson.fromJson(json, Map.class);
        allTravelDetails.clear();
        
        for (int i = 0; i < travelDetailsObject.size(); i++) {
                String userid = ((Map)travelDetailsObject.get(String.valueOf(i))).get("userID").toString();
                String messageid = ((Map)travelDetailsObject.get(String.valueOf(i))).get("messageID").toString();
                String date = ((Map)travelDetailsObject.get(String.valueOf(i))).get("date").toString();
                
                String location = ((Map)((Map)travelDetailsObject.get(String.valueOf(i))).get("locationData")).get("location").toString();
                String lat = ((Map)((Map)travelDetailsObject.get(String.valueOf(i))).get("locationData")).get("latitude").toString();
                String lon = ((Map)((Map)travelDetailsObject.get(String.valueOf(i))).get("locationData")).get("longitude").toString();
                
                String temp = ((Map)((Map)travelDetailsObject.get(String.valueOf(i))).get("weatherData")).get("tempC").toString();
                String wind = ((Map)((Map)travelDetailsObject.get(String.valueOf(i))).get("weatherData")).get("windspeedKmh").toString();
                String rain = ((Map)((Map)travelDetailsObject.get(String.valueOf(i))).get("weatherData")).get("chanceOfRain").toString();
                String snow = ((Map)((Map)travelDetailsObject.get(String.valueOf(i))).get("weatherData")).get("chanceOfSnow").toString();
                String desc = ((Map)((Map)travelDetailsObject.get(String.valueOf(i))).get("weatherData")).get("description").toString();
                                
                TravelDetails travelDetails = new TravelDetails(userid, messageid, date, location, lat, lon, temp, wind, rain, snow, desc);
                allTravelDetails.add(travelDetails);
        }
        
        return allTravelDetails;
    }
    
    public static void sendIntent(String intentJson) throws MalformedURLException {
        URL url = new URL(URL+INT_EXT);
        postJson(url, intentJson);
    }
    
    public static List<IntentDetails> getIntents() throws MalformedURLException {
        URL url = new URL(URL+INT_EXT);
        String json = getJson(url);
        
        Map<String, Object> intentDetailsObject =  gson.fromJson(json, Map.class);
        allIntentDetails.clear();
        
        for (int i = 0; i < intentDetailsObject.size(); i++) {
            String userid = ((Map)intentDetailsObject.get(String.valueOf(i))).get("userID").toString();            
            String messageid = ((Map)intentDetailsObject.get(String.valueOf(i))).get("messageID").toString();            
            String responderid = ((Map)intentDetailsObject.get(String.valueOf(i))).get("responderID").toString();
            System.out.println(responderid);
            
            
            
            IntentDetails intentDetails = new IntentDetails(userid, messageid, responderid);
            allIntentDetails.add(intentDetails);
        }
        
        return allIntentDetails;
    }
}
