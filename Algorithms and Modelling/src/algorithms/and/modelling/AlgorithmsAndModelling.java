/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.and.modelling;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;

/**
 *
 * @author Sam
 */
public class AlgorithmsAndModelling extends JFrame implements ActionListener, ItemListener {
   
    
    private final JButton[] buttons = {new JButton("Table"),
        new JButton("Graph"),
        new JButton("Input Data"),
        new JButton("Close")};
    public ButtonGroup radios = new ButtonGroup();
    public static JRadioButton[] radioButtons = {new JRadioButton("P(x <"),
        new JRadioButton("P(x >"),
        new JRadioButton("P(      "),
        new JRadioButton("P(x <")};

    public static JButton addToGrid = new JButton("Add"),
            calculateButton = new JButton("Calculate"),
            resetGrids = new JButton("Reset");
    public static JTextField meanField = new JTextField(15),
            probabilityField = new JTextField(15),
            SDField = new JTextField(15),
            mainField = new JTextField(10),
            secondMainField = new JTextField(10);

    public static JTextField[] radioFields = {new JTextField(10),
        new JTextField(10),
        new JTextField(10),
        new JTextField(10),
        new JTextField(10),
        new JTextField(10)};
    static JPanel storeComponent = new JPanel(new CardLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    private final JPanel buttonLayout = new JPanel(new GridBagLayout());
    private static BuildTable b = new BuildTable();
    Mean m;
    StandardDeviation s = new StandardDeviation();
    static String getPosition = "Two";

    public static void main(String[] args) {
        AlgorithmsAndModelling m = new AlgorithmsAndModelling();
        m.setFrame();
    
        
    }

    /**
     * Class BuildTable creates a grid of textfields used to take information
     * from the user.
     */
    public void setFrame() {
        setUndecorated(true);//Remove shit frame
        setLayout(new BorderLayout());
        setButtons();
        add("East", GUIControl.addDraggablePanels(new JPanel(), this));
        add("West", GUIControl.addDraggablePanels(new JPanel(), this));
        add("North", setDragBorders(buttonLayout));
        gbc.gridx = 1;
        add("South", setDragBorders(addTextBoxes()));
        setRadioButtons();
        changeCenter();
        addListeners();
        setSize(750, 600);
        setLocationRelativeTo(null);//CENTER FRAME
        setResizable(false);
        setVisible(true);
    }

    public JPanel setDragBorders(JPanel inputPanel) {
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add("North", GUIControl.addDraggablePanels(new JPanel(), this));
        borderPanel.add("East", GUIControl.addDraggablePanels(new JPanel(), this));
        borderPanel.add("West", GUIControl.addDraggablePanels(new JPanel(), this));
        borderPanel.add("South", GUIControl.addDraggablePanels(new JPanel(), this));
        borderPanel.add("Center", inputPanel);
        inputPanel.setBackground(Color.lightGray);
        return borderPanel;
    }

    public void setButtons() {
        gbc.gridy = 0;
        gbc.gridx = 1;
        for (int i = 0; i < buttons.length; i++) {
            buttonLayout.add(GUIControl.setButton(buttons[i]), gbc);
            buttons[i].addActionListener(this);
            gbc.gridx = i + 2;
        }
    }

    public JPanel addTextBoxes() {

        JPanel textboxpanel = new JPanel();
        textboxpanel.add(radioPositions());
        textboxpanel.add(fieldPositions("SD", SDField, "1"));
        textboxpanel.add(fieldPositions("Mean", meanField, "0"));
        setAutomaticUpdating(meanField);
        setAutomaticUpdating(SDField);
        for (int i = 0; i <= 5; i++) {
            setAutomaticUpdating(radioFields[i]);
        }

        textboxpanel.setBorder(BorderFactory.createLineBorder(Color.black));
        return textboxpanel;
    }

    public JPanel fieldPositions(String labelName, JTextField inputField, String message) {
        JPanel temp = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        temp.add(new JLabel(labelName));
        gbc.gridy = 1;
        inputField.setText(message);
        temp.add(inputField, gbc);
        temp.setBorder(BorderFactory.createLineBorder(Color.black));
        return temp;
    }

    public JPanel radioPositions() {
        JPanel temp = new JPanel(new GridBagLayout());
        gbc.gridx = 0;

        for (int i = 0; i <= 3; i++) {
            gbc.gridy = i;
            temp.add(radioButtons[i], gbc);
            radios.add(radioButtons[i]);
        }
        gbc.gridx = 1;
        for (int i = 0; i <= 3; i++) {
            gbc.gridy = i;
            temp.add(radioFields[i], gbc);
        }
        gbc.gridx = 2;
        for (int i = 0; i <= 3; i++) {
            gbc.gridy = i;
            if (i < 2) {
                temp.add(new JLabel(")             "), gbc);
            } else if (i == 2) {
                temp.add(new JLabel("  <  x  <  "), gbc);
            } else {
                temp.add(new JLabel(") and P(x>"), gbc);
            }
        }
        gbc.gridx = 3;
        for (int i = 4; i <= 5; i++) {
            gbc.gridy = i - 2;
            temp.add(radioFields[i], gbc);
        }
        gbc.gridx = 4;
        for (int i = 2; i <= 3; i++) {
            gbc.gridy = i;
            temp.add(new JLabel(")"), gbc);
        }
        radioButtons[0].setSelected(true);
        temp.setBorder(BorderFactory.createLineBorder(Color.black));
        return temp;
    }

    void setAutomaticUpdating(JTextField inputField) {
        inputField.addCaretListener((CaretEvent ce) -> {
            if (getPosition.equals("Two")) {
                updateTable();
            } else {
                updateGraph();
            }

        });
    }

    public void addListeners() {
        //BuildTable buttons used for control.
        addToGrid.addActionListener(this);
        resetGrids.addActionListener(this);
        calculateButton.addActionListener(this);
        for (int i = 0; i <= 3; i++) {
            radioButtons[i].addItemListener(this);
        }

    }

    void changeCenter() {

        storeComponent.add(GUIControl.setScrollPanes(b), "Two");
        storeComponent.add(Input_Table_Design.createTableGrid(), "One");
        storeComponent.add(new Graph(), "Three");
        add("Center", storeComponent);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == calculateButton) {
            try {
                int counter = 0;
                double[] temp = Input_Table_Design.calculate();
                double[] improve = new double[Input_Table_Design.getSize()];
                for (int i = 0; i < Input_Table_Design.getSize(); i++) {
                    if (temp[i] != 0.0) {
                        improve[counter] = temp[i];
                        counter++;
                    }
                }
                StandardDeviation a = new StandardDeviation(improve, counter);
                m = new Mean(improve, counter);
            } catch (Exception e) {
            }
        }
        if (ae.getSource() == buttons[1]) {
            updateGraph();

        }
        if (ae.getSource() == buttons[0]) {
            updateTable();

        }
        if (ae.getSource() == buttons[2]) {
            getPosition = "One";
            CardLayout cardLayout = (CardLayout) storeComponent.getLayout();
            cardLayout.show(storeComponent, "One");
        }
        if (ae.getSource() == addToGrid) {
            Input_Table_Design.setSize(1);
            this.revalidate();
        } else if (ae.getSource() == resetGrids) {
            Input_Table_Design.resetGrid();
        }
        if (ae.getSource() == buttons[3]) {
            System.exit(0);
        }

    }

