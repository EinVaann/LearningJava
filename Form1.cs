using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Calculator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private void button_Click(Object sender, EventArgs e)
        {
            textBox1.Focus();
            Button b = (Button)sender;
            if (textBox1.Text.Length < 4)
            {               
                textBox1.Text += b.Text;
            }
            
        }
        private void button11_Click(object sender, EventArgs e)
        {
            textBox1.Focus();
            if (textBox1.Text.Length > 0)
            {
                textBox1.Text = textBox1.Text.Remove(textBox1.Text.Length - 1, 1);
                //textBox1.Text = textBox1.Text.Substring(0, textBox1.Text.Length - 1);
            }
        }

        private void button12_Click(object sender, EventArgs e)
        {
            String msg = "";
            if (textBox1.Text.Length < 4) msg = "Restricted";
            else
            if (textBox1.Text == "1830") msg = "Granted";
            else
            {
                msg = "Denied";
            }
            listBox1.Items.Add(DateTime.Now.ToString() + "\t" + msg);
            MessageBox.Show(msg);
            textBox1.Text = "";
            textBox1.Focus();

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            String filename = "102190001.txt";
            if (File.Exists(filename))
            {
                StreamReader s = File.OpenText(filename);
                string str;
                do
                {
                    str = s.ReadLine();
                    if (str != null) listBox1.Items.Add(str);
                } while (str != null);
                s.Close();
            }
            else
            {
                StreamWriter s = File.CreateText(filename);
                s.Close();
            }

        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            StreamWriter s = new StreamWriter("102190001.txt", false);
            foreach (String a in listBox1.Items) s.WriteLine(a);
            s.Close();
        }

        private void textBox1_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyValue >= 48 && e.KeyValue <= 57)
            {
                if (textBox1.Text.Length < 4)
                    textBox1.Text = textBox1.Text + (e.KeyValue - 48).ToString();
            }
            if (e.KeyValue == 8)
            {
                button11_Click(sender, e);
            }
            if (e.KeyValue == 13)
            {
                button12_Click(sender, e);
            }
        }
    }
}
