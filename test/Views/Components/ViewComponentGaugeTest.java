/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Components;

import eu.hansolo.steelseries.gauges.AbstractGauge;
import java.awt.Dimension;
import java.awt.event.ActionListener;
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
public class ViewComponentGaugeTest {
    
    public ViewComponentGaugeTest() {
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
     * Test of initialSetup method, of class ViewComponentGauge.
     */
    @Test
    public void testInitialSetup() {
        System.out.println("initialSetup");
        double minValue = 0.0;
        double maxValue = 0.0;
        String title = "";
        String units = "";
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        instance.initialSetup(minValue, maxValue, title, units);
    }

    /**
     * Test of getPreferredSize method, of class ViewComponentGauge.
     */
    @Test
    public void testGetPreferredSize() {
        System.out.println("getPreferredSize");
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        Dimension expResult = null;
        Dimension result = instance.getPreferredSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGauge method, of class ViewComponentGauge.
     */
    @Test
    public void testGetGauge() {
        System.out.println("getGauge");
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        AbstractGauge expResult = null;
        AbstractGauge result = instance.getGauge();
        assertEquals(expResult, result);
    }

    /**
     * Test of addInputValueListener method, of class ViewComponentGauge.
     */
    @Test
    public void testAddInputValueListener() {
        System.out.println("addInputValueListener");
        ActionListener listenForButtonPress = null;
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        instance.addInputValueListener(listenForButtonPress);
    }

    /**
     * Test of getInputValue method, of class ViewComponentGauge.
     */
    @Test
    public void testGetInputValue() {
        System.out.println("getInputValue");
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        double expResult = 0.0;
        double result = instance.getInputValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getInputPanel method, of class ViewComponentGauge.
     */
    @Test
    public void testGetInputPanel() {
        System.out.println("getInputPanel");
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        JPanel expResult = null;
        JPanel result = instance.getInputPanel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxValue method, of class ViewComponentGauge.
     */
    @Test
    public void testSetMaxValue() {
        System.out.println("setMaxValue");
        double value = 0.0;
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        instance.setMaxValue(value);
    }

    /**
     * Test of getMaxValue method, of class ViewComponentGauge.
     */
    @Test
    public void testGetMaxValue() {
        System.out.println("getMaxValue");
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        double expResult = 0.0;
        double result = instance.getMaxValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setMinValue method, of class ViewComponentGauge.
     */
    @Test
    public void testSetMinValue() {
        System.out.println("setMinValue");
        double value = 0.0;
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        instance.setMinValue(value);
    }

    /**
     * Test of getMinValue method, of class ViewComponentGauge.
     */
    @Test
    public void testGetMinValue() {
        System.out.println("getMinValue");
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        double expResult = 0.0;
        double result = instance.getMinValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setTitle method, of class ViewComponentGauge.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        instance.setTitle(title);
    }

    /**
     * Test of getTitle method, of class ViewComponentGauge.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUnitString method, of class ViewComponentGauge.
     */
    @Test
    public void testSetUnitString() {
        System.out.println("setUnitString");
        String unit = "";
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        instance.setUnitString(unit);
    }

    /**
     * Test of getUnitString method, of class ViewComponentGauge.
     */
    @Test
    public void testGetUnitString() {
        System.out.println("getUnitString");
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        String expResult = "";
        String result = instance.getUnitString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLookAndFeel method, of class ViewComponentGauge.
     */
    @Test
    public void testSetLookAndFeel() {
        System.out.println("setLookAndFeel");
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        instance.setLookAndFeel();
    }

    /**
     * Test of toggleInputPanel method, of class ViewComponentGauge.
     */
    @Test
    public void testToggleInputPanel() {
        System.out.println("toggleInputPanel");
        ViewComponentGauge instance = new ViewComponentGaugeImpl();
        instance.toggleInputPanel();
    }

    public class ViewComponentGaugeImpl extends ViewComponentGauge {

        @Override
        public void setValueAnimated(double value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
