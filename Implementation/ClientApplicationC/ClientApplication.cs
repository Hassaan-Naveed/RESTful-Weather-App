using Newtonsoft.Json;
using System.Text;

namespace ClientApplicationC
{
    internal static class ClientApplication
    {
        private const String URL = "http://localhost:8080/RESTService/webresources/";
        private const String ID_EXT = "generate-id";
        private const String TRIP_EXT = "trips";
        private const String INT_EXT = "intents";

        public static String userID = "";

        public static List<TravelDetails> allTravelDetails = new();
        public static List<IntentDetails> allIntentDetails = new();


        static void Main()
        {
            // To customize application configuration such as set high DPI settings or default font,
            // see https://aka.ms/applicationconfiguration.
            ApplicationConfiguration.Initialize();

            Application.Run(new MainGUI());
        }

        private static async Task<string> GetJson(string url) 
        {

            using (var client = new HttpClient()) 
            { 
                client.BaseAddress = new Uri(url);
                HttpResponseMessage response = await client.GetAsync(url);

                if (response.IsSuccessStatusCode)
                {
                    string result = await response.Content.ReadAsStringAsync();
                    return result;
                }
                else 
                { 
                    return null;
                }
            }
        }


        private static async Task PostJson(string url, string json) 
        {
            using (var client = new HttpClient())
            {
                HttpResponseMessage response = await client.GetAsync(url);

                if (response.IsSuccessStatusCode)
                {
                    var content = new StringContent(json, Encoding.UTF8, "application/json");
                    await client.PutAsync(url, content);

                    var result = await response.Content.ReadAsStringAsync();
                }
            }
        }

        public static String GenerateID() 
        {
            string url = URL + ID_EXT;
            var result = Task.Run(() => GetJson(url));
            result.Wait();

            string json = result.Result;
            ID id = JsonConvert.DeserializeObject<ID>(json);
           
            return id.idNumber;
        }

        public static void SubmitProposal(String messageID, String location, String lat, String lon, String date) 
        {
            string locationJson = string.Format("'location': '{0}', 'latitude': '{1}', 'longitude': '{2}'", location, lat, lon);
            locationJson = "{" + locationJson + "}";

            string proposalJson = string.Format("'userID': '{0}', 'messageID': '{1}', 'locationData': {2}, 'date': '{3}'", userID, messageID, locationJson, date);
            proposalJson = "{" + proposalJson + "}";

            string url = URL + TRIP_EXT;
            var result = Task.Run(() => PostJson(url, proposalJson));
            result.Wait();
        }

        public static List<TravelDetails> GetProposals() 
        {
            string url = URL + TRIP_EXT;
            var result = Task.Run(() => GetJson(url));
            result.Wait();

            string json = result.Result;
            Dictionary<string, TravelDetails> travelDetailsObject = JsonConvert.DeserializeObject<Dictionary<string, TravelDetails>>(json);

            allTravelDetails.Clear();

            for (int i = 0; i < travelDetailsObject.Count(); i++) 
            {
                allTravelDetails.Add(travelDetailsObject[i.ToString()]);
            }

            return allTravelDetails;
        }

        public static void SubmitIntent(String json) 
        {
            string url = URL + INT_EXT;
            PostJson(url, json);
        }

        public static List<IntentDetails> GetIntents() 
        {
            string url = URL + INT_EXT;
            var result = Task.Run(() => GetJson(url));
            result.Wait();

            string json = result.Result;
            Dictionary<string, IntentDetails> intentDetailsObject = JsonConvert.DeserializeObject<Dictionary<string, IntentDetails>>(json);

            allIntentDetails.Clear();

            for (int i = 0; i < intentDetailsObject.Count(); i++)
            {
                allIntentDetails.Add(intentDetailsObject[i.ToString()]);
            }

            return allIntentDetails;
        }
    }
}