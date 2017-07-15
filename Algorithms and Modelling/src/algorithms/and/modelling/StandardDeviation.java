/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.and.modelling;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Sam
 */
public final class StandardDeviation {

    double n;
    double[] a;
    static DecimalFormat dff = new DecimalFormat("###.####");
    double z = 9;
    public StandardDeviation(double[] inputArray, int size) {
        a = inputArray;
        n = size;
        totalCalculation();
    }

    public StandardDeviation() {

    }

    public double firstCalculation() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (a[i] * a[i]);

        }
        sum = sum * n;
        return sum;
    }

    public double secondCalculation() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
        }
        sum = sum * sum;
        return sum;
    }

    public double totalCalculation() {
        double sum = 0;
        sum = firstCalculation() - secondCalculation();
        sum = sum / (n * (n - 1));
        sum = Math.sqrt(sum);

        AlgorithmsAndModelling.SDField.setText(dff.format(sum));
        return sum;
    }

    public double standardise(JTextField inputField) {
        String valueStore = inputField.getText(),
                meanStore = AlgorithmsAndModelling.meanField.getText(),
                sdStore = AlgorithmsAndModelling.SDField.getText();
        double mean, value, sD, zValue = 0;
        if (meanStore.isEmpty()) {
            meanStore = "0";
        }
        if (sdStore.isEmpty()) {
            sdStore = "1";
        }
        try {
            mean = Double.parseDouble(meanStore);
            sD = Double.parseDouble(sdStore);
            value = Double.parseDouble(valueStore);
            zValue = (value - mean) / sD;
        } catch (Exception e) {
            if (valueStore.isEmpty() == false && !valueStore.equals("-")) {
                inputField.setText("");         
            }
        }
        return zValue;
    }
}
