/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

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
public class ConstantGaugesIT {
    
    public ConstantGaugesIT() {
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
     * Test of values method, of class ConstantGauges.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        ConstantGauges[] expResult = null;
        ConstantGauges[] result = ConstantGauges.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of valueOf method, of class ConstantGauges.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        ConstantGauges expResult = null;
        ConstantGauges result = ConstantGauges.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
