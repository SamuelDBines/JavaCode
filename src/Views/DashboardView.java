/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author kacpe
 */
public class DashboardView {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    
    DashboardGaugePanel dashboardGaugePanel = new DashboardGaugePanel(this);
    DashboardInputPanel dashboardInputPanel = new DashboardInputPanel(this);
   
   public DashboardView(){
        frame.setTitle("Aircraft dashboard simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(dashboardGaugePanel.getPanel());
        panel.add(dashboardInputPanel.getPanel());

        frame.setLayout(new FlowLayout());
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
   }

    public JFrame getFrame() {
        return frame;
    }

    public DashboardGaugePanel getDashboardGaugePanel() {
        return dashboardGaugePanel;
    }

    public DashboardInputPanel getDashboardInputPanel() {
        return dashboardInputPanel;
    }

}
