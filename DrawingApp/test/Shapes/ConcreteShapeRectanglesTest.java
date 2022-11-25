/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Shapes;

import java.util.ArrayList;
import java.util.List;
import javafx.embed.swing.JFXPanel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
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
public class ConcreteShapeRectanglesTest {
    
    private ConcreteShapeRectangles instance;
    private JFXPanel panel = new JFXPanel();
    
    public ConcreteShapeRectanglesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ConcreteShapeRectangles();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setGraphicsContext method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testSetGraphicsContext() {
        System.out.println("setGraphicsContext");
        Canvas drawingCanvas = new Canvas(1500, 1500);
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        instance.setGraphicsContext(gc);
        try {
            assertNotEquals(null, instance.getGraphicsContext());
        } catch (AssertionError ex) {
            fail("The setGraphicsContext failed");
        }
    }

    /**
     * Test of getGraphicsContext method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetGraphicsContext() {
        System.out.println("getGraphicsContext");
        Canvas drawingCanvas = new Canvas(1500, 1500);
        GraphicsContext expResult = drawingCanvas.getGraphicsContext2D();
        instance.setGraphicsContext(expResult);
        GraphicsContext result = instance.getGraphicsContext();
        try {
            assertNotNull(result);
            assertEquals(expResult, result);
        } catch (AssertionError ex) {
            fail("The getGraphicsContext failed");
        }
    }

    /**
     * Test of setLineColor method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testSetLineColor() {
        System.out.println("setLineColor");
        ColorPicker currentColor = instance.getLineColor();
        ColorPicker color = new ColorPicker(Color.BLUE);
        instance.setLineColor(color);
        try {
            assertNotEquals(currentColor, instance.getLineColor().getValue());
            assertEquals(color,instance.getLineColor());
        } catch (AssertionError ex) {
            fail("The setLineColor failed");
        }
    }
    
    /**
    * Test2 of setLineColor method, of class ConcreteShapeRectangles.
    */
    
    @Test
    public void testSetLineColor2(){
       
       ColorPicker colorPickerWhite = new ColorPicker(Color.WHITE);
       ColorPicker colorPickerRed = new ColorPicker(Color.RED);
       ColorPicker colorPickerBlue = new ColorPicker(Color.BLUE);
       ColorPicker colorPickerYellow = new ColorPicker(Color.YELLOW);
       ColorPicker colorPickerOrange = new ColorPicker(Color.ORANGE);
       ColorPicker colorPickerGreen = new ColorPicker(Color.GREEN);
       ColorPicker colorPickerPurple = new ColorPicker(Color.PURPLE);
       ColorPicker colorPickerBlack = new ColorPicker(Color.BLACK);
        
       List<ColorPicker> listColor = new ArrayList<>();
       
       listColor.add(colorPickerWhite);
       listColor.add(colorPickerRed); 
       listColor.add(colorPickerBlue);
       listColor.add(colorPickerYellow);
       listColor.add(colorPickerOrange);
       listColor.add(colorPickerGreen);
       listColor.add(colorPickerPurple);
       listColor.add(colorPickerBlack);
           
       try{
           
           for(int i = 0; i < listColor.size(); i++){
               instance.setLineColor(listColor.get(i));
               assertEquals(listColor.get(i),instance.getLineColor()); 
           }
           
       } catch (AssertionError ex){
            fail("The setLineColor2 failed");
       }
    }
    
    /**
     * Test of setFillColor method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testSetFillColor() {
        System.out.println("setFillColor");
        ColorPicker currentColor = instance.getFillColor();
        ColorPicker color = new ColorPicker(Color.BLUE);
        instance.setFillColor(color);
        try {
            assertNotEquals(currentColor, instance.getFillColor().getValue());
        } catch (AssertionError ex) {
            fail("The setFillColor failed");
        }
    }
    
    /**
    * Test2 of setFillColor method, of class ConcreteShapeRectangles.
    */
    
    @Test
    public void testSetFillColor2(){
       
       ColorPicker colorPickerWhite = new ColorPicker(Color.WHITE);
       ColorPicker colorPickerRed = new ColorPicker(Color.RED);
       ColorPicker colorPickerBlue = new ColorPicker(Color.BLUE);
       ColorPicker colorPickerYellow = new ColorPicker(Color.YELLOW);
       ColorPicker colorPickerOrange = new ColorPicker(Color.ORANGE);
       ColorPicker colorPickerGreen = new ColorPicker(Color.GREEN);
       ColorPicker colorPickerPurple = new ColorPicker(Color.PURPLE);
       ColorPicker colorPickerBlack = new ColorPicker(Color.BLACK);
        
       List<ColorPicker> listColor = new ArrayList<>();
       
       listColor.add(colorPickerWhite);
       listColor.add(colorPickerRed); 
       listColor.add(colorPickerBlue);
       listColor.add(colorPickerYellow);
       listColor.add(colorPickerOrange);
       listColor.add(colorPickerGreen);
       listColor.add(colorPickerPurple);
       listColor.add(colorPickerBlack);
           
       try{
           
           for(int i = 0; i < listColor.size(); i++){
               instance.setFillColor(listColor.get(i));
               assertEquals(listColor.get(i),instance.getFillColor()); 
           }
           
       } catch (AssertionError ex){
            fail("The setLineColor2 failed");
       }
    }
    
    
    /**
     * Test of setStart method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        double currentstartX = instance.getX();
        double currentstartY = instance.getY();
        double startX = 200;
        double startY = 100;
        instance.setStart(startX, startY);
        try {
            assertNotEquals(currentstartX, instance.getX());
            assertNotEquals(currentstartY, instance.getY());
        } catch (AssertionError ex) {
            fail("The setStart failed");
        }
    }

    /**
     * Test of setEnd method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testSetEnd() {
        System.out.println("setEnd");
        ConcreteShapeRectangles instance = new ConcreteShapeRectangles();
        instance.setEnd();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWidth method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        ConcreteShapeRectangles instance = new ConcreteShapeRectangles();
        instance.setWidth();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeight method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        ConcreteShapeRectangles instance = new ConcreteShapeRectangles();
        instance.setHeight();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        ConcreteShapeRectangles instance = new ConcreteShapeRectangles();
        double expResult = 0.0;
        double result = instance.getX();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        ConcreteShapeRectangles instance = new ConcreteShapeRectangles();
        double expResult = 0.0;
        double result = instance.getY();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        ConcreteShapeRectangles instance = new ConcreteShapeRectangles();
        double expResult = 0.0;
        double result = instance.getWidth();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        ConcreteShapeRectangles instance = new ConcreteShapeRectangles();
        double expResult = 0.0;
        double result = instance.getHeight();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLineColor method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetLineColor() {
        System.out.println("getLineColor");
        ConcreteShapeRectangles instance = new ConcreteShapeRectangles();
        ColorPicker expResult = null;
        ColorPicker result = instance.getLineColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFillColor method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetFillColor() {
        System.out.println("getFillColor");
        ConcreteShapeRectangles instance = new ConcreteShapeRectangles();
        ColorPicker expResult = null;
        ColorPicker result = instance.getFillColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawShape method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testDrawShape() {
        System.out.println("drawShape");
        ConcreteShapeRectangles instance = new ConcreteShapeRectangles();
        instance.drawShape();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
