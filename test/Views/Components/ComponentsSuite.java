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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Sam
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Views.Components.RadarGaugeComponentTest.class, Views.Components.AutomaticClockComponentTest.class, Views.Components.ViewComponentGaugeTest.class, Views.Components.ViewComponentGaugeFactoryTest.class, Views.Components.RadialCircleGaugeComponentTest.class, Views.Components.IViewComponentGaugeTest.class, Views.Components.RectangularDisplayComponentTest.class, Views.Components.CompassGaugeComponentTest.class, Views.Components.RadialSquareGaugeComponentTest.class, Views.Components.LinearGaugeComponentTest.class})
public class ComponentsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
