/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.and.modelling;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sam
 */
public class BuildTable extends JPanel {

    /**
     *
     */
    public ArrayList<JTextField> fieldArray;
    private static final JPanel tableGrid = new JPanel(new GridBagLayout());
    static int counter = 0;
    private static final ArrayList<Double> probabilityStore = new ArrayList<>();
    private static final int matrixSizeY = 11;
    private static final int matrixSizeX = 31;
    private static final JTextField[][] probabilityTable = new JTextField[matrixSizeX][matrixSizeY];

    private static final GridBagConstraints gbc = new GridBagConstraints();
    private static StandardDeviation s = new StandardDeviation();
    private static double main_value, second_value, area;
    private boolean isNegative = false;

    public BuildTable() {
        buildArrayList();
        createMatrixTable();
        add(setMatrixTable());
    }

    private void buildArrayList() {
        double start = 0;
        double last = 3.0;
        try {
            Probability p = new Probability();
            while (start < last) {
                probabilityStore.add(counter, Probability.simpsonRule(start));
                counter++;
                start = start + 0.01;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
    }

    private void createMatrixTable() {
        for (int i = 0; i < matrixSizeX; i++) {
            for (int j = 0; j < matrixSizeY; j++) {
                probabilityTable[i][j] = GUIControl.setTextFields(new JTextField(5));
                probabilityTable[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
                probabilityTable[i][j].setBackground(Color.lightGray);
            }
        }
    }

    private JPanel setMatrixTable() {
        int countUp = 0;
        for (int i = 0; i < matrixSizeX; i++) {
            for (int j = 0; j < matrixSizeY; j++) {
                probabilityTable[i][j].setForeground(Color.BLUE);
                if (i == 0 && j == 0) {
                    probabilityTable[i][j].setText("+");

                } else if (i == 0 && j > 0) {
                    probabilityTable[i][j].setText("| 0.0" + (j - 1) + " |");
                } else if (j == 0 && i > 0) {

                    if (i > 10 && i <= 20) {
                        probabilityTable[i][j].setText("| 1." + (i % 11) + " |");
                    } else if (i > 20) {
                        probabilityTable[i][j].setText("| 2." + ((i - 1) % 10) + " |");
                    } else {
                        probabilityTable[i][j].setText("| 0." + (i - 1) + " |");
                    }
                } else {
                    probabilityTable[i][j].setForeground(Color.BLACK);
                    probabilityTable[i][j].setText(StandardDeviation.dff.format(probabilityStore.get(countUp)) + "");
                    countUp++;
                }

                gbc.gridx = i;
                gbc.gridx = j;
                tableGrid.add(probabilityTable[i][j], gbc);

            }
        }
        return tableGrid;
    }

    public double shadeLessPosition(JTextField inputField) {
        String mainBox = inputField.getText();
        main_value = s.standardise(inputField);
        if (mainBox.isEmpty() == false) {
            if (main_value < 0) {
                area = 1 - Probability.lessThanProbability(main_value);
                isNegative = true;
            } else {
                area = Probability.lessThanProbability(main_value);
                isNegative = false;
            }
        }

        return area;
    }

    public double shadeGreaterPosition(JTextField inputField) {
        String mainBox = inputField.getText();
        main_value = s.standardise(inputField);
        if (mainBox.isEmpty() == false) {
            if (main_value > 0) {
                area = 1 - Probability.greaterThanProbability(main_value);
                isNegative = true;
            } else {
                area = Probability.greaterThanProbability(main_value);
                isNegative = false;
            }
        }

        return area;
    }
    

    public void shadeTablePosition(String input_value, String input_second) {
        for (int i = 1; i < matrixSizeX; i++) {
            for (int j = 1; j < matrixSizeY; j++) {
                if ((probabilityTable[i][j].getText().equals(input_value) || probabilityTable[i][j].getText().equals(input_second))&& isNegative) {
                    probabilityTable[i][j].setForeground(Color.red);
                    probabilityTable[i][j].setBackground(Color.WHITE);
                } else if ((probabilityTable[i][j].getText().equals(input_value) || probabilityTable[i][j].getText().equals(input_second)) && !isNegative) {
                    probabilityTable[i][j].setForeground(Color.white);
                    probabilityTable[i][j].setBackground(Color.blue);
                } else {
                   probabilityTable[i][j].setForeground(Color.black);
                  probabilityTable[i][j].setBackground(Color.lightGray);
                }
            }
        }
    }

}
