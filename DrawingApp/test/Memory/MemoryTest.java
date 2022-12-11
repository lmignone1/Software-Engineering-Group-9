/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Memory;

import Shapes.Shape;
import java.util.Stack;
import javafx.scene.control.ColorPicker;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Davide
 */
public class MemoryTest {
    
    public MemoryTest() {
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
     * Test of popStackShape method, of class Memory.
     */
    @Test
    public void testPopStackShape() {
        System.out.println("popStackShape");
        Memory instance = new Memory();
        Shape expResult = null;
        Shape result = instance.popStackShape();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of popStackDouble method, of class Memory.
     */
    @Test
    public void testPopStackDouble() {
        System.out.println("popStackDouble");
        Memory instance = new Memory();
        Double expResult = null;
        Double result = instance.popStackDouble();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of popStackColor method, of class Memory.
     */
    @Test
    public void testPopStackColor() {
        System.out.println("popStackColor");
        Memory instance = new Memory();
        ColorPicker expResult = null;
        ColorPicker result = instance.popStackColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStackShape method, of class Memory.
     */
    @Test
    public void testAddStackShape() {
        System.out.println("addStackShape");
        Shape selectedShape = null;
        Memory instance = new Memory();
        instance.addStackShape(selectedShape);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStackDouble method, of class Memory.
     */
    @Test
    public void testAddStackDouble() {
        System.out.println("addStackDouble");
        Double number = null;
        Memory instance = new Memory();
        instance.addStackDouble(number);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStackColor method, of class Memory.
     */
    @Test
    public void testAddStackColor() {
        System.out.println("addStackColor");
        ColorPicker color = null;
        Memory instance = new Memory();
        instance.addStackColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStackShape method, of class Memory.
     */
    @Test
    public void testGetStackShape() {
        System.out.println("getStackShape");
        Memory instance = new Memory();
        Stack<Shape> expResult = null;
        Stack<Shape> result = instance.getStackShape();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStackDouble method, of class Memory.
     */
    @Test
    public void testGetStackDouble() {
        System.out.println("getStackDouble");
        Memory instance = new Memory();
        Stack<Double> expResult = null;
        Stack<Double> result = instance.getStackDouble();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStackColor method, of class Memory.
     */
    @Test
    public void testGetStackColor() {
        System.out.println("getStackColor");
        Memory instance = new Memory();
        Stack<ColorPicker> expResult = null;
        Stack<ColorPicker> result = instance.getStackColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
