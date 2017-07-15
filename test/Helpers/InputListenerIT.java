/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Views.Components.ViewComponentGauge;
import java.awt.event.ActionEvent;
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
public class InputListenerIT {
    
    public InputListenerIT() {
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
     * Test of actionPerformed method, of class InputListener.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        InputListener instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of startThread method, of class InputListener.
     */
    @Test
    public void testStartThread() {
        System.out.println("startThread");
        double value = 0.0;
        InputListener instance = null;
        instance.startThread(value);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toggleRandom method, of class InputListener.
     */
    @Test
    public void testToggleRandom() {
        System.out.println("toggleRandom");
        InputListener instance = null;
        instance.toggleRandom();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getViewComponenent method, of class InputListener.
     */
    @Test
    public void testGetViewComponenent() {
        System.out.println("getViewComponenent");
        InputListener instance = null;
        ViewComponentGauge expResult = null;
        ViewComponentGauge result = instance.getViewComponenent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of reset method, of class InputListener.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        InputListener instance = null;
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
