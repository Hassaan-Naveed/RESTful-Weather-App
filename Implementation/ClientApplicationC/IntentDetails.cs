using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientApplicationC
{
    public class IntentDetails
    {
        public string userID;
        public string messageID;
        public string responderID;

        public IntentDetails(string userID, string messageID, string responderID)
        {
            this.userID = userID;
            this.messageID = messageID;
            this.responderID = responderID;
        }
    }
}
