/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Decorator;

import java.util.Random;
import javafx.embed.swing.JFXPanel;
import javafx.scene.canvas.Canvas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author artem
 */
public class ConcreteCanvasTest {
    private JFXPanel panel = new JFXPanel();
    private ConcreteCanvas instance;
    private Canvas canvas;
    private int gridSize;
    
    public ConcreteCanvasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        canvas = new Canvas();
        instance = new ConcreteCanvas(canvas);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCanvas method, of class ConcreteCanvas.
     */
    @Test
    public void testGetCanvas() {
        System.out.println("getCanvas");
        Canvas result = instance.getCanvas();
        try{
            assertNotEquals(null,result);
            assertEquals(canvas, result);
        }catch(AssertionError ex){
             fail("The GetCanvas failed");
        }
    }

    /**
     * Test of setGridSizeInput method, of class ConcreteCanvas.
     */
    @Test
    public void testSetGridSizeInput() {
        System.out.println("setGridSizeInput");
        Random r = new Random();
        int random;
        for(int i=0; i<10; i++){
            random = r.nextInt(999);
            int currentGridSizeInput = instance.getGridSizeInput();
            instance.setGridSizeInput(random);
            
            try{
                assertNotEquals(currentGridSizeInput,instance.getGridSizeInput());
                assertEquals(random, instance.getGridSizeInput());
            } catch(AssertionError ex) {
                fail("The GetGridSizeInput failed");
            }
        }
    }

    /**
     * Test of getGridSizeInput method, of class ConcreteCanvas.
     */
    @Test
    public void testGetGridSizeInput() {
        System.out.println("getGridSizeInput");
        Random r = new Random();
        int random;
        for(int i=0; i<10; i++){
            random = r.nextInt(999);
            System.out.println(random);
            int result = instance.getGridSizeInput();
            
            try{
                assertNotEquals(null,result);
                assertEquals(gridSize, result);
            } catch(AssertionError ex) {
                fail("The GetGridSizeInput failed");
            }
        }
    }
    
}
