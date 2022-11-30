/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Shapes;

import Factory.ConcreteCreatorRectangle;
import javafx.embed.swing.JFXPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author loren
 */
public class ConcreteCreatorRectangleTest {
    private ConcreteCreatorRectangle instance;
    private JFXPanel panel = new JFXPanel();
    
    public ConcreteCreatorRectangleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ConcreteCreatorRectangle();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createShape method, of class ConcreteCreatorRectangle.
     */
    @Test
    public void testCreateShape() {
        System.out.println("createShape");
        ConcreteShapeRectangles expResult = new ConcreteShapeRectangles();
        ConcreteShapeRectangles result = instance.createShape();
        try {
            assertNotNull(result);
            assertEquals(expResult.getClass(), result.getClass());
        } catch (AssertionError ex) {
            fail("The createShape failed ");
        }
    }
    
}
