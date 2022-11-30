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
 * @author Acer
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
     * Test of setFillColor method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testSetFillColor() {
       System.out.println("testSetFillColor");
        
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
            fail("The setLineColor failed");
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
     * Test of setXY method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testSetXY() {
        double currentX=instance.getX();
        double currentY=instance.getY();
        double[] X= vect;
        double[] Y= vect2;
        
        try {
            for(int i=0;i<vect.length;i++){
            instance.setX(X[i]);
            instance.setY(Y[i]);
            assertNotEquals(currentX, instance.getX());
            assertNotEquals(currentY, instance.getY());
            assertEquals(X[i], instance.getX(),0);
            assertEquals(Y[i], instance.getY(),0);
            }
        } catch (AssertionError ex) {
            fail("The setXY failed");
        }
    }

    /**
     * Test of getRadiusX method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetRadiusX() {
        System.out.println("getRadiusY");
        instance.setXY(129,-283);
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
        instance.setXY(560,-123);
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
     * Test of draw method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testDraw() {
        System.out.println("drawShape");
        Canvas drawingCanvas = new Canvas(1400, 1000);
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        Canvas expCanvas = new Canvas(1400, 1000);
        GraphicsContext expGC = expCanvas.getGraphicsContext2D();
        double[] X = vect;
        double[] Y = vect2;
        instance.setGraphicsContext(gc);
        
        expGC.setLineWidth(3);
        double w = 150.0;
        double h = 90.0;
        Iterator<ColorPicker> it = listColor.iterator();
   
        for(int i = 0; i < vect.length; i++) {
            instance.setXY(X[i],Y[i]);
            if (!it.hasNext()) {
                it = listColor.iterator();
            }
            ColorPicker color = it.next();
            instance.setLineColor(color);
            instance.setFillColor(color);
            instance.draw();
            GraphicsContext instanceGC = instance.getGraphicsContext();
            expGC.setStroke(color.getValue());
            double x = X[i] - w/2;
            double y = Y[i] - h/2;
            expGC.setFill(color.getValue());
            expGC.strokeOval(x, y, w, h);
            expGC.fillOval(x, y, w, h);
            try {
                assertEquals(expGC.getStroke(), instanceGC.getStroke());
                assertEquals(expGC.getLineWidth(), instanceGC.getLineWidth(), 0);
                assertEquals(expGC.getFill(), instanceGC.getFill());
                assertEquals(x, instance.getX(), 0);
                assertEquals(y, instance.getY(), 0);
                assertEquals(w, instance.getRadiusX(), 0);
                assertEquals(h, instance.getRadiusY(), 0);
            } catch (AssertionError ex){
                fail("The drawShape failed");
            }
        }
    }
    
}
