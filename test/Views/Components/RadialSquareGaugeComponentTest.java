/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Components;

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
public class RadialSquareGaugeComponentTest {
    
    public RadialSquareGaugeComponentTest() {
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
     * Test of setValueAnimated method, of class RadialSquareGaugeComponent.
     */
    @Test
    public void testSetValueAnimated() {
        System.out.println("setValueAnimated");
        double value = 0.0;
        RadialSquareGaugeComponent instance = null;
        instance.setValueAnimated(value);
    }

    /**
     * Test of setLookAndFeel method, of class RadialSquareGaugeComponent.
     */
    @Test
    public void testSetLookAndFeel() {
        System.out.println("setLookAndFeel");
        RadialSquareGaugeComponent instance = null;
        instance.setLookAndFeel();
    }
    
}
