/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Hafi
 */

import tron.Gameplay;

public class Alap {
    
    public Alap(){
        JFrame obj = new JFrame();
        Gameplay gameplay = new Gameplay();
        obj.setTitle("Tron");
        obj.setBounds(100,10,900,700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
        
    }
        
}
