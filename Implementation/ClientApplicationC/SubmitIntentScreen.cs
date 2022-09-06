using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClientApplicationC
{
    public partial class SubmitIntentScreen : Form
    {

        private List<TravelDetails> travelDetails = new();

        public SubmitIntentScreen()
        {
            InitializeComponent();
        }

        private void submitButton_Click(object sender, EventArgs e)
        {
            string selection = messageIDCombo.SelectedItem.ToString();
            System.Diagnostics.Debug.WriteLine(selection);

            if (!selection.Equals("") & travelDetails.Any())
            {
                for (int i = 0; i < travelDetails.Count; i++)
                {
                    if (travelDetails[i].messageID.Equals(selection))
                    {
                        string messageID = travelDetails[i].messageID;
                        string ownerID = travelDetails[i].userID;
                        string responderID = ClientApplication.userID;

                        string json = string.Format("'userID': '{0}', 'messageID': '{1}', 'responderID': '{2}'", ownerID, messageID, responderID);
                        json = "{" + json + "}";

                        MainGUI.SetIntentDetails(json);
                        Hide();
                    }
                }
            }
        }

        private void cancelButton_Click(object sender, EventArgs e)
        {
            Hide();
        }

        public void FillSelections(List<TravelDetails> travelDetails)
        {
            this.travelDetails = travelDetails;
            messageIDCombo.Items.Clear();

            for (int i = 0; i < travelDetails.Count; i++)
            {
                if (!travelDetails[i].userID.Equals(ClientApplication.userID))
                {
                    messageIDCombo.Items.Add(travelDetails[i].messageID);
                }
            }

        }
    }
}
