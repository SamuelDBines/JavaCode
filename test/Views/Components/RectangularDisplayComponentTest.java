/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Components;

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
public class RectangularDisplayComponentTest {
    
    public RectangularDisplayComponentTest() {
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
     * Test of getPreferredSize method, of class RectangularDisplayComponent.
     */
    @Test
    public void testGetPreferredSize() {
        System.out.println("getPreferredSize");
        RectangularDisplayComponent instance = null;
        Dimension expResult = null;
        Dimension result = instance.getPreferredSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValueAnimated method, of class RectangularDisplayComponent.
     */
    @Test
    public void testSetValueAnimated() {
        System.out.println("setValueAnimated");
        double value = 0.0;
        RectangularDisplayComponent instance = null;
        instance.setValueAnimated(value);
    }
    
}
