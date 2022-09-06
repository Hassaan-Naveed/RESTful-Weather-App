namespace ClientApplicationC
{
    partial class SubmitProposalScreen
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.locationTextField = new System.Windows.Forms.TextBox();
            this.latTextField = new System.Windows.Forms.TextBox();
            this.lonTextField = new System.Windows.Forms.TextBox();
            this.dayTextField = new System.Windows.Forms.TextBox();
            this.monthTextField = new System.Windows.Forms.TextBox();
            this.yearTextField = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.submitButton = new System.Windows.Forms.Button();
            this.cancelButton = new System.Windows.Forms.Button();
            this.label7 = new System.Windows.Forms.Label();
            this.errorLabel = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // locationTextField
            // 
            this.locationTextField.Location = new System.Drawing.Point(12, 27);
            this.locationTextField.Name = "locationTextField";
            this.locationTextField.Size = new System.Drawing.Size(312, 23);
            this.locationTextField.TabIndex = 0;
            // 
            // latTextField
            // 
            this.latTextField.Location = new System.Drawing.Point(12, 87);
            this.latTextField.Name = "latTextField";
            this.latTextField.Size = new System.Drawing.Size(156, 23);
            this.latTextField.TabIndex = 1;
            // 
            // lonTextField
            // 
            this.lonTextField.Location = new System.Drawing.Point(174, 87);
            this.lonTextField.Name = "lonTextField";
            this.lonTextField.Size = new System.Drawing.Size(150, 23);
            this.lonTextField.TabIndex = 2;
            // 
            // dayTextField
            // 
            this.dayTextField.Location = new System.Drawing.Point(12, 146);
            this.dayTextField.Name = "dayTextField";
            this.dayTextField.Size = new System.Drawing.Size(100, 23);
            this.dayTextField.TabIndex = 3;
            // 
            // monthTextField
            // 
            this.monthTextField.Location = new System.Drawing.Point(118, 146);
            this.monthTextField.Name = "monthTextField";
            this.monthTextField.Size = new System.Drawing.Size(100, 23);
            this.monthTextField.TabIndex = 4;
            // 
            // yearTextField
            // 
            this.yearTextField.Location = new System.Drawing.Point(224, 146);
            this.yearTextField.Name = "yearTextField";
            this.yearTextField.Size = new System.Drawing.Size(100, 23);
            this.yearTextField.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 15);
            this.label1.TabIndex = 6;
            this.label1.Text = "Location";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 69);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(50, 15);
            this.label2.TabIndex = 7;
            this.label2.Text = "Latitude";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(174, 69);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(61, 15);
            this.label3.TabIndex = 8;
            this.label3.Text = "Longitude";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(12, 128);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(54, 15);
            this.label4.TabIndex = 9;
            this.label4.Text = "Day (DD)";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(118, 128);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(76, 15);
            this.label5.TabIndex = 10;
            this.label5.Text = "Month (MM)";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(227, 128);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(68, 15);
            this.label6.TabIndex = 11;
            this.label6.Text = "Year (YYYY)";
            // 
            // submitButton
            // 
            this.submitButton.Location = new System.Drawing.Point(79, 188);
            this.submitButton.Name = "submitButton";
            this.submitButton.Size = new System.Drawing.Size(75, 23);
            this.submitButton.TabIndex = 12;
            this.submitButton.Text = "Submit";
            this.submitButton.UseVisualStyleBackColor = true;
            this.submitButton.Click += new System.EventHandler(this.submitButton_Click);
            // 
            // cancelButton
            // 
            this.cancelButton.Location = new System.Drawing.Point(174, 188);
            this.cancelButton.Name = "cancelButton";
            this.cancelButton.Size = new System.Drawing.Size(75, 23);
            this.cancelButton.TabIndex = 13;
            this.cancelButton.Text = "Cancel";
            this.cancelButton.UseVisualStyleBackColor = true;
            this.cancelButton.Click += new System.EventHandler(this.cancelButton_Click);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.label7.Location = new System.Drawing.Point(12, 231);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(0, 15);
            this.label7.TabIndex = 14;
            // 
            // errorLabel
            // 
            this.errorLabel.AutoSize = true;
            this.errorLabel.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.errorLabel.Location = new System.Drawing.Point(12, 231);
            this.errorLabel.Name = "errorLabel";
            this.errorLabel.Size = new System.Drawing.Size(0, 15);
            this.errorLabel.TabIndex = 15;
            // 
            // SubmitProposalScreen
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(335, 255);
            this.Controls.Add(this.errorLabel);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.cancelButton);
            this.Controls.Add(this.submitButton);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.yearTextField);
            this.Controls.Add(this.monthTextField);
            this.Controls.Add(this.dayTextField);
            this.Controls.Add(this.lonTextField);
            this.Controls.Add(this.latTextField);
            this.Controls.Add(this.locationTextField);
            this.Name = "SubmitProposalScreen";
            this.Text = "SubmitProposalScreen";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private TextBox locationTextField;
        private TextBox latTextField;
        private TextBox lonTextField;
        private TextBox dayTextField;
        private TextBox monthTextField;
        private TextBox yearTextField;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private Button submitButton;
        private Button cancelButton;
        private Label label7;
        private Label errorLabel;
    }
}