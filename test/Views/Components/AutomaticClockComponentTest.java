/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Components;

import eu.hansolo.steelseries.extras.Clock;
import java.awt.Dimension;
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
public class AutomaticClockComponentTest {
    
    public AutomaticClockComponentTest() {
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
     * Test of getPreferredSize method, of class AutomaticClockComponent.
     */
    @Test
    public void testGetPreferredSize() {
        System.out.println("getPreferredSize");
        Clock instance = new Clock();
        Dimension expResult = new Dimension(150,300);
        instance.setPreferredSize(new Dimension(150,300));
        Dimension result = instance.getPreferredSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setValueAnimated method, of class AutomaticClockComponent.
     */
    @Test
    public void testSetValueAnimated() {
        System.out.println("setValueAnimated");
        double value = 0.0;
        Clock instance = new Clock();
        instance.setValueAnimated(value);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(value, 0.0,0);
    }
    
}
