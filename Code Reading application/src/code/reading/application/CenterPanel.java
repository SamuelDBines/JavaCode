/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.reading.application;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Sam
 */
public class CenterPanel extends JPanel {
    private static CenterPanel singleton = new CenterPanel ();
    private CenterPanel() {
        setLayout(new CardLayout());
    }
    public static CenterPanel getInstance() {
        return singleton;
    }
    public static void addView(View view, String title) {
        singleton.add(view,title);
         CardLayout cardLayout = (CardLayout) singleton.getLayout();
        cardLayout.show(singleton, title);
    }
}
