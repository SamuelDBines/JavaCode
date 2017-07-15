/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.and.modelling;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sam
 */
public class Graph extends JPanel {

    double area = 0;
    Graphics2D g2d;
    int xPosition = 360,
            yPosition = 350,
            scaleY = 500,
            scaleX = 100;
    Probability p = new Probability();
    ArrayList<Integer> points;
    StandardDeviation s = new StandardDeviation();
    double main_value = 0, second_value = 0;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;
        setPoints(g2d);
        setLabelText(g2d);
        if (AlgorithmsAndModelling.radioButtons[0].isSelected()) {
            shadeGraph(AlgorithmsAndModelling.radioFields[0]);
        } else if (AlgorithmsAndModelling.radioButtons[1].isSelected()) {
            shadeGreaterThan(AlgorithmsAndModelling.radioFields[1]);
        } else if (AlgorithmsAndModelling.radioButtons[2].isSelected()) {
            shadeBetween();
        } else {
            Graph.this.shadeTwoTail();
        }

    }

    private void shadeBetween() {
        String mainBox = AlgorithmsAndModelling.radioFields[2].getText();
        String secondBox = AlgorithmsAndModelling.radioFields[4].getText();
        if (mainBox.isEmpty() == false && secondBox.isEmpty() == false) {
            main_value = s.standardise(AlgorithmsAndModelling.radioFields[2]);
            second_value = s.standardise(AlgorithmsAndModelling.radioFields[4]);
            if (main_value < second_value) {
                shadeBetween(main_value, second_value);
            } else if (main_value == second_value) {
                drawHints(g2d, "Hint :\nMake sure the values are not equal");
            } else if (main_value > second_value) {
                drawHints(g2d, "Hint :\nThe left value should be less");
            }

        }
    }

    private void shadeGraph(JTextField inputField) {
        String mainBox = inputField.getText();
        main_value = s.standardise(inputField);
        if (mainBox.isEmpty() == false) {
            shadeLessThan(main_value);
        }
    }

    private void shadeGreaterThan(JTextField inputField) {
        String mainBox = inputField.getText();
        main_value = s.standardise(inputField);
        if (mainBox.isEmpty() == false) {
            shadeGreaterThan(main_value);
        }
    }

    private void shadeTwoTail() {
        String mainBox = AlgorithmsAndModelling.radioFields[3].getText();
        if (mainBox.isEmpty() == false) {
            try {
                main_value = s.standardise(AlgorithmsAndModelling.radioFields[3]);
                second_value = s.standardise(AlgorithmsAndModelling.radioFields[5]);
            } catch (Exception e) {

            }
            if (main_value < second_value) {
                shadeTwoTail(main_value, second_value);
            } else if (main_value == second_value) {
                drawHints(g2d, "Hint :\n make sure the values are not the same");
            } else {
                drawHints(g2d, "Hint :\n the left value should be less");
            }
        }
    }

    public void setPoints(Graphics2D g) {
        double value = 0, next = 0.01;
        double last = 3;
        double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        g.setStroke(new BasicStroke(2));
        while (value < last) {
            x1 = ((value * scaleX) + xPosition);
            y1 = yPosition - (p.yOrdinate(value) * scaleY);
            x2 = ((next * scaleX) + xPosition);
            y2 = yPosition - (p.yOrdinate(next) * scaleY);
            g.setColor(Color.red);
            g.draw(new Line2D.Double(x1, y1, x2, y2));//Draw positive values of graph
            g.setColor(Color.black);
            g.draw(new Line2D.Double(x1, yPosition, x2, yPosition));//Draw positive values of x-axis
            x1 = xPosition - (value * scaleX);
            x2 = xPosition - (next * scaleX);
            g.setColor(Color.red);
            g.draw(new Line2D.Double(x1, y1, x2, y2));//Draw negative values of graph
            g.setColor(Color.black);
            g.draw(new Line2D.Double(x1, yPosition, x2, yPosition));//Draw negative values of x-axis
            value = value + 0.01;
            next = value + 0.01;
        }
        for (int i = -300; i <= 300; i = i + 100) {
            createPoints(g, i);
        }

    }

    public void createPoints(Graphics2D g, double xPlacement) {
        xPlacement = xPosition + xPlacement;
        double y1, y2;
        g.setColor(Color.black);
        for (int i = 0; i < 20; i++) {
            y1 = yPosition + i;
            y2 = yPosition + (i + 1);
            g.draw(new Line2D.Double(xPlacement, y1, xPlacement, y2));
        }
    }

    public void drawArea(Graphics2D g, double xPlacement, double y1, double y2) {
        xPlacement = xPosition + xPlacement;
        for (int i = 0; i < 20; i++) {
            y1 = yPosition + i;
            y2 = yPosition + (i + 1);
            g.draw(new Line2D.Double(xPlacement, y1, xPlacement, y2));
        }
    }

    public void drawLabels(Graphics2D g, String value, int xPlacement) {
        xPlacement = xPosition + xPlacement;
        g.setFont(new Font("Serif - BOLD", Font.BOLD, 12));
        g.drawString(value, (xPlacement - 5), (yPosition + 40));
    }

    private void drawHints(Graphics2D g, String value) {
        int xPlacement = xPosition - 200;
        g.setFont(new Font("Serif - BOLD", Font.BOLD, 12));
        g.drawString(value, (xPlacement), (yPosition - 250));
    }

    public void drawProbability_Results(Graphics2D g, String value) {
        int xPlacement = xPosition - 50;
        g.setFont(new Font("Serif - BOLD", Font.BOLD, 12));
        g.drawString(value, (xPlacement), (yPosition - 300));
    }

    public void setLabelText(Graphics2D g) {
        String mean = AlgorithmsAndModelling.meanField.getText();
        String SD = AlgorithmsAndModelling.SDField.getText();
        if (mean.isEmpty()) {
            mean = "0";
        }
        if (SD.isEmpty() || SD.equals("Enter Number")) {
            SD = "1";
        }
        double sdLimit = 0, meanLimit = 0;
        try {
            sdLimit = Double.parseDouble(SD);
        } catch (Exception e) {
            AlgorithmsAndModelling.SDField.setText("");
        }
        try {

            meanLimit = Double.parseDouble(mean);
        } catch (Exception e) {
            AlgorithmsAndModelling.meanField.setText("");
        }
        drawLabels(g, (meanLimit + ""), 0);
        for (int i = 0; i <= 300; i = i + 100) {
            drawLabels(g, StandardDeviation.dff.format(meanLimit), i);
            meanLimit = meanLimit + sdLimit;
        }
        meanLimit = Double.parseDouble(mean) - sdLimit;
        for (int i = -100; i >= -300; i = i - 100) {
            drawLabels(g, StandardDeviation.dff.format(meanLimit), i);
            meanLimit = meanLimit - sdLimit;
        }
    }

    void shadeLessThan(double zValue) {
        double xPlacement;
        double y1;
        g2d.setColor(Color.blue);
        area = Probability.lessThanProbability(zValue);
        while (zValue > -3) {
            xPlacement = (100 * zValue) + xPosition;
            y1 = yPosition - (p.yOrdinate(zValue) * scaleY);
            g2d.draw(new Line2D.Double(xPlacement, yPosition, xPlacement, y1));
            zValue = zValue - 0.01;
        }
        drawResults();
    }

    void shadeGreaterThan(double zValue) {
        double xPlacement;
        double y1;
        g2d.setColor(Color.blue);
        area = Probability.greaterThanProbability(zValue);
        while (zValue < 3) {
            xPlacement = (100 * zValue) + xPosition;
            y1 = yPosition - (p.yOrdinate(zValue) * scaleY);
            g2d.draw(new Line2D.Double(xPlacement, yPosition, xPlacement, y1));
            zValue = zValue + 0.01;
        }
        drawResults();
    }

    void shadeBetween(double zValue, double zValueHigher) {
        double xPlacement;
        double y1;
        g2d.setColor(Color.blue);
        area = Probability.betweenProbability(zValue, zValueHigher);
        while (zValue < zValueHigher) {
            xPlacement = (100 * zValue) + xPosition;
            y1 = yPosition - (Probability.yOrdinate(zValue) * scaleY);
            g2d.draw(new Line2D.Double(xPlacement, yPosition, xPlacement, y1));
            zValue = zValue + 0.01;
        }
        drawResults();
    }

    void shadeTwoTail(double zValue, double zValueHigher) {
        double xPlacement, y1, probabilityOne, probabilityTwo;
        g2d.setColor(Color.blue);
        area = Probability.twoTailProbability(zValue, zValueHigher);
        while (zValue > -3) {
            xPlacement = (100 * zValue) + xPosition;
            y1 = yPosition - (Probability.yOrdinate(zValue) * scaleY);
            g2d.draw(new Line2D.Double(xPlacement, yPosition, xPlacement, y1));
            zValue = zValue - 0.01;
        }
        while (zValueHigher < 3) {
            xPlacement = (100 * zValueHigher) + xPosition;
            y1 = yPosition - (Probability.yOrdinate(zValueHigher) * scaleY);
            g2d.draw(new Line2D.Double(xPlacement, yPosition, xPlacement, y1));
            zValueHigher = zValueHigher + 0.01;
        }
        drawResults();
    }

    void drawResults() {
        g2d.setColor(Color.black);
        drawProbability_Results(g2d, ("Probability : " + StandardDeviation.dff.format(area)));
    }

}
