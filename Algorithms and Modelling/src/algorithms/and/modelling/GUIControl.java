/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.and.modelling;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;

/**
 *
 * @author Sam
 */
public class GUIControl {
    private static int positionX, positionY;//Stores position x and y for the drag panel
    public static void setHoverButtons(JButton inputButton) {
        //Prevent focus on buttons : removes unwanted squares
        inputButton.setFocusPainted(false);
        //set button size
        inputButton.setPreferredSize(new Dimension(100, 40));
        //remove borders from buttons
        inputButton.setBorder(null);
        //set background color
        inputButton.setBackground(Color.lightGray);
    }

    /**
     * ALLOW EVENTS TO TAKE PLACE WHEN MOUSE HOVER OVERS A BUTTON METHOD TAKES
     * IN A JBUTTON AND ADDS THE MOUSE LISTENER TO IT
     *
     * @param inputButton
     */
    public static void hoverButton(final JButton inputButton) {
        //Listen for mouse events
        inputButton.addMouseListener(new java.awt.event.MouseAdapter() {//MOUSELISTENER
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {//MOUSE ENTER AREA THEN
                inputButton.setBackground(Color.blue);//SET BACKGROUND WHITE
                inputButton.setForeground(Color.white);//SET TEXTCOLOR BLACK
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {//MOUSE EXIT AREA THEN
                inputButton.setBackground(Color.lightGray);//SET BACKGROUND BLACK
                inputButton.setForeground(Color.black);//SET TEXTCOLOR BLACK
            }
        });
    }

    /**
     * ACCESS BOTH THE SET HOVERBUTTONS AND HOVERBUTTONS METHOD, THEY COULD BE
     * PUT INTO ONE METHOD HOWEVER THE ORIGNAL DESIGN NEEDED SEPERATE METHODS
     * AND I DID NOT CHANGE IT.
     *
     * @param inputButton
     * @return
     */
    public static JButton setButton(JButton inputButton) {
        //set buttons orignal state
        setHoverButtons(inputButton);
        //set hovering 
        hoverButton(inputButton);
        return inputButton;//RETURN BUTTON
    }

    public static JTextField setTextFields(JTextField inputField) {
        inputField.setBackground(Color.white);//SET BACKGROUND WHITE
        inputField.setForeground(Color.black);//SET TEXTCOLOR BLACK
        inputField.setBorder(null);
        inputField.setEditable(false);//NOT EDITABLE
        inputField.setHorizontalAlignment(SwingConstants.CENTER);
        return inputField;//RETURN PANEL
    }
    public static JPanel addDraggablePanels(JPanel inputPanel, JFrame frame) {
        //Set Background color
        inputPanel.setBackground(Color.blue);
        //Listen for mouse events
        inputPanel.addMouseListener(new MouseAdapter() {//MOUSE LISTENER
            @Override
            public void mousePressed(MouseEvent me) {//WHEN MOUSE PRESSED
                positionX = me.getX();//CHANGE POSITION X
                positionY = me.getY();//CHANGE POSITION Y
            }
        });
        //Listen for mouse motion events
        inputPanel.addMouseMotionListener(new MouseAdapter() {//MOTION LISTENER
            @Override
            public void mouseDragged(MouseEvent me) {
                frame.setLocation(frame.getLocation().x + me.getX() - positionX, frame.getLocation().y + me.getY() - positionY);//GET NEW POSITIONS
            }
        });
        return inputPanel;//RETURN PANEL
    }

    public static JScrollPane setScrollPanes(JPanel inputPanel) {
        JScrollPane scroller = new JScrollPane(inputPanel);//Adds a scroll pane 
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//Do not allow horizontal scrolling
        inputPanel.setAutoscrolls(true);//Set automatic scrolling , automatic sets up a scroll bar when needed
        scroller.setWheelScrollingEnabled(true);//Scroll with the mouse wheel if they choose
        return scroller;//Return the scroll to be added to the main panel
    }

    public static JTextField textBoxControl(final JTextField input, final String text) {//ADDS MOUSE CLICK TO TEXTFIELDS
        input.setText(text);//SET TEXT INPUT
        input.addMouseListener(new MouseAdapter() {//LISTEN FOR MOUSE
            @Override
            public void mouseClicked(MouseEvent e) {//IF MOUSE CLICKED
                if (input.getText().equals(text) || input.getText().isEmpty()) {//IF FIELD IS EMPTY
                    input.setText("");//SET TEXT EMPTY
                    input.setFocusable(true);//Focused on textfield
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {//MOUSE ENTERS AREA
                if (input.getText().equals(text) || input.getText().isEmpty()) {//IF FIELD IS EMPTY
                    input.setText("");//SET TEXT EMPTY
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {//MOUSE LEAVES FIELD
                if (input.getText().isEmpty() || input.getText().equals(text)) {//IF FIELD IS EMPTy
                    input.setFocusable(false);
                    input.setText(text);//RESET TEXT
                }
            }
        });
        input.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                input.setText("");
                input.setFocusable(true);
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (input.getText().isEmpty()) {
                    input.setText(text);
                    input.setFocusable(false);
                }
            }
        });
        return input;
    }

    
}
