/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientapplication;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hassa
 */
public class TravelDetails {
    String userID;
    String messageID;
    Map<String, String> locationData;
    String date;
    Map<String, String> weatherData;
    
    public TravelDetails(String userID, String messageID, String date, String location, String lat, String lon, String temp, String wind, String rain, String snow, String desc) {
        this.userID = userID;
        this.messageID = messageID;
        this.date = date;
        
        this.locationData = new HashMap<>();
        this.locationData.put("location", location);
        this.locationData.put("latitude", lat);
        this.locationData.put("longitude", lon);
        
        this.weatherData = new HashMap<>();
        this.weatherData.put("tempC", temp);
        this.weatherData.put("windspeedKmh", wind);
        this.weatherData.put("chanceOfRain", rain);
        this.weatherData.put("chanceOfSnow", snow);
        this.weatherData.put("description", desc);
    }
}
