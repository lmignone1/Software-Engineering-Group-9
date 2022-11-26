/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Shapes;

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
public class ConcreteCreatorEllipseTest {
    private ConcreteCreatorEllipse instance;
    private JFXPanel panel = new JFXPanel();
    
    public ConcreteCreatorEllipseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ConcreteCreatorEllipse();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createShape method, of class ConcreteCreatorEllipse.
     */
    
    @Test
    public void testCreateShape() {
        System.out.println("createShape");
        ConcreteShapeEllipses expResult = new ConcreteShapeEllipses();
        ConcreteShapeEllipses result = instance.createShape();
        try {
            assertNotNull(result);
            assertEquals(expResult.getClass(), result.getClass());
        } catch (AssertionError ex) {
            fail("The createShape failed ");
        }
    }
    
}
