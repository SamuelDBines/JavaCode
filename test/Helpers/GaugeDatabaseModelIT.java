/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Models.IModel;
import java.util.Map;
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
public class GaugeDatabaseModelIT {
    
    public GaugeDatabaseModelIT() {
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
     * Test of getInstance method, of class GaugeDatabaseModel.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        GaugeDatabaseModel expResult = null;
        GaugeDatabaseModel result = GaugeDatabaseModel.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addModel method, of class GaugeDatabaseModel.
     */
    @Test
    public void testAddModel() {
        System.out.println("addModel");
        ConstantGauges gauge = null;
        IModel model = null;
        GaugeDatabaseModel.addModel(gauge, model);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of updateModel method, of class GaugeDatabaseModel.
     */
    @Test
    public void testUpdateModel() {
        System.out.println("updateModel");
        ConstantGauges gauge = null;
        double value = 0.0;
        GaugeDatabaseModel.updateModel(gauge, value);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDatabase method, of class GaugeDatabaseModel.
     */
    @Test
    public void testGetDatabase() {
        System.out.println("getDatabase");
        Map expResult = null;
        Map result = GaugeDatabaseModel.getDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
