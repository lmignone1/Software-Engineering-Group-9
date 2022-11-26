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
 * @author loren
 */
public class ConcreteShapeEllipsesTest {
    private ConcreteShapeEllipses instance;
    private JFXPanel panel = new JFXPanel();
    private double[] vect = null;
    private double[] vect2 = null;
    private List<ColorPicker> listColor = null;
    
    public ConcreteShapeEllipsesTest() {
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
            assertNotEquals(currentColor, instance.getLineColor());
            assertEquals(color,instance.getLineColor());
        } catch (AssertionError ex) {
            fail("The setLineColor failed");
        }
    }
    
    /**
    * Test2 of setLineColor method, of class ConcreteShapeEllipses.
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
     * Test of setFillColor method, of class ConcreteShapeEllipses.
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
    * Test2 of setFillColor method, of class ConcreteShapeEllipses.
    */
    
    @Test
    public void testSetFillColor2(){
        
        System.out.println("testSetFillColor2");
        
        List<ColorPicker> listColorDefault = new ArrayList<>();
        
        for(int i = 0;i < 8; i++){
            listColorDefault.add(instance.getLineColor());
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
     * Test of setCenter method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testSetCenter() {
        System.out.println("setCenter");
        double currentCenterX = instance.getCenterX();
        double currentCenterY = instance.getCenterY();
        double[] centerX = vect;
        double[] centerY = vect2;
        for(int i = 0; i < centerX.length; i++) {
            instance.setCenter(centerX[i], centerY[i]);
            try {
                assertNotEquals(currentCenterX, instance.getCenterX());
                assertNotEquals(currentCenterY, instance.getCenterY());
                assertEquals(centerX[i], instance.getCenterX(), 0);
                assertEquals(centerY[i], instance.getCenterY(), 0);
            } catch (AssertionError ex) {
                fail("The setCenter failed");
            }
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
           assertEquals(150.0, instance.getRadiusX(), 0);
           assertEquals(90.0, instance.getRadiusY(), 0);
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
        double[] expResult = vect;
        for(int i = 0; i < expResult.length; i++) {
            instance.setCenter(expResult[i], 0.0);
            double result = instance.getCenterX();
            try {
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            } catch (AssertionError ex) {
                fail("The getCenterX failed");
            }
        }
    }

    /**
     * Test of getCenterY method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetCenterY() {
        System.out.println("getCenterY");
        double[] expResult = vect;
        for(int i = 0; i < expResult.length; i++) {
            instance.setCenter(0.0, expResult[i]);
            double result = instance.getCenterY();
            try {
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            } catch (AssertionError ex) {
                fail("The getCenterY failed");
            }
        }
    }

    /**
     * Test of getRadiusX method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetRadiusX() {
        System.out.println("getRadiusX");
        instance.setRadius();
        double expResult = 150.0;
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
        double expResult = 90.0;
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
     * Test of getFillColor method, of class ConcreteShapeEllipses.
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
     * Test of setGraphicsContext method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testSetGraphicsContext() {
        System.out.println("setGraphicsContext");
        Canvas drawingCanvas = new Canvas(1400, 1000);
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        instance.setGraphicsContext(gc);
        try {
            assertNotEquals(null, instance.getGraphicsContext());
            assertEquals(gc, instance.getGraphicsContext());
        } catch (AssertionError ex) {
            fail("The setGraphicsContext failed");
        }
    }
    
    @Test
    public void testGetGraphicsContext() {
        System.out.println("getGraphicsContext");
        Canvas drawingCanvas = new Canvas(1400, 1000);
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
     * Test of drawShape method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testDrawShape() {
        System.out.println("drawShape");
        Canvas drawingCanvas = new Canvas(1400, 1000);
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        Canvas expCanvas = new Canvas(1400, 1000);
        GraphicsContext expGC = expCanvas.getGraphicsContext2D();
        double[] centerX = vect;
        double[] centerY = vect2;
        instance.setGraphicsContext(gc);
        instance.setRadius();
        expGC.setLineWidth(3);
        double w = 150.0;
        double h = 90.0;
        Iterator<ColorPicker> it = listColor.iterator();
   
        for(int i = 0; i < vect.length; i++) {
            instance.setCenter(centerX[i], centerY[i]);
            if (!it.hasNext()) {
                it = listColor.iterator();
            }
            ColorPicker color = it.next();
            instance.setLineColor(color);
            instance.setFillColor(color);
            instance.drawShape();
            GraphicsContext instanceGC = instance.getGraphicsContext();
            expGC.setStroke(color.getValue());
            double x = centerX[i] - w/2;
            double y = centerY[i] - h/2;
            expGC.setFill(color.getValue());
            expGC.strokeOval(x, y, w, h);
            expGC.fillOval(x, y, w, h);
            try {
                assertEquals(expGC.getStroke(), instanceGC.getStroke());
                assertEquals(expGC.getLineWidth(), instanceGC.getLineWidth(), 0);
                assertEquals(expGC.getFill(), instanceGC.getFill());
                assertEquals(x, instance.getCenterX(), 0);
                assertEquals(y, instance.getCenterY(), 0);
                assertEquals(w, instance.getRadiusX(), 0);
                assertEquals(h, instance.getRadiusY(), 0);
            } catch (AssertionError ex){
                fail("The drawShape failed");
            }
        }
    }
    
}
