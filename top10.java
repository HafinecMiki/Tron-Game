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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class top10 extends JFrame implements ActionListener{
	
        JLabel Cim;
	
	JLabel jbl_kiiras1;
	JLabel jbl_kiiras2;
        JLabel jbl_kiiras3;
        
        JLabel jb2_kiiras1;
	JLabel jb2_kiiras2;
        JLabel jb2_kiiras3;
        
        JLabel jb3_kiiras1;
	JLabel jb3_kiiras2;
        JLabel jb3_kiiras3;
        
        JLabel jb4_kiiras1;
	JLabel jb4_kiiras2;
        JLabel jb4_kiiras3;
        
        JLabel jb5_kiiras1;
	JLabel jb5_kiiras2;
        JLabel jb5_kiiras3;
        
        JLabel jb6_kiiras1;
	JLabel jb6_kiiras2;
        JLabel jb6_kiiras3;
        
        JLabel jb7_kiiras1;
	JLabel jb7_kiiras2;
        JLabel jb7_kiiras3;
        
        JLabel jb8_kiiras1;
	JLabel jb8_kiiras2;
        JLabel jb8_kiiras3;
        
        JLabel jb9_kiiras1;
	JLabel jb9_kiiras2;
        JLabel jb9_kiiras3;
        
        JLabel jb10_kiiras1;
	JLabel jb10_kiiras2;
        JLabel jb10_kiiras3;
        
        JButton menu;
	
	public top10() throws SQLException{
		setTitle("CÍM");//keret cím
		setBounds(100, 100, 145, 390);//méretezés
		setDefaultCloseOperation(EXIT_ON_CLOSE);//a piros x re kattintva bezárja az ablakot
		GridLayout gl_ablak=new GridLayout(1,1);//4 sor 1 oszlop
		setLayout(gl_ablak);//elrendezés beállítása
		//A GridLayouthoz sorba kell megadni a paramétereket
		
                Connection conn =
		  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tron2","root","");
		  Statement stat=(Statement) conn.createStatement();
		  ResultSet res=stat.executeQuery("Select * FROM motor");
		  
                 
		String [] Sorok = new String[1000];
                int [] szamok = new int[1000];
                for(int j = 0; j < 1000; j++){
                    Sorok[j] = "";
                    szamok[j] = 0;
                }
                int i = 0;
                while(res.next()){
                        Sorok[i] = res.getString("Nev");
                        szamok[i] = Integer.parseInt(res.getString("Score"));
                        i++;
                }
                
                for(int j = 0;j < i-1; j++){
                    for (int k = j+1; k < i; k++){
                        if(szamok[j] < szamok[k]){
                            int csere = szamok[j];
                            String csere1 = Sorok[j];
                            szamok[j] = szamok[k];
                            Sorok[j] = Sorok[k];
                            szamok[k] = csere;
                            Sorok[k] = csere1;
                            
                        }
                    }
                }
                
                
		JPanel jpnl_kiir1=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));//létrehozza a vezérlőket összefogó panelt
		add(jpnl_kiir1);//Az ablak elrenezésvezérlőjének első helyére beteszem a panelt
                Cim=new JLabel("      TOP-10     ");
                jpnl_kiir1.add(Cim);//hozzáadom a panelhez
		jbl_kiiras1=new JLabel("1.           ");//létrehozza a címfeliratot
                jbl_kiiras2=new JLabel(Sorok[0]);
                jbl_kiiras3=new JLabel(String.valueOf(szamok[0]));
                jpnl_kiir1.add(jbl_kiiras1);//hozzáadom a panelhez
                jpnl_kiir1.add(jbl_kiiras2);//hozzáadom a panelhez         
                jpnl_kiir1.add(jbl_kiiras3);//hozzáadom a panelhez    
                
		
		jb2_kiiras1=new JLabel("2.           ");//létrehozza a címfeliratot
                jb2_kiiras2=new JLabel(Sorok[1]);
                jb2_kiiras3=new JLabel(String.valueOf(szamok[1]));
                jpnl_kiir1.add(jb2_kiiras1);//hozzáadom a panelhez
                jpnl_kiir1.add(jb2_kiiras2);//hozzáadom a panelhez         
                jpnl_kiir1.add(jb2_kiiras3);//hozzáadom a panelhez
		
		
		jb3_kiiras1=new JLabel("3.           ");//létrehozza a címfeliratot
                jb3_kiiras2=new JLabel(Sorok[2]);
                jb3_kiiras3=new JLabel(String.valueOf(szamok[2]));
                jpnl_kiir1.add(jb3_kiiras1);//hozzáadom a panelhez
                jpnl_kiir1.add(jb3_kiiras2);//hozzáadom a panelhez         
                jpnl_kiir1.add(jb3_kiiras3);//hozzáadom a panelhez
                
                
		jb4_kiiras1=new JLabel("4.           ");//létrehozza a címfeliratot
                jb4_kiiras2=new JLabel(Sorok[3]);
                jb4_kiiras3=new JLabel(String.valueOf(szamok[3]));
                jpnl_kiir1.add(jb4_kiiras1);//hozzáadom a panelhez
                jpnl_kiir1.add(jb4_kiiras2);//hozzáadom a panelhez         
                jpnl_kiir1.add(jb4_kiiras3);//hozzáadom a panelhez
                
                
		jb5_kiiras1=new JLabel("5.           ");//létrehozza a címfeliratot
                jb5_kiiras2=new JLabel(Sorok[4]);
                jb5_kiiras3=new JLabel(String.valueOf(szamok[4]));
                jpnl_kiir1.add(jb5_kiiras1);//hozzáadom a panelhez
                jpnl_kiir1.add(jb5_kiiras2);//hozzáadom a panelhez         
                jpnl_kiir1.add(jb5_kiiras3);//hozzáadom a panelhez
                
                
		jb6_kiiras1=new JLabel("6.           ");//létrehozza a címfeliratot
                jb6_kiiras2=new JLabel(Sorok[5]);
                jb6_kiiras3=new JLabel(String.valueOf(szamok[5]));
                jpnl_kiir1.add(jb6_kiiras1);//hozzáadom a panelhez
                jpnl_kiir1.add(jb6_kiiras2);//hozzáadom a panelhez         
                jpnl_kiir1.add(jb6_kiiras3);//hozzáadom a panelhez
                
                
		jb7_kiiras1=new JLabel("7.           ");//létrehozza a címfeliratot
                jb7_kiiras2=new JLabel(Sorok[6]);
                jb7_kiiras3=new JLabel(String.valueOf(szamok[6]));
                jpnl_kiir1.add(jb7_kiiras1);//hozzáadom a panelhez
                jpnl_kiir1.add(jb7_kiiras2);//hozzáadom a panelhez         
                jpnl_kiir1.add(jb7_kiiras3);//hozzáadom a panelhez
		
                
                
		jb8_kiiras1=new JLabel("8.           ");//létrehozza a címfeliratot
                jb8_kiiras2=new JLabel(Sorok[7]);
                jb8_kiiras3=new JLabel(String.valueOf(szamok[7]));
                jpnl_kiir1.add(jb8_kiiras1);//hozzáadom a panelhez
                jpnl_kiir1.add(jb8_kiiras2);//hozzáadom a panelhez         
                jpnl_kiir1.add(jb8_kiiras3);//hozzáadom a panelhez
		
                
		jb9_kiiras1=new JLabel("9.           ");//létrehozza a címfeliratot
                jb9_kiiras2=new JLabel(Sorok[8]);
                jb9_kiiras3=new JLabel(String.valueOf(szamok[8]));
                jpnl_kiir1.add(jb9_kiiras1);//hozzáadom a panelhez
                jpnl_kiir1.add(jb9_kiiras2);//hozzáadom a panelhez         
                jpnl_kiir1.add(jb9_kiiras3);//hozzáadom a panelhez
                
               
		jb10_kiiras1=new JLabel("10.          ");//létrehozza a címfeliratot
                jb10_kiiras2=new JLabel(Sorok[9]);
                jb10_kiiras3=new JLabel(String.valueOf(szamok[9]));
                jpnl_kiir1.add(jb10_kiiras1);//hozzáadom a panelhez
                jpnl_kiir1.add(jb10_kiiras2);//hozzáadom a panelhez         
                jpnl_kiir1.add(jb10_kiiras3);//hozzáadom a panelhez
                
                menu=new JButton("Menü");
		jpnl_kiir1.add(menu);
		menu.addActionListener(this);
                
		setVisible(true);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        
            if(e.getSource()==menu){ 
                Adatok obj = new Adatok();
                this.dispose();
            }
    
    }

	
    }
