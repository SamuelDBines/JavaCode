/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.and.modelling;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sam
 */
public class Input_Table_Design {

    private static ArrayList<JTextField> fieldArray;
    private static final JPanel textFieldGrid = new JPanel(new GridBagLayout()),
            finalLayout = new JPanel(new BorderLayout()),
            buttonLayout = new JPanel(new GridBagLayout());
    private static int size = 10;
    private static final GridBagConstraints gbc = new GridBagConstraints();

    public static double[] calculate() {
        double temp;
        double[] storeValues = new double[getSize()];
        for (int i = 0; i < getSize(); i++) {
            try {
                String test = fieldArray.get(i).getText();
                temp = Double.parseDouble(test);
                storeValues[i] = temp;
            } catch (Exception e) {
                storeValues[i] = 0.0;
            }
        }
        return storeValues;
    }

    public static JPanel createTableGrid() {
        fieldArray = new ArrayList<>();
        JTextField temp = new JTextField(10);
        gbc.gridx = 0;
        for (int i = 0; i < getSize(); i++) {
            fieldArray.add(temp);
            gbc.gridy = i;
            textFieldGrid.add(temp, gbc);
            temp = new JTextField(10);
        }
        setButtonLayout();
        finalLayout.add("Center", textFieldGrid);
        return finalLayout;
    }

    public static void resetGrid() {
        for (int i = 0; i < getSize(); i++) {
            fieldArray.get(i).setText("");
        }
    }

    private static void setButtonLayout() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonLayout.add(GUIControl.setButton(AlgorithmsAndModelling.calculateButton), gbc);
        gbc.gridx = 1;
        buttonLayout.add(GUIControl.setButton(AlgorithmsAndModelling.addToGrid), gbc);
        gbc.gridx = 2;
        buttonLayout.add(GUIControl.setButton(AlgorithmsAndModelling.resetGrids), gbc);
        finalLayout.add("South", buttonLayout);
    }

    public static void setSize(int inputValue) {
        size = size + inputValue;
        textFieldGrid.removeAll();
        createTableGrid();
    }

    public static int getSize() {
        return size;
    }

}
