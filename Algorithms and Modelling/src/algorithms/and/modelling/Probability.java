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
public class Probability {
    public static double area;
    private static double powerCalculation(double x) {
        double sum;
        sum = -1 * (x * x);
        sum = sum / 2;
        return sum;
    }

    public static double yOrdinate(double x) {
        double sum = 1;
        sum = sum / Math.sqrt((2 * Math.PI));
        sum = sum * (Math.exp(powerCalculation(x)));
        return sum;
    }

    public double zeroIntergral() {
        return 0.5;
    }
    
    public static double simpsonRule(double value) {
        boolean odd = true;
        int loopTotal = (int) (value / 0.00001);
        double increment;
        double sum = 0;
        for (int j = 0; j < loopTotal; j++) {
            increment = j * 0.00001;
            if (j == 0) {
                sum = sum + (yOrdinate(increment));
            } else if (odd) {
                sum = sum + (4 * yOrdinate(increment));
                odd = false;
            } else {
                sum = sum + (2 * yOrdinate(increment));
                odd = true;
            }
            
        }
        sum = sum + yOrdinate(value);
        double area = ((1.0 / 3.0) * 0.00001 * sum) + 0.5;
        return area;
    }

    public double findAreaCalc(double x1, double x2, double increment) {
        double sum = x1 + x2;
        sum = sum / 2;
        sum = sum * increment;
        return sum;
    }
    public static double twoTailProbability(double zValue,double zValueHigher){
        double probabilityOne, probabilityTwo;
        if(zValueHigher > 0) {
            probabilityOne = 1- simpsonRule(zValueHigher);
        } else {
            probabilityOne =  simpsonRule(zValueHigher * -1);
        }
        if(zValue > 0) {
            probabilityTwo = simpsonRule(zValue);
        } else {
             probabilityTwo = 1- simpsonRule(zValue * -1);
        }
        area = probabilityOne + probabilityTwo;
        return area;
    }
    public static double betweenProbability(double zValue, double zValueHigher) {
        double probabilityOne, probabilityTwo;
        if (zValueHigher > 0) {
            probabilityOne =    simpsonRule(zValueHigher);
        } else {
            probabilityOne = 1 - simpsonRule(zValueHigher * -1);
        }
        if (zValue > 0) {
            probabilityTwo = simpsonRule(zValue);
        } else {
            probabilityTwo = 1 - simpsonRule(zValue * -1);
        }
        area = probabilityOne - probabilityTwo;
        return area;
    }
    public static double greaterThanProbability(double zValue) {
        if (zValue > 0) {
            area = 1 - simpsonRule((zValue));
        } else {
            area = simpsonRule((zValue * -1));
        }
        return area;
    }
    public static double lessThanProbability(double zValue) {
        if (zValue > 0) {
            area = simpsonRule(zValue);
        } else {
            area = 1 - simpsonRule((zValue * -1));
        }
        return area;
    }

}
