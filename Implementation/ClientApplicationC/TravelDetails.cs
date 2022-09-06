using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientApplicationC
{
    public class TravelDetails
    {
        public string userID;
        public string messageID;
        public Dictionary<string, string> locationData;
        public string date;
        public Dictionary<string, string> weatherData;

        public TravelDetails(string userID, string messageID, string date, string location, string lat, string lon, string temp, string wind, string rain, string snow, string desc)
        {
            this.userID = userID;
            this.messageID = messageID;
            this.date = date;

            this.locationData = new Dictionary<string, string>();
            this.locationData.Add("location", location);
            this.locationData.Add("latitude", lat);
            this.locationData.Add("longitude", lon);

            this.weatherData = new Dictionary<string, string>();
            this.weatherData.Add("tempC", temp);
            this.weatherData.Add("windspeedKmh", wind);
            this.weatherData.Add("chanceOfRain", rain);
            this.weatherData.Add("chanceOfSnow", snow);
            this.weatherData.Add("description", desc);
        }
    }
}
