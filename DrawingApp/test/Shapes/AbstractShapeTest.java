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
import javafx.geometry.Point2D;
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
public class AbstractShapeTest {

    private AbstractShapeImpl instance;
    private JFXPanel panel = new JFXPanel();
    private double[] vect = null;
    private double[] vect2 = null;
    private List<ColorPicker> listColor = null;
    private double[] degreesVect;
    private final int NUM = 10;
    
    public AbstractShapeTest() {
        vect = new double[100];
        vect2 = new double[100];
        degreesVect = new double[100];
        Random r = new Random();
        DoubleStream stream = r.doubles(-999.999, 999.999);
        int count = 0;
        PrimitiveIterator.OfDouble it = stream.iterator();

        while (count < 2 * vect.length && it.hasNext()) {
            if (count < vect.length) {
                vect[count] = it.nextDouble();
            } else {
                vect2[count - vect.length] = it.nextDouble();
            }
            count++;
        }

        count = 0;
        stream = r.doubles(-360.001, 360.001);
        it = stream.iterator();
        while (count < degreesVect.length && it.hasNext()) {
            degreesVect[count] = it.nextDouble();
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
        instance = new AbstractShapeImpl();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setLineColor method, of class AbstractShape.
     */
    @Test
    public void testSetLineColor() {
        System.out.println("testSetLineColor");
        try {
            for (int i = 0; i < listColor.size(); i++) {
                ColorPicker currentColor = instance.getLineColor();
                instance.setLineColor(listColor.get(i));
                assertNotEquals(currentColor, instance.getLineColor());
                assertEquals(listColor.get(i).getValue(), instance.getLineColor().getValue());
            }

        } catch (AssertionError ex) {
            fail("The setLineColor failed");
        }
    }

    /**
     * Test of getLineColor method, of class AbstractShape.
     */
    @Test
    public void testGetLineColor() {
        System.out.println("getLineColor");
        try {
            for (int i = 0; i < listColor.size(); i++) {
                ColorPicker expResult = listColor.get(i);
                instance.setLineColor(expResult);
                ColorPicker result = instance.getLineColor();
                assertNotNull(result);
                assertEquals(expResult.getValue(), result.getValue());
            }
        } catch (AssertionError ex) {
            fail("The getLineColor failed");
        }
    }

    /**
     * Test of setGraphicsContext method, of class AbstractShape.
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

    /**
     * Test of getGraphicsContext method, of class AbstractShape.
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
     * Test of setX method, of class AbstractShape.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        double[] x = vect;

        try {
            for (int i = 0; i < vect.length; i++) {
                double currentX = instance.getX();
                instance.setX(x[i]);
                assertNotEquals(currentX, instance.getX());
                assertEquals(x[i], instance.getX(), 0);
            }
        } catch (AssertionError ex) {
            fail("The setX failed");
        }
    }

    /**
     * Test of getX method, of class AbstractShape.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        double[] expResult = vect;
        try {
            for (int i = 0; i < vect.length; i++) {
                instance.setX(expResult[i]);
                double result = instance.getX();
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            }
        } catch (AssertionError ex) {
            fail("The getX failed");
        }
    }

    /**
     * Test of setY method, of class AbstractShape.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        double currentY = instance.getY();
        double[] y = vect;

        try {
            for (int i = 0; i < vect.length; i++) {
                instance.setY(y[i]);
                assertNotEquals(currentY, instance.getY());
                assertEquals(y[i], instance.getY(), 0);
            }
        } catch (AssertionError ex) {
            fail("The setY failed");
        }
    }

    /**
     * Test of getY method, of class AbstractShape.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        double[] expResult = vect;
        try {
            for (int i = 0; i < vect.length; i++) {
                instance.setY(expResult[i]);
                double result = instance.getY();
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            }
        } catch (AssertionError ex) {
            fail("The getY failed");
        }
    }

    /**
     * Test of getDegrees method, of class AbstractShape.
     */
    @Test
    public void testGetDegrees() {
        System.out.println("getDegrees");
        double[] expResult = degreesVect;
        try {
            for (int i = 0; i < degreesVect.length; i++) {
                instance.setDegrees(expResult[i]);
                double result = instance.getDegrees();
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            }
        } catch (AssertionError ex) {
            fail("The getDegrees failed");
        }
    }

    /**
     * Test of setDegrees method, of class AbstractShape.
     */
    @Test
    public void testSetDegrees() {
        System.out.println("setDegrees");
        double currentDegrees = instance.getDegrees();
        double[] deg = degreesVect;

        try {
            for (int i = 0; i < degreesVect.length; i++) {
                instance.setDegrees(deg[i]);
                assertNotEquals(currentDegrees, instance.getDegrees());
                assertEquals(deg[i], instance.getDegrees(), 0);
            }
        } catch (AssertionError ex) {
            fail("The setDegrees failed");
        }
    }

    /**
     * Test of toString method, of class AbstractShape.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Random r = new Random();
        for(int i = 0; i < NUM; i++){
            double x = vect[r.nextInt(vect.length)];
            double y = vect[r.nextInt(vect.length)];
            ColorPicker lineColor = listColor.get(r.nextInt(listColor.size()));
            double deg = degreesVect[r.nextInt(degreesVect.length)];
            String s = x + " " + y + " " + lineColor.getValue() + " " + deg;
            instance.setX(x);
            instance.setY(y);
            instance.setLineColor(lineColor);
            instance.setDegrees(deg);
            try {
                assertEquals(s, instance.toString());
            } catch (AssertionError ex){
                fail("The toString failed");
            } 
        }
    }

    public class AbstractShapeImpl extends AbstractShape {

        @Override
        public void setXY(double newX, double newY) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void draw() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public boolean containsPoint(double x, double y) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Point2D getPoint() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public String getType() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void setSizeX(double sizeX) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public double getSizeX() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

}
