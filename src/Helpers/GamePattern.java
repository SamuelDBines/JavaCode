package Helpers;

import Views.Components.RadarGaugeComponent;
import eu.hansolo.steelseries.extras.Poi;
import eu.hansolo.steelseries.extras.Radar;
import eu.hansolo.steelseries.gauges.AbstractGauge;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS-X55L
 */

public class GamePattern {
     public int level =0;
    Poi obsticle;
    AbstractGauge player;
    
    public GamePattern(AbstractGauge radar) {
        player = radar;
//        if(onRadar()) {
//            while(!contact() && onRadar()){
//                int direction = new Random().nextInt((4 - 0) + 1) + 0;
//                movePoi(direction);
//            }
//        } else 
//        {
            createObject();
            move();
 //       }
    }
    public boolean contact() {
        return getX() == getXPoi() && getY() == getYPoi();
    }
    private void createObject() {
         double positionX = new Random().nextDouble();
         double positionY = new Random().nextDouble();         
         obsticle = new Poi("a",4.9,5);
    }
    public boolean onRadar() {       
        ((Radar)player).addPoi(obsticle);
        return obsticle.distanceTo(getX(),getY()) <= 1;
    }
    double increment = 0;
    boolean wPressed = true;
    public void move() {
         KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {               
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                            wPressed = true;
                            movePoi(1);
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                            wPressed = true;
                            movePoi(2);
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_UP) {
                            wPressed = true;
                            movePoi(3);
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                            wPressed = true;
                            movePoi(0);
                        }
                        break;

                    case KeyEvent.KEY_RELEASED:
                        if (ke.getKeyCode() == KeyEvent.VK_W) {
                            wPressed = false;
                        }
                        break;
                    }
                    return false;                
            }
        });
    }
    public void movePoi(int move) {
        
        switch(move) {
            case 1:                
                obsticle.setLocation(getXPoi() - 0.01, getYPoi());
                System.out.println(obsticle.getLocation());
                  ((Radar)player).addPoi(obsticle);
                break;
            case 2:
                obsticle.setLocation(getXPoi() + 0.01, getYPoi());
                  ((Radar)player).addPoi(obsticle);
                break;
            case 3:
                obsticle.setLocation(getXPoi() , getYPoi()+ 0.01);
                  ((Radar)player).addPoi(obsticle);
                break;
            default:
                 obsticle.setLocation(getXPoi() , getYPoi()- 0.01);
                   ((Radar)player).addPoi(obsticle);
                break;
        }
    }
    
    private double getX() {
        return ((Radar)player).getLocation().x;
    }
    private double getY() {
        return ((Radar)player).getLocation().y;
    }
    private double getXPoi() {
        return obsticle.getLocation().getX();
    }
    private double getYPoi() {
        return obsticle.getLocation().getY();
    }
//        ((Radar)gauge).addPoi(p);
//        System.out.println(p.distanceTo(5, 5));
//        System.out.println(p.getLocation());
//        System.out.println(((Radar)gauge).getLocation());
}
