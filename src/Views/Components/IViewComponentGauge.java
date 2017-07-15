/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Components;

import eu.hansolo.steelseries.gauges.AbstractGauge;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author kt9517u
 */
public interface IViewComponentGauge {
    
    public AbstractGauge getGauge();
    
    public void addInputValueListener(ActionListener listenForButtonPress);

    public JPanel getInputPanel();
    
    public double getInputValue();
        
    public void setMaxValue(double value);
    
    public double getMaxValue();
    
    public void setMinValue(double value);
    
    public double getMinValue();
    
    public void setTitle(String title);
    
    public String getTitle();
    
    public void setUnitString(String unit);
    
    public String getUnitString();
    
    public void setValueAnimated(double value);
    
    public void toggleInputPanel(); //Enabled, disabled
            
    
}
