using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClientApplicationC
{
    public partial class SubmitProposalScreen : Form
    {
        public SubmitProposalScreen()
        {
            InitializeComponent();
        }

        private void submitButton_Click(object sender, EventArgs e)
        {
            string location = locationTextField.Text;
            string lat = latTextField.Text;
            string lon = lonTextField.Text;

            string day = dayTextField.Text;
            string month = monthTextField.Text;
            string year = yearTextField.Text;

            if (!location.Equals("") & !lat.Equals("") & !lon.Equals("") & !day.Equals("") & !month.Equals("") & !year.Equals(""))
            {
                string date = year + "-" + month + "-" + day;
                if (IsValidDate(date))
                {
                    if (IsDateWithinParams(date))
                    {
                        MainGUI.SetProposalDetails(location, lat, lon, date);

                        locationTextField.Text = string.Empty;
                        latTextField.Text = string.Empty;
                        lonTextField.Text = string.Empty;
                        dayTextField.Text = string.Empty;
                        monthTextField.Text = string.Empty;
                        yearTextField.Text = string.Empty;

                        errorLabel.Text = string.Empty;

                        Hide();
                    }
                    else 
                    {
                        errorLabel.Text = "Error, date must be within 14 days!";
                    }
                }
                else
                {
                    errorLabel.Text = "Error, date must be in yyyy-MM-dd format!";
                }
            }
            else 
            {
                errorLabel.Text = "Error, fields must not be empty!";
            }
        }

        private void cancelButton_Click(object sender, EventArgs e)
        {
            locationTextField.Text = string.Empty;
            latTextField.Text = string.Empty;
            lonTextField.Text = string.Empty;
            dayTextField.Text = string.Empty;
            monthTextField.Text = string.Empty;
            yearTextField.Text = string.Empty;

            errorLabel.Text = string.Empty;

            Hide();

        }

        private static Boolean IsValidDate(string date)
        {
            DateTime dtTemp;
            string format = "yyyy-MM-dd";

            if (DateTime.TryParseExact(date, format, DateTimeFormatInfo.InvariantInfo, DateTimeStyles.None, out dtTemp))
            {
                return true;
            }
            else 
            {
                return false;
            }
        }

        private static Boolean IsDateWithinParams(string date)
        {
            DateTime inpDate = DateTime.Parse(date);
            DateTime curDate = DateTime.Now;
            DateTime maxDate = curDate.AddDays(14);

            if (inpDate <= maxDate & inpDate >= curDate)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
    }
}
