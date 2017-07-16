/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.reading.application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Sam
 */
public class ButtonDesign extends JButton {
    
    public ButtonDesign(String title) {
        setText(title);
        setLookAndFeel();
        mouseOverEffect();       
        addListener(title);
    }
    
    
    private void setLookAndFeel() {
        //Prevent focus on buttons : removes unwanted squares
        this.setFocusPainted(false);
        //set button size
        this.setPreferredSize(new Dimension(160, 30));
        //remove borders from buttons
        this.setBorder(null);
        //set background color
        this.setBackground(Color.lightGray);
        //set font size
        this.setFont(new Font("Serif - BOLD", Font.BOLD, 14));
        
    }
    //Changes the state of a button when a mouse hovers over it.
    private void mouseOverEffect() {
        //Listen for mouse events
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {//Mouse enter are
               setBackground(Color.blue);//Set background color
               setForeground(Color.white);//Set text color 
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {//Mouse exit are
               setBackground(Color.lightGray);//Set background color
               setForeground(Color.black);//Set text color
            }
        });
    }

    private void addListener(String title) {
       addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ButtonFactory b = new ButtonFactory(title);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ButtonDesign.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
