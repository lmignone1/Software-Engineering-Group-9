/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.DoubleStream;
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
    private double[] vect = null;
    private double[] vect2 = null;
    private List<ColorPicker> listColor = null;
    
    public ConcreteShapeRectanglesTest() {
        vect = new double[100];
        vect2 = new double[100];
        Random r = new Random();
        DoubleStream stream = r.doubles(-999.999, 999.999);
        int count = 0;
        PrimitiveIterator.OfDouble it = stream.iterator();
        while(count < 2*vect.length && it.hasNext()) {
            if (count < vect.length) {
                vect[count] = it.nextDouble();
            }
            else {
                vect2[count-vect.length] = it.nextDouble();
            }
            count++;
        }
        
        listColor = new ArrayList<>();
        
        ColorPicker colorPickerWhite = new ColorPicker(Color.WHITE);
        ColorPicker colorPickerRed = new ColorPicker(Color.RED);
        ColorPicker colorPickerBlue = new ColorPicker(Color.BLUE);
        ColorPicker colorPickerYellow = new ColorPicker(Color.YELLOW);
        ColorPicker colorPickerOrange = new ColorPicker(Color.ORANGE);
        ColorPicker colorPickerGreen = new ColorPicker(Color.GREEN);
        ColorPicker colorPickerPurple = new ColorPicker(Color.PURPLE);
        ColorPicker colorPickerBlack = new ColorPicker(Color.BLACK);
        
        listColor.add(colorPickerWhite);
        listColor.add(colorPickerRed); 
        listColor.add(colorPickerBlue);
        listColor.add(colorPickerYellow);
        listColor.add(colorPickerOrange);
        listColor.add(colorPickerGreen);
        listColor.add(colorPickerPurple);
        listColor.add(colorPickerBlack);

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
            assertEquals(gc,instance.getGraphicsContext());
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
        
        for(int i = 0; i < 8; i++){
            
            listColorDefault.add(instance.getFillColor());
        }        

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
        double currentCenterX = instance.getStartX();
        double currentCenterY = instance.getStartY();
        double[] startX = vect;
        double[] startY = vect2;
        for(int i = 0; i < startX.length; i++) {
            instance.setStart(startX[i], startY[i]);
            try {
                assertNotEquals(currentCenterX, instance.getStartX());
                assertNotEquals(currentCenterY, instance.getStartY());
                assertEquals(startX[i], instance.getStartX(), 0);
                assertEquals(startY[i], instance.getStartY(), 0);
            } catch (AssertionError ex) {
                fail("The setStart failed");
            }
        } 
    }

    /**
     * Test of getStartX method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetStartX() {
        System.out.println("getStartX");
        double[] expResult = vect;
        
        for(int i = 0; i < expResult.length; i++){
           instance.setStart(expResult[i], 0.0);
           double result = instance.getStartX();
        
            try {
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            }
            catch (AssertionError ex) {
                fail("The getStartX failed");
            }
        } 
    }

    /**
     * Test of getStartY method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetStartY() {
        System.out.println("getStartY");
        double[] expResult = vect2;
        
        for(int i = 0; i < expResult.length; i++){
           instance.setStart(0.0 , expResult[i]);
           double result = instance.getStartY();
        
            try {
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            }
            catch (AssertionError ex) {
                fail("The getStartY failed");
            }
        } 
    }

    /**
     * Test of setWidth method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        double currentWidth = instance.getWidth();

        instance.setWidth();
        double width = instance.getWidth();

        try {
           assertNotEquals(currentWidth, width);
           assertEquals(100, instance.getWidth(), 0);
        } catch (AssertionError ex) {
            fail("The setWidth failed");
        }
    }

    /**
     * Test of setHeight method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testSetHeight() {
        System.out.println("SetHeight");
        double currentHeight = instance.getHeight();

        instance.setHeight();
        double height = instance.getHeight();

        try {
           assertNotEquals(currentHeight, height);
           assertEquals(50, instance.getHeight(), 0);
        } catch (AssertionError ex) {
            fail("The SetHeight failed");
        }
    }

    /**
     * Test of getX method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetX() {
        System.out.println("GetX");
        double[] expResults = vect;
        
        for(int i = 0; i < expResults.length; i++){
           instance.setStart(expResults[i], 0.0);
           double expResult = expResults[i] - 100/2;
           double result = instance.getX();
        
            try {
                assertNotNull(result);
                assertEquals(expResult, result, 0);
            }
            catch (AssertionError ex) {
                fail("The GetX failed");
            }
        }
    }

    /**
     * Test of getY method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetY() {
        System.out.println("GetY");
        double[] expResults = vect2;
        
        for(int i = 0; i < expResults.length; i++){
           instance.setStart(0.0, expResults[i]);
           double expResult = expResults[i] - 50/2;
           double result = instance.getY();
        
            try {
                assertNotNull(result);
                assertEquals(expResult, result, 0);
            }
            catch (AssertionError ex) {
                fail("The GetY failed");
            }
        }
    }

    /**
     * Test of getWidth method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetWidth() {
        System.out.println("GetWidth");
        instance.setWidth();
        double expResult = 100;
        double result = instance.getWidth();
        try {
            assertNotNull(result);
            assertEquals(expResult, result, 0);
        }
        catch (AssertionError ex) {
            fail("The GetWidth failed");
        }
    }

    /**
     * Test of getHeight method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetHeight() {
        System.out.println("GetHeight");
        instance.setHeight();
        double expResult = 50;
        double result = instance.getHeight();
        try {
            assertNotNull(result);
            assertEquals(expResult, result, 0);
        }
        catch (AssertionError ex) {
            fail("The GetHeight failed");
        }
    }

    /**
     * Test of getLineColor method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetLineColor() {
       System.out.println("getLineColor"); 
        try {
            for(int i = 0;i < listColor.size(); i++){
                ColorPicker expResult = listColor.get(i);
                instance.setLineColor(expResult);
                ColorPicker result = instance.getLineColor();
                
                assertNotNull(result);
                assertEquals(expResult, result);
            }
        }
        catch (AssertionError ex) {
            fail("The getLineColor failed");
        }
    }

    /**
     * Test of getFillColor method, of class ConcreteShapeRectangles.
     */
    @Test
    public void testGetFillColor() {
       System.out.println("getFillColor"); 
        try {
            for(int i = 0;i < listColor.size(); i++){
                ColorPicker expResult = listColor.get(i);
                instance.setFillColor(expResult);
                ColorPicker result = instance.getFillColor();
                
                assertNotNull(result);
                assertEquals(expResult, result);
            }
        }
        catch (AssertionError ex) {
            fail("The getFillColor failed");
        }
    }

    /**
     * Test of drawShape method, of class ConcreteShapeRectangles.
     */
    
    @Test
    public void testDrawShape() {
        System.out.println("drawShape");
        Canvas drawingCanvas = new Canvas(1400, 1000);
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        Canvas expCanvas = new Canvas(1400, 1000);
        GraphicsContext expGC = expCanvas.getGraphicsContext2D();
        double[] startX = vect;
        double[] startY = vect2;
        instance.setGraphicsContext(gc);
        instance.setHeight();
        instance.setWidth();
        expGC.setLineWidth(2);
        double w = 100.0;
        double h = 50.0;
        Iterator<ColorPicker> it = listColor.iterator();
        
        for(int i = 0; i < startX.length; i++) {
            instance.setStart(startX[i], startY[i]);
            if (!it.hasNext()) {
                it = listColor.iterator();
            }
            ColorPicker color = it.next();
            instance.setLineColor(color);
            instance.setFillColor(color);
            instance.drawShape();
            GraphicsContext instanceGC = instance.getGraphicsContext();
            expGC.setStroke(color.getValue());
            double x = startX[i] - w/2;
            double y = startY[i] - h/2;
            expGC.setFill(color.getValue());
            expGC.strokeRect(x, y, w, h);
            expGC.fillRect(x, y, w, h);
            try {
                assertEquals(expGC.getStroke(), instanceGC.getStroke());
                assertEquals(expGC.getLineWidth(), instanceGC.getLineWidth(), 0);
                assertEquals(expGC.getFill(), instanceGC.getFill());
                assertEquals(x, instance.getX(), 0);
                assertEquals(y, instance.getY(), 0);
                assertEquals(w, instance.getWidth(), 0);
                assertEquals(h, instance.getHeight(), 0);
            } catch (AssertionError ex){
                fail("The drawShape failed");
            }
        }
    }
    
}
