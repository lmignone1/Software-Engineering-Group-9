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
 * @author Acer
 */
public class ConcreteShapeLinesTest {
    private ConcreteShapeLines instance;
    private JFXPanel panel = new JFXPanel();
    
    public ConcreteShapeLinesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    instance = new ConcreteShapeLines();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setGraphicsContext method, of class ConcreteShapeLines.
     */
    @Test
    public void testSetGraphicsContext() {
        System.out.println("setGraphicsContext");
        GraphicsContext graphicsContext = null;
        ConcreteShapeLines instance = new ConcreteShapeLines();
        instance.setGraphicsContext(graphicsContext);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGraphicsContext method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetGraphicsContext() {
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
     * Test of setLineColor method, of class ConcreteShapeLines.
     */
    @Test
    public void testSetLineColor() {
       System.out.println("setLineColor");
        ColorPicker currentColor = instance.getLineColor();
        ColorPicker color = new ColorPicker(Color.BLUE);
        instance.setLineColor(color);
        try {
            assertNotEquals(currentColor, instance.getLineColor().getValue());
            assertEquals(color, instance.getLineColor());
        } catch (AssertionError ex) {
            fail("The setLineColor failed");
        }

    }
    
    /**
    * Test2 of setLineColor method, of class ConcreteShapeEllipses.
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
     * Test of setStart method, of class ConcreteShapeLines.
     */
    
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        double currentstartX=instance.getStartX();
        double currentstartY=instance.getStartY();
        double startX= 134.23;
        double startY= 231.23;
        instance.setStart(startX, startY);
        try {
            assertNotEquals(currentstartX, instance.getStartX());
            assertNotEquals(currentstartY, instance.getStartY());
        } catch (AssertionError ex) {
            fail("The setCenter failed");
        }
    }

    /**
     * Test of getStartX method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetStartX() {
        System.out.println("getStartX");
        ConcreteShapeLines instance = new ConcreteShapeLines();
        double expResult = 0.0;
        double result = instance.getStartX();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartY method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetStartY() {
        System.out.println("getStartY");
        ConcreteShapeLines instance = new ConcreteShapeLines();
        double expResult = 0.0;
        double result = instance.getStartY();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndX method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetEndX() {
        System.out.println("getEndX");
        ConcreteShapeLines instance = new ConcreteShapeLines();
        double expResult = 0.0;
        double result = instance.getEndX();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndY method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetEndY() {
        System.out.println("getEndY");
        ConcreteShapeLines instance = new ConcreteShapeLines();
        double expResult = 0.0;
        double result = instance.getEndY();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLineColor method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetLineColor() {
         System.out.println("getLineColor");
        ColorPicker expResult = new ColorPicker(Color.BLUE);
        instance.setLineColor(expResult);
        ColorPicker result = instance.getLineColor();
        try {
            assertNotNull(result);
            assertEquals(expResult.getValue(), result.getValue());
        }
        catch (AssertionError ex) {
            fail("The getLineColor failed");
        }
    }

    /**
     * Test of drawShape method, of class ConcreteShapeLines.
     */
    @Test
    public void testDrawShape() {
        System.out.println("drawShape");
        ConcreteShapeLines instance = new ConcreteShapeLines();
        instance.drawShape();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void testSetFillColor() {
        instance.setFillColor(new ColorPicker(Color.CHOCOLATE));
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void testGetFillColor() {
        ColorPicker color = instance.getFillColor();
    }
}
