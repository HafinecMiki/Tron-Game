/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Adatok extends JFrame implements ActionListener{
	
	GridLayout window;
	JPanel felablak;
	JLabel felir1;
	JTextField fel1;
        JLabel felir2;
	JTextField fel2;
	JPanel jelablak;
	JLabel jelir;
	JTextField jel;
	JPanel gombtarto;
	JButton begomb;
	JButton regisz;
        String[] szinek = {"feher","piros","kek","zold"};
	JComboBox elsoszin=new JComboBox(szinek);
        JComboBox masikszin=new JComboBox(szinek);
        String elsonev = "";
        String masiknev = "";
        
        public void Iras1(String szin){
            try {
                FileWriter fw = new FileWriter("player1.txt");
                fw.write(szin + " " + elsonev);
                fw.close();
            } catch (Exception e) {
                System.out.println("Általános hiba");
            }
        }
        public void Iras2(String szin){
            try {
                FileWriter fw = new FileWriter("player2.txt");
                fw.write(szin + " " + masiknev);
                fw.close();
            } catch (Exception e) {
                System.out.println("Általános hiba");
            }
        }
        
        
        
	public Adatok(){
		setBounds(550,200,175,300);
		setTitle("Belépés");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		//window=new GridLayout(4,1);
		//setLayout(window);
		
		setLayout(new BorderLayout());//itt szurjuk be a képet
	    setContentPane(new JLabel(new ImageIcon("2001.jpg")));
	    setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		
		felir1=new JLabel("Player1 name:    ");
		add(felir1);
		fel1=new JTextField(15);
		add(fel1);
                
                elsoszin.setSelectedIndex(0);
                elsoszin.addActionListener(this);
		add(elsoszin);
		
		felir2=new JLabel("Player2 name:        ");
		add(felir2);
		fel2=new JTextField(15);
		add(fel2);
		
                masikszin.setSelectedIndex(1);
                masikszin.addActionListener(this);
		add(masikszin);
                
                
		//gombtarto=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		//add(gombtarto);
		begomb=new JButton("Játékra fel!");
		add(begomb);
		begomb.addActionListener(this);
		regisz=new JButton("Top-10");
		add(regisz);
		regisz.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
                
            if(e.getSource()==begomb){ 
                Alap obj = new Alap();
                this.dispose();
            }
            if(e.getSource()==regisz){ 
                try {
                    top10 top10 = new top10();
                } catch (SQLException ex) {
                    Logger.getLogger(Adatok.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
                if(e.getSource()==elsoszin){
                    elsonev = fel1.getText();
                    JComboBox cb = (JComboBox)e.getSource();
                    String msg = (String)cb.getSelectedItem();
                    switch(msg){
                                case "feher":Iras1("feher");
                                break;
                                case "piros":Iras1("piros");
                                break;
                                case "kek":Iras1("kek");
                                break;
                                case "zold":Iras1("zold");
                                break;
                                default:Iras1("nem jo");
                            }	
                        }

                        if(e.getSource()==masikszin){
                            masiknev = fel2.getText();
                            JComboBox cb = (JComboBox)e.getSource();
                            String msg = (String)cb.getSelectedItem();
                            switch(msg){
                                case "feher":Iras2("feher");
                                break;
                                case "piros":Iras2("piros");
                                break;
                                case "kek":Iras2("kek");
                                break;
                                case "zold":Iras2("zold");
                                break;
                                default:Iras2("nem jo");
                            }	
                        }

            
            
    }
}
