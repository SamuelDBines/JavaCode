/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.reading.application;

import javax.swing.JPanel;

/**
 *
 * @author Sam
 */
public class NavigationBar extends JPanel {
    String[] bNames = {"TestView", "FrameDesign", "Whatsup"};
    public NavigationBar() {
        for(String name : bNames  ) {
            add(new ButtonDesign(name));
        }
    }
}
