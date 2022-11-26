/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
            assertNotEquals(currentColor, instance.getLineColor());
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
        
        System.out.println("testSetLineColor2");
        
        List<ColorPicker> listColorDefault = new ArrayList<>();
        
        for(int i = 0;i < 8; i++){
            listColorDefault.add(instance.getLineColor());
        }
       
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
               assertNotEquals(listColorDefault.get(i),instance.getLineColor()); 
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
            assertNotEquals(currentColor, instance.getFillColor());
            assertEquals(color,instance.getFillColor());
        } catch (AssertionError ex) {
            fail("The setFillColor failed");
        }
    }
    
    /**
    * Test2 of setFillColor method, of class ConcreteShapeRectangles.
    */
    
    @Test
    public void testSetFillColor2(){
        
        System.out.println("testSetFillColor2");
        
        List<ColorPicker> listColorDefault = new ArrayList<>();
        
        for(int i = 0;i < 8; i++){
            listColorDefault.add(instance.getLineColor());
        }
       
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
               assertNotEquals(listColorDefault.get(i),instance.getFillColor());
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
        double currentstartX = instance.getStartX();
        double currentstartY = instance.getStartY();
        double[] startX = new double[10];
        double[] startY = new double[10];
        Random random = new Random();
        double min = -999;
        double max = 999;
        for(int i = 0; i < 10; i++){
            startX[i] = random.nextInt((int) (max-min)) + min;
            startY[i] = random.nextInt((int) (max-min)) + min;
        }
        try {
            for(int i = 0; i < 10; i++){
                instance.setStart(startX[i], startY[i]);
                assertNotEquals(currentstartX, instance.getStartX());
                assertNotEquals(currentstartY, instance.getStartY());
                assertEquals(startX[i], instance.getStartX(),0);
                assertEquals(startY[i], instance.getStartY(),0);
            }
        } catch (AssertionError ex) {
            fail("The setStart failed");
        }
    }

    /**
     * Test of getStartX method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetStartX() {
       System.out.println("getStartX");
       double[] expResult = new double[10];
       Random random = new Random();
       double min = -999;
       double max = 999;
       for(int i = 0; i < 10; i++){
            expResult[i] = random.nextInt((int) (max-min)) + min;
        }
        
        try {
            for(int i = 0; i<10; i++){
                instance.setStart(expResult[i], 0.0);
                double result = instance.getStartX();
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            }
        }
        catch (AssertionError ex) {
            fail("The getStartX failed");
        }
    }

    /**
     * Test of getStartY method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetStartY() {
        System.out.println("getStartY");
        double[] expResult = new double[10];
        Random random = new Random();
        double min = -999;
        double max = 999;
        for(int i=0;i<10;i++){
        expResult[i]= random.nextInt((int) (max-min)) + min;
        }
        
        try {
            for(int i = 0;i<10;i++){
                instance.setStart(0.0,expResult[i]);
                double result = instance.getStartY();
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            }
        }
        catch (AssertionError ex) {
            fail("The getStartY failed");
        }
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
