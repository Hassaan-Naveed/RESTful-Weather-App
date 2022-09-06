namespace ClientApplicationC
{
    public partial class MainGUI : Form
    {
        SubmitProposalScreen proposalScreen = new SubmitProposalScreen();
        SubmitIntentScreen intentScreen = new SubmitIntentScreen();

        public MainGUI()
        {
            InitializeComponent();
        }

        private void IDButton_Click(object sender, EventArgs e)
        {
            if (ClientApplication.userID.Equals(""))
            {
                string id = ClientApplication.GenerateID();
                ClientApplication.userID = id;

                IDTextBox.Text = "User ID: " + id;
                errorLabel.Text = string.Empty;
            }
            else
            {
                errorLabel.Text = "Error. ID already generated.";
            }
        }

        private void submitProposalButton_Click(object sender, EventArgs e)
        {
            if (!IDTextBox.Text.Equals(""))
            {
                proposalScreen.Show();
                errorLabel.Text = string.Empty;
            }
            else 
            {
                errorLabel.Text = "Error. Please generate ID first.";
            }
        }

        private void queryProposalButton_Click(object sender, EventArgs e)
        {
            List<TravelDetails> travelDetails = ClientApplication.GetProposals();
            string fullData = "";

            for (int i = 0; i < travelDetails.Count(); i++) 
            { 
                TravelDetails trip = travelDetails[i];

                string data = string.Format(
                    "{0}: " +
                    "\nUser ID: {1}" +
                    "\nMessage ID: {2}" +
                    "\nDate: {3}" +
                    "\nLocation: {4}" +
                    "\nLatitude: {5}" +
                    "\nLongitude: {6}" +
                    "\nTemperature: {7}" +
                    "\nWindspeed: {8} Km/h" +
                    "\nChance of Rain: {9}%" +
                    "\nChance of Snow: {10}%" +
                    "\nDescription: {11}" +
                    "\n\n", i, 
                    trip.userID, 
                    trip.messageID, 
                    trip.date,
                    trip.locationData["location"],
                    trip.locationData["latitude"],
                    trip.locationData["longitude"],
                    trip.weatherData["tempC"],
                    trip.weatherData["windspeedKmh"],
                    trip.weatherData["chanceOfRain"],
                    trip.weatherData["chanceOfSnow"],
                    trip.weatherData["description"]);

                fullData += data;
            }

            mainTextBox.Text = fullData;
            errorLabel.Text = string.Empty;

        }

        private void checkIntentsButton_Click(object sender, EventArgs e)
        {
            List<IntentDetails> intentDetails = ClientApplication.GetIntents();
            string fullData = "";

            for (int i = 0; i < intentDetails.Count(); i++)
            {
                IntentDetails intent = intentDetails[i];

                string data = string.Format(
                    "{0}: " +
                    "\nUser ID: {1}" +
                    "\nMessage ID: {2}" +
                    "\nResponder ID: {3}" +
                    "\n\n", i,
                    intent.userID, 
                    intent.messageID,
                    intent.responderID);

                fullData += data;
            }

            mainTextBox.Text = fullData;
            errorLabel.Text = string.Empty;
        }

        private void sendIntentsButton_Click(object sender, EventArgs e)
        {
            if (!IDTextBox.Text.Equals(""))
            {
                intentScreen.Show();
                intentScreen.FillSelections(ClientApplication.allTravelDetails);
                errorLabel.Text = string.Empty;
            }
            else
            {
                errorLabel.Text = "Error. Please generate ID first.";
            }
        }

        public static void SetProposalDetails(string location, string lat, string lon, string date) 
        {
            string messageID = ClientApplication.GenerateID();
            ClientApplication.SubmitProposal(messageID, location, lat, lon, date);
            
        }

        public static void SetIntentDetails(string json) 
        {
            ClientApplication.SubmitIntent(json);
        }
    }
}