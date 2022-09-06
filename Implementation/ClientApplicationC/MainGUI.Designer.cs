namespace ClientApplicationC
{
    partial class MainGUI
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.IDButton = new System.Windows.Forms.Button();
            this.submitProposalButton = new System.Windows.Forms.Button();
            this.queryProposalButton = new System.Windows.Forms.Button();
            this.checkIntentsButton = new System.Windows.Forms.Button();
            this.sendIntentsButton = new System.Windows.Forms.Button();
            this.IDTextBox = new System.Windows.Forms.TextBox();
            this.mainTextBox = new System.Windows.Forms.RichTextBox();
            this.errorLabel = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // IDButton
            // 
            this.IDButton.Location = new System.Drawing.Point(12, 12);
            this.IDButton.Name = "IDButton";
            this.IDButton.Size = new System.Drawing.Size(103, 23);
            this.IDButton.TabIndex = 0;
            this.IDButton.Text = "Generate ID";
            this.IDButton.UseVisualStyleBackColor = true;
            this.IDButton.Click += new System.EventHandler(this.IDButton_Click);
            // 
            // submitProposalButton
            // 
            this.submitProposalButton.Location = new System.Drawing.Point(12, 53);
            this.submitProposalButton.Name = "submitProposalButton";
            this.submitProposalButton.Size = new System.Drawing.Size(103, 23);
            this.submitProposalButton.TabIndex = 1;
            this.submitProposalButton.Text = "Submit Proposal";
            this.submitProposalButton.UseVisualStyleBackColor = true;
            this.submitProposalButton.Click += new System.EventHandler(this.submitProposalButton_Click);
            // 
            // queryProposalButton
            // 
            this.queryProposalButton.Location = new System.Drawing.Point(12, 82);
            this.queryProposalButton.Name = "queryProposalButton";
            this.queryProposalButton.Size = new System.Drawing.Size(103, 23);
            this.queryProposalButton.TabIndex = 2;
            this.queryProposalButton.Text = "Query Proposals";
            this.queryProposalButton.UseVisualStyleBackColor = true;
            this.queryProposalButton.Click += new System.EventHandler(this.queryProposalButton_Click);
            // 
            // checkIntentsButton
            // 
            this.checkIntentsButton.Location = new System.Drawing.Point(121, 53);
            this.checkIntentsButton.Name = "checkIntentsButton";
            this.checkIntentsButton.Size = new System.Drawing.Size(103, 23);
            this.checkIntentsButton.TabIndex = 3;
            this.checkIntentsButton.Text = "Check Intents";
            this.checkIntentsButton.UseVisualStyleBackColor = true;
            this.checkIntentsButton.Click += new System.EventHandler(this.checkIntentsButton_Click);
            // 
            // sendIntentsButton
            // 
            this.sendIntentsButton.Location = new System.Drawing.Point(121, 82);
            this.sendIntentsButton.Name = "sendIntentsButton";
            this.sendIntentsButton.Size = new System.Drawing.Size(103, 23);
            this.sendIntentsButton.TabIndex = 4;
            this.sendIntentsButton.Text = "Send Intent";
            this.sendIntentsButton.UseVisualStyleBackColor = true;
            this.sendIntentsButton.Click += new System.EventHandler(this.sendIntentsButton_Click);
            // 
            // IDTextBox
            // 
            this.IDTextBox.Location = new System.Drawing.Point(121, 12);
            this.IDTextBox.Name = "IDTextBox";
            this.IDTextBox.ReadOnly = true;
            this.IDTextBox.Size = new System.Drawing.Size(103, 23);
            this.IDTextBox.TabIndex = 5;
            // 
            // mainTextBox
            // 
            this.mainTextBox.Location = new System.Drawing.Point(12, 111);
            this.mainTextBox.Name = "mainTextBox";
            this.mainTextBox.ReadOnly = true;
            this.mainTextBox.Size = new System.Drawing.Size(212, 312);
            this.mainTextBox.TabIndex = 6;
            this.mainTextBox.Text = "";
            // 
            // errorLabel
            // 
            this.errorLabel.AutoSize = true;
            this.errorLabel.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.errorLabel.Location = new System.Drawing.Point(12, 426);
            this.errorLabel.Name = "errorLabel";
            this.errorLabel.Size = new System.Drawing.Size(0, 15);
            this.errorLabel.TabIndex = 7;
            // 
            // MainGUI
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(238, 450);
            this.Controls.Add(this.errorLabel);
            this.Controls.Add(this.mainTextBox);
            this.Controls.Add(this.IDTextBox);
            this.Controls.Add(this.sendIntentsButton);
            this.Controls.Add(this.checkIntentsButton);
            this.Controls.Add(this.queryProposalButton);
            this.Controls.Add(this.submitProposalButton);
            this.Controls.Add(this.IDButton);
            this.Name = "MainGUI";
            this.Text = "Client Application";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button IDButton;
        private Button submitProposalButton;
        private Button queryProposalButton;
        private Button checkIntentsButton;
        private Button sendIntentsButton;
        private TextBox IDTextBox;
        private RichTextBox mainTextBox;
        private Label errorLabel;
    }
}