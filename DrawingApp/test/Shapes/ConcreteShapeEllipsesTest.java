/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Shapes;

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
 * @author loren
 */
public class ConcreteShapeEllipsesTest {
    private ConcreteShapeEllipses instance;
    private JFXPanel panel = new JFXPanel();
    
    public ConcreteShapeEllipsesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ConcreteShapeEllipses();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setLineColor method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testSetLineColor() {
        System.out.println("setLineColor");
        ColorPicker currentColor = instance.getLineColor();
        ColorPicker color = new ColorPicker(Color.BLUE);
        instance.setLineColor(color);
        try {
            assertNotEquals(currentColor, instance.getLineColor().getValue());
        } catch (AssertionError ex) {
            fail("The setLineColor failed");
        }
    }

    /**
     * Test of setFillColor method, of class ConcreteShapeEllipses.
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
     * Test of setCenter method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testSetCenter() {
        System.out.println("setCenter");
        double currentCenterX = instance.getCenterX();
        double currentCenterY = instance.getCenterY();
        double centerX = 134.1f;
        double centerY = 850.75f;
        instance.setCenter(centerX, centerY);
        try {
            assertNotEquals(currentCenterX, instance.getCenterX());
            assertNotEquals(currentCenterY, instance.getCenterY());
        } catch (AssertionError ex) {
            fail("The setCenter failed");
        }
    }

    /**
     * Test of setRadius method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testSetRadius() {
        System.out.println("setRadius");
        double currentRX = instance.getRadiusX();
        double currentRY = instance.getRadiusY();
        instance.setRadius();
        double rX = instance.getRadiusX();
        double rY = instance.getRadiusY();
        try {
           assertNotEquals(currentRX, rX);
           assertNotEquals(currentRY, rY);
        } catch (AssertionError ex) {
            fail("The setRadius failed");
        }
    }

    /**
     * Test of getCenterX method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetCenterX() {
        System.out.println("getCenterX");
        double expResult = -94.908f;
        instance.setCenter(expResult, 0.0f);
        double result = instance.getCenterX();
        try {
            assertNotNull(result);
            assertEquals(expResult, result, 0);
        }
        catch (AssertionError ex) {
            fail("The getCenterX failed");
        }
    }

    /**
     * Test of getCenterY method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetCenterY() {
        System.out.println("getCenterY");
        double expResult = -94.908f;
        instance.setCenter(0.0f, expResult);
        double result = instance.getCenterY();
        try {
            assertNotNull(result);
            assertEquals(expResult, result, 0);
        }
        catch (AssertionError ex) {
            fail("The getCenterY failed");
        }
    }

    /**
     * Test of getRadiusX method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetRadiusX() {
        System.out.println("getRadiusX");
        instance.setRadius();
        double expResult = 150.0f;
        double result = instance.getRadiusX();
        try {
            assertNotNull(result);
            assertEquals(expResult, result, 0);
        }
        catch (AssertionError ex) {
            fail("The getRadiusX failed");
        }
    }

    /**
     * Test of getRadiusY method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetRadiusY() {
        System.out.println("getRadiusY");
        instance.setRadius();
        double expResult = 90.0f;
        double result = instance.getRadiusY();
        try {
            assertNotNull(result);
            assertEquals(expResult, result, 0);
        }
        catch (AssertionError ex) {
            fail("The getRadiusY failed");
        }
    }

    /**
     * Test of getLineColor method, of class ConcreteShapeEllipses.
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
     * Test of getFillColor method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetFillColor() {
        System.out.println("getFillColor");
        ColorPicker expResult = new ColorPicker(Color.BLUE);
        instance.setFillColor(expResult);
        ColorPicker result = instance.getFillColor();
        try {
            assertNotNull(result);
            assertEquals(expResult.getValue(), result.getValue());
        }
        catch (AssertionError ex) {
            fail("The getFillColor failed");
        }
    }

    /**
     * Test of setGraphicsContext method, of class ConcreteShapeEllipses.
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
     * Test of drawShape method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testDrawShape() {
        System.out.println("drawShape");
        Canvas drawingCanvas = new Canvas(1500, 1500);
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        instance.setGraphicsContext(gc);
        instance.setCenter(120.0, 150.0);
        instance.setRadius();
        ColorPicker lineColor = new ColorPicker(Color.YELLOW);
        instance.setLineColor(lineColor);
        ColorPicker fillColor = new ColorPicker(Color.GREEN);
        instance.setFillColor(fillColor);
        instance.drawShape();
        GraphicsContext instanceGC = instance.getGraphicsContext();
        //GraphicsContext expResult = 
        try {
            assertEquals(lineColor, instanceGC.getStroke());
            
        } catch (AssertionError ex){
            fail("The drawShape failed");
        }
    }
    
}
