/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Components;

import eu.hansolo.steelseries.extras.Clock;
import java.awt.Dimension;

/**
 *
 * @author sb3051d
 */
public class AutomaticClockComponent extends ViewComponentGauge {
    
    public AutomaticClockComponent(double minValue, double maxValue, String title, String units){  
        gauge = new Clock();
        initialSetup(minValue, maxValue, title, units);
    }
    
    @Override 
    public Dimension getPreferredSize() {
        return new Dimension(150, 300);
    }
    
    @Override
    public void setValueAnimated(double value) {
        ((Clock)gauge).setValueAnimated(value); //Cast back to linear to changing current value
        
    }
}
