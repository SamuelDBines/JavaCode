/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Components;


import Helpers.GamePattern;
import eu.hansolo.steelseries.extras.Poi;
import eu.hansolo.steelseries.extras.Radar;
import eu.hansolo.steelseries.tools.FrameDesign;
import java.awt.Color;

/**
 *
 * @author Sam
 */
public class RadarGaugeComponent extends ViewComponentGauge{
    public static GamePattern game;
    public RadarGaugeComponent(double minValue, double maxValue, String title, String units){
        gauge = new Radar();
        initialSetup(minValue, maxValue, title, units);
        ((Radar)gauge).setMyLocation(5, 5);
        ((Radar)gauge).setRange(20000);
        ((Radar)gauge).animate(true);
        game = new GamePattern(gauge);
    }
    
    
    @Override
    public void setValueAnimated(double value) {

     //   Poi p = new Poi("a",4.9,5);
     //   ((Radar)gauge).addPoi(p);
//        System.out.println(p.distanceTo(5, 5));
//        System.out.println(p.getLocation());
//        System.out.println(((Radar)gauge).getLocation());
       // gauge.setLocation(new Point(100,-800));
        
    }
    @Override
    public void setLookAndFeel() {
//        gauge.setTrackStart(0);
//        gauge.setTrackStop(10);
        gauge.setTrackStartColor(Color.red);
        gauge.setTrackStopColor(Color.yellow);
        gauge.setLedVisible(true);
        gauge.setTrackVisible(true);
        gauge.setFrameDesign(FrameDesign.BLACK_METAL);
    }
    
}
