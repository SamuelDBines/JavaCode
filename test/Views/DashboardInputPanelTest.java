/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sam
 */
public class DashboardInputPanelTest {
    
    public DashboardInputPanelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isXMLRadioButtonSelected method, of class DashboardInputPanel.
     */
    @Test
    public void testIsXMLRadioButtonSelected() {
        System.out.println("isXMLRadioButtonSelected");
        DashboardInputPanel.XMLAlgorithms button = null;
        DashboardInputPanel instance = null;
        boolean expResult = false;
        boolean result = instance.isXMLRadioButtonSelected(button);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addButtonListener method, of class DashboardInputPanel.
     */
    @Test
    public void testAddButtonListener() {
        System.out.println("addButtonListener");
        ActionListener buttonListener = null;
        DashboardInputPanel.extraButton button = null;
        DashboardInputPanel instance = null;
        instance.addButtonListener(buttonListener, button);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toggleButton method, of class DashboardInputPanel.
     */
    @Test
    public void testToggleButton() {
        System.out.println("toggleButton");
        DashboardInputPanel.extraButton button = null;
        DashboardInputPanel instance = null;
        instance.toggleButton(button);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toggleAllButtons method, of class DashboardInputPanel.
     */
    @Test
    public void testToggleAllButtons() {
        System.out.println("toggleAllButtons");
        DashboardInputPanel instance = null;
        instance.toggleAllButtons();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toggleAllExceptButton method, of class DashboardInputPanel.
     */
    @Test
    public void testToggleAllExceptButton() {
        System.out.println("toggleAllExceptButton");
        DashboardInputPanel.extraButton button = null;
        DashboardInputPanel instance = null;
        instance.toggleAllExceptButton(button);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getExtraButtonsMap method, of class DashboardInputPanel.
     */
    @Test
    public void testGetExtraButtonsMap() {
        System.out.println("getExtraButtonsMap");
        DashboardInputPanel instance = null;
        Map<DashboardInputPanel.extraButton, JButton> expResult = null;
        Map<DashboardInputPanel.extraButton, JButton> result = instance.getExtraButtonsMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPanel method, of class DashboardInputPanel.
     */
    @Test
    public void testGetPanel() {
        System.out.println("getPanel");
        DashboardInputPanel instance = null;
        JPanel expResult = null;
        JPanel result = instance.getPanel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
