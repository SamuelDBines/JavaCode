/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author kt9517u
 */
public class GaugeModel implements IModel {
    private double value;
    
    public GaugeModel(){
        this.value = 0.0f;
    }
    
    public GaugeModel(double value){
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }
}
