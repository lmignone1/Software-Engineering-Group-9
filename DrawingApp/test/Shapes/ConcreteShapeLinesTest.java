/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Shapes;

import java.util.ArrayList;
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
 * @author Acer
 */
public class ConcreteShapeLinesTest {
    private ConcreteShapeLines instance;
    private JFXPanel panel = new JFXPanel();
    private double[] vect = null;
    private double[] vect2 = null;
    private List<ColorPicker> listColor = null;
    
    public ConcreteShapeLinesTest() {
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
        Canvas drawingCanvas = new Canvas(1400, 1000);
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
     * Test of getGraphicsContext method, of class ConcreteShapeLines.
     */
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
     * Test of setLineColor method, of class ConcreteShapeLines.
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
    * Test2 of setFillColor method, of class ConcreteShapeEllipses.
    */
    
    /**
     * Test of setStart method, of class ConcreteShapeLines.
     */
    
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        double currentstartX=instance.getStartX();
        double currentstartY=instance.getStartY();
        double[] startX= vect;
        double[] startY= vect2;
        
        try {
            for(int i=0;i<vect.length;i++){
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
     * Test of getStartX method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetStartX() {
       System.out.println("getStartX");
        double[] expResult = vect;
        try {
            for(int i = 0;i<vect.length;i++){
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
     * Test of getStartY method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetStartY() {
         System.out.println("getStartY");
        double[] expResult = vect;
        
        try {
            for(int i = 0;i<vect.length;i++){
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
     * Test of getEndX method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetEndX() {
         System.out.println("getEndX");
        double[] expResult = vect; 
        try {
            for(int i = 0;i<vect.length;i++){
        instance.setStart(expResult[i], 0.0);
        double result = instance.getEndX();
        assertNotNull(result);
        assertEquals(expResult[i], result, 0);
            }
        }
        catch (AssertionError ex) {
            fail("The getEndX failed");
        }
    }

    /**
     * Test of getEndY method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetEndY() {
       System.out.println("getEndY");
        double[] expResult = vect;
        
        try {
            for(int i = 0;i<vect.length;i++){
        instance.setStart(0.0,expResult[i]);
        double result = instance.getEndY();
        assertNotNull(result);
        assertEquals(expResult[i], result, 0);
            }
        }
        catch (AssertionError ex) {
            fail("The getEndY failed");
        }
    }

    /**
     * Test of getLineColor method, of class ConcreteShapeLines.
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
     * Test of drawShape method, of class ConcreteShapeLines.
     */
    @Test
    public void testDrawShape() {
        System.out.println("drawShape");
        Canvas drawingCanvas = new Canvas(1400, 1000);
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        instance.setGraphicsContext(gc);
        double[] startX= vect;
        double[] startY= vect2;
        
       ColorPicker colorPickerWhite = new ColorPicker(Color.WHITE);
       ColorPicker colorPickerRed = new ColorPicker(Color.RED);
       ColorPicker colorPickerBlue = new ColorPicker(Color.BLUE);
       ColorPicker colorPickerYellow = new ColorPicker(Color.YELLOW);
       ColorPicker colorPickerOrange = new ColorPicker(Color.ORANGE);
       ColorPicker colorPickerGreen = new ColorPicker(Color.GREEN);
       ColorPicker colorPickerPurple = new ColorPicker(Color.PURPLE);
       ColorPicker colorPickerBlack = new ColorPicker(Color.BLACK);
       ColorPicker colorPickerAzure = new ColorPicker(Color.AZURE);
       ColorPicker colorPickerBurlywood = new ColorPicker(Color.BURLYWOOD);
       List<ColorPicker> listColor = new ArrayList<>();
       
       listColor.add(colorPickerWhite);
       listColor.add(colorPickerRed); 
       listColor.add(colorPickerBlue);
       listColor.add(colorPickerYellow);
       listColor.add(colorPickerOrange);
       listColor.add(colorPickerGreen);
       listColor.add(colorPickerPurple);
       listColor.add(colorPickerBlack);
       listColor.add(colorPickerAzure);
       listColor.add(colorPickerBurlywood); 
       GraphicsContext instanceGC = instance.getGraphicsContext();
       Canvas expCanvas = new Canvas(1400, 1000);
       GraphicsContext expGC = expCanvas.getGraphicsContext2D();  
       for(int i=0;i<10;i++){
       instance.setLineColor(listColor.get(i)); 
       expGC.setStroke(listColor.get(i).getValue());
       } 
       try {
            for(int i=0;i<vect.length;i++){
        instance.setStart(startX[i], startY[i]);
                
        
        instance.drawShape();
        
       
        expGC.setLineWidth(2);
        expGC.strokeLine(instance.getStartX(), instance.getStartY(), instance.getEndX(), instance.getEndY());
       
            
            assertEquals(expGC.getStroke(), instanceGC.getStroke());
            assertEquals(expGC.getLineWidth(), instanceGC.getLineWidth(), 0);
            assertEquals(startX[i], instance.getStartX(), 0);
            assertEquals(startY[i], instance.getStartY(), 0);
            assertEquals(startX[i], instance.getEndX(), 0);
            assertEquals(startY[i], instance.getEndY(), 0);
            }
        } catch (AssertionError ex){
            fail("The drawShape failed");
        }
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
