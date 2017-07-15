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
public class ViewComponentGaugeFactoryTest {
    
    public ViewComponentGaugeFactoryTest() {
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
     * Test of getViewComponent method, of class ViewComponentGaugeFactory.
     */
    @Test
    public void testGetViewComponent() {
        System.out.println("getViewComponent");
        ViewComponentGaugeFactory.ViewComponentType componentType = null;
        double minValue = 0.0;
        double maxValue = 0.0;
        String title = "";
        String units = "";
        ViewComponentGaugeFactory instance = new ViewComponentGaugeFactory();
        ViewComponentGauge expResult = null;
        ViewComponentGauge result = instance.getViewComponent(componentType, minValue, maxValue, title, units);
        assertEquals(expResult, result);
    }
    
}
