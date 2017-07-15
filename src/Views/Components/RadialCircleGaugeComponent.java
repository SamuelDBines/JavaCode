/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Components;

import eu.hansolo.steelseries.tools.BackgroundColor;
import eu.hansolo.steelseries.tools.ColorDef;
import eu.hansolo.steelseries.tools.FrameDesign;
import eu.hansolo.steelseries.tools.LcdColor;
import eu.hansolo.steelseries.tools.LedColor;
import eu.hansolo.steelseries.gauges.Radial;
/**
 *
 * @author kt9517u
 */
public class RadialCircleGaugeComponent extends ViewComponentGauge{
    
    public RadialCircleGaugeComponent(double minValue, double maxValue, String title, String units){
        gauge = new Radial();
        initialSetup(minValue, maxValue, title, units);
    }

    
    @Override
    public void setValueAnimated(double value) {
        ((Radial)gauge).setValueAnimated(value); //Cast to radial to allow animation
    }
    @Override
    public void setLookAndFeel() {
        gauge.setFrameDesign(FrameDesign.TILTED_BLACK);
        gauge.setBackgroundColor(BackgroundColor.BRUSHED_METAL);
        gauge.setLedColor(LedColor.GREEN_LED);
        ((Radial)gauge).setLcdColor(LcdColor.GREEN_LCD);
        gauge.setThreshold(600);
        ((Radial)gauge).setPointerColor(ColorDef.ORANGE);
    }
}