    static void updateGraph() {
        getPosition = "Three";
        Graph g = new Graph();
        storeComponent.add(g, "Three");
        CardLayout cardLayout = (CardLayout) storeComponent.getLayout();
        cardLayout.show(storeComponent, "Three");
    }

    static void updateTable() {
        getPosition = "Two";
        double sum = 0, second_value = 0;
        if (radioButtons[0].isSelected()) {
            sum = b.shadeLessPosition(radioFields[0]);
        } else if (radioButtons[1].isSelected()) {
            sum = b.shadeGreaterPosition(radioFields[1]);
        } else if (radioButtons[2].isSelected()) {
            sum = b.shadeGreaterPosition(radioFields[2]);
            second_value = b.shadeLessPosition(radioFields[4]);
        } else {
            sum = b.shadeLessPosition(radioFields[3]);
            second_value = b.shadeLessPosition(radioFields[5]);
        }

        if (radioButtons[2].isSelected() || radioButtons[3].isSelected()) {
            b.shadeTablePosition(StandardDeviation.dff.format(sum), StandardDeviation.dff.format(second_value));
        } else {
            b.shadeTablePosition(StandardDeviation.dff.format(sum), null);
        }
        storeComponent.add(GUIControl.setScrollPanes(b), "Two");
        CardLayout cardLayout = (CardLayout) storeComponent.getLayout();
        cardLayout.show(storeComponent, "Two");

    }

    void changeRadioButtons(ItemEvent ie) {
        for (int i = 0; i <= 3; i++) {
            radioFields[i].setEditable(false);
            if (ie.getSource() == radioButtons[i]) {
                radioFields[i].setEditable(true);
            }
        }
        radioFields[4].setEditable(false);
        radioFields[5].setEditable(false);
        if (ie.getSource() == radioButtons[2]) {
            radioFields[4].setEditable(true);
        } else if (ie.getSource() == radioButtons[3]) {
            radioFields[5].setEditable(true);
        }

    }

    void setRadioButtons() {
        for (int i = 0; i <= 3; i++) {
            radioFields[i].setEditable(false);
            if (radioButtons[i].isSelected()) {
                radioFields[i].setEditable(true);
            }
        }
        radioFields[4].setEditable(false);
        radioFields[5].setEditable(false);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        changeRadioButtons(ie);
        updateGraph();
    }
}
