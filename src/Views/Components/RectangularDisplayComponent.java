/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Components;

import eu.hansolo.steelseries.gauges.DisplayRectangular;
import java.awt.Dimension;

/**
 *
 * @author Sam
 */
public class RectangularDisplayComponent extends ViewComponentGauge {
     public RectangularDisplayComponent(double minValue, double maxValue, String title, String units){  
        gauge = new DisplayRectangular();
        initialSetup(minValue, maxValue, title, units);
    }
     
    @Override 
    public Dimension getPreferredSize() {
        return new Dimension(200, 100);
    }
     
    @Override
    public void setValueAnimated(double value) {
       ((DisplayRectangular)gauge).setValue(value);
    }
    
}
