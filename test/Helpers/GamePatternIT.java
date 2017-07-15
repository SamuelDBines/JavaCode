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
public class GamePatternIT {
    
    public GamePatternIT() {
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
     * Test of contact method, of class GamePattern.
     */
    @Test
    public void testContact() {
        System.out.println("contact");
        GamePattern instance = null;
        boolean expResult = false;
        boolean result = instance.contact();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of onRadar method, of class GamePattern.
     */
    @Test
    public void testOnRadar() {
        System.out.println("onRadar");
        GamePattern instance = null;
        boolean expResult = false;
        boolean result = instance.onRadar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of move method, of class GamePattern.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        GamePattern instance = null;
        instance.move();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of movePoi method, of class GamePattern.
     */
    @Test
    public void testMovePoi() {
        System.out.println("movePoi");
        int move = 0;
        GamePattern instance = null;
        instance.movePoi(move);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
