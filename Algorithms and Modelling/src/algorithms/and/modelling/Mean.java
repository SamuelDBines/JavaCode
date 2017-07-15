/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.and.modelling;

/**
 *
 * @author Sam
 */
public final class Mean {

    int n = 0;
    double[] t;
    double sum;

    Mean(double[] inputArray, int size) {
        n = size;
        t = inputArray;
        sum = 0;
        calculate();
    }

    double calculate() {
        for (int i = 0; i < n; i++) {
            sum = sum + t[i];
        }
        sum = sum / n;
        AlgorithmsAndModelling.meanField.setText(StandardDeviation.dff.format(sum));
        return sum;
    }
}
