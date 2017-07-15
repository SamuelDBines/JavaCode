/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Components;

import eu.hansolo.steelseries.extras.Compass;

/**
 *
 * @author kt9517u
 */
public class CompassGaugeComponent extends ViewComponentGauge {
    
    public CompassGaugeComponent(double minValue, double maxValue, String title, String units){  
        gauge = new Compass();
        initialSetup(minValue, maxValue, title, units);
    }
    
    
    @Override
    public void setValueAnimated(double value) {
        ((Compass)gauge).setValueAnimated(value); //Cast back to linear to changing current value
        
    }
    
}
