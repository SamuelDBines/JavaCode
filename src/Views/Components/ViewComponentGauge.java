/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Components;

import Helpers.UIDesigner;
import eu.hansolo.steelseries.gauges.AbstractGauge;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kt9517u
 */
public abstract class ViewComponentGauge extends JPanel implements IViewComponentGauge{
    AbstractGauge gauge;
    ViewComponentGaugeInput inputPanel; //JPanel with label input and button
    
    protected void initialSetup(double minValue, double maxValue, String title, String units){
        this.setLayout(new BorderLayout());
        setMinValue(minValue);
        setMaxValue(maxValue);
        gauge.setTitle(title);
        gauge.setUnitString(units);
        inputPanel = new ViewComponentGaugeInput(this);
        setLookAndFeel();
        add(gauge, BorderLayout.CENTER);
    }
    
    @Override 
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
    
    @Override
    public AbstractGauge getGauge(){
        return gauge;
    }
    
    @Override
    public void addInputValueListener(ActionListener listenForButtonPress) {
        inputPanel.button.addActionListener(listenForButtonPress);
     } 
    
    @Override
    public double getInputValue() {
        return inputPanel.getInputValue();
    }
    
    @Override
    public JPanel getInputPanel(){
        return inputPanel;
    }

    @Override
    public void setMaxValue(double value){
        gauge.setMaxValue(value);
    }
    
    @Override
    public double getMaxValue(){
        return gauge.getMaxValue();
    }
    
    @Override
    public void setMinValue(double value){
        gauge.setMinValue(value);
    }
    
    @Override
    public double getMinValue(){
        return gauge.getMinValue();
    }
    
    @Override
    public void setTitle(String title){
        gauge.setTitle(title);
    }   
    
    @Override
    public String getTitle(){
        return gauge.getTitle();
    }
    
    @Override
    public void setUnitString(String unit){
        gauge.setUnitString(unit);
    }
    
    @Override
    public String getUnitString(){
        return gauge.getUnitString();
    }
    
    public void setLookAndFeel() {
        
    }
    
    @Override
    public void toggleInputPanel(){
        inputPanel.input.setText("");
        inputPanel.input.setEditable(!inputPanel.input.isEditable());
        inputPanel.button.setEnabled(!inputPanel.button.isEnabled());
    }
    
    
    public class ViewComponentGaugeInput extends JPanel{ //Input panel for gauges
 
        JTextField input = new JTextField(5);
        JButton button;
        public ViewComponentGaugeInput(ViewComponentGauge viewComponentGauge){
            setLayout(new BorderLayout());
            String label = viewComponentGauge.getTitle();
            button = new JButton(label);   
            if(!label.equals("Radar")) {
                add("Center", UIDesigner.textBoxControl(input,label));
            }
            add("South", UIDesigner.setButton(button));
        }

        public double getInputValue() {
            try {
                return Double.parseDouble(input.getText()); 
            } catch(NumberFormatException ne) {//Error checking
                input.setText("");
                return 0;
            }
        }
        

    }

}
