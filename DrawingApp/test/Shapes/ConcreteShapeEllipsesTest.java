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
        while (count < 2 * vect.length && it.hasNext()) {
            if (count < vect.length) {
                vect[count] = it.nextDouble();
            } else {
                vect2[count - vect.length] = it.nextDouble();
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
        try {
            for (int i = 0; i < listColor.size(); i++) {
                ColorPicker currentColor = instance.getFillColor();
                instance.setFillColor(listColor.get(i));
                assertNotEquals(currentColor, instance.getFillColor());
                assertEquals(listColor.get(i).getValue(), instance.getFillColor().getValue());
            }

        } catch (AssertionError ex) {
            fail("The setFillColor failed");
        }
    }

    /**
     * Test of getFillColor method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetFillColor() {
        System.out.println("getFillColor");
        try {
            for (int i = 0; i < listColor.size(); i++) {
                ColorPicker expResult = listColor.get(i);
                instance.setFillColor(expResult);
                ColorPicker result = instance.getFillColor();
                assertNotNull(result);
                assertEquals(expResult.getValue(), result.getValue());
            }
        } catch (AssertionError ex) {
            fail("The getFillColor failed");
        }
    }

    /**
     * Test of setXY method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testSetXY() {
        System.out.println("setXY");
        double[] x = vect;
        double[] y = vect2;

        try {
            for (int i = 0; i < vect.length; i++) {
                double currentX = instance.getX();
                double currentY = instance.getY();
                instance.setXY(x[i], y[i]);
                assertNotEquals(currentX, instance.getX());
                assertNotEquals(currentY, instance.getY());
                assertEquals(x[i] - 150.0 / 2, instance.getX(), 0);
                assertEquals(y[i] - 90.0 / 2, instance.getY(), 0);
            }
        } catch (AssertionError ex) {
            fail("The setXY failed");
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
        instance.setGraphicsContext(gc);

        expGC.setLineWidth(3);
        double w = 150.0;
        double h = 90.0;
        Iterator<ColorPicker> it = listColor.iterator();

        for (int i = 0; i < vect.length; i++) {
            instance.setXY(vect[i], vect2[i]);
            if (!it.hasNext()) {
                it = listColor.iterator();
            }
            ColorPicker color = it.next();
            instance.setLineColor(color);
            instance.setFillColor(color);
            instance.draw();
            GraphicsContext instanceGC = instance.getGraphicsContext();
            expGC.setStroke(color.getValue());
            double x = vect[i] - w / 2;
            double y = vect2[i] - h / 2;
            expGC.setFill(color.getValue());
            expGC.strokeOval(x, y, w, h);
            expGC.fillOval(x, y, w, h);
            try {
                assertEquals(expGC.getStroke(), instanceGC.getStroke());
                assertEquals(expGC.getLineWidth(), instanceGC.getLineWidth(), 0);
                assertEquals(expGC.getFill(), instanceGC.getFill());
                assertEquals(x, instance.getX(), 0);
                assertEquals(y, instance.getY(), 0);
                assertEquals(w, instance.getSizeX(), 0);
                assertEquals(h, instance.getSizeY(), 0);
            } catch (AssertionError ex) {
                fail("The drawShape failed");
            }
        }
    }

    /**
     * Test of SetSizeX method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testSetSizeX() {
        System.out.println("setSizeX");
        double[] sizeX = vect;
        try {
            for (int i = 0; i < vect.length; i++) {
                double currentSizeX = instance.getSizeX();
                instance.setSizeX(sizeX[i]);
                assertNotEquals(currentSizeX, instance.getSizeX());
                assertEquals(sizeX[i], instance.getSizeX(), 0);
            }
        } catch (AssertionError ex) {
            fail("The setSizeX failed");
        }
    }

    /**
     * Test of getSizeX method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetSizeX() {
        System.out.println("getSizeX");
        double[] expResult = vect;
        try {
            for (int i = 0; i < vect.length; i++) {
                instance.setSizeX(expResult[i]);
                double result = instance.getSizeX();
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            }
        } catch (AssertionError ex) {
            fail("The getSizeX failed");
        }
    }

    /**
     * Test of SetSizeY method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testSetSizeY() {
        System.out.println("setSizeY");
        double[] sizeY = vect;
        try {
            for (int i = 0; i < vect.length; i++) {
                double currentSizeY = instance.getSizeY();
                instance.setSizeY(sizeY[i]);
                assertNotEquals(currentSizeY, instance.getSizeY());
                assertEquals(sizeY[i], instance.getSizeY(), 0);
            }
        } catch (AssertionError ex) {
            fail("The setSizeY failed");
        }
    }

    /**
     * Test of getSizeY method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetSizeY() {
        System.out.println("getSizeY");
        double[] expResult = vect;
        try {
            for (int i = 0; i < vect.length; i++) {
                instance.setSizeY(expResult[i]);
                double result = instance.getSizeY();
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            }
        } catch (AssertionError ex) {
            fail("The getSizeY failed");
        }
    }

    /**
     * Test of getType method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        try {
            assertNotNull(instance.getType());
            assertEquals("Ellipse", instance.getType());
        } catch (AssertionError ex) {
            fail("The getType failed");
        }
    }

    /**
     * Test of containsPoint method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testContainsPoint() {
        System.out.println("containsPoint");
        Random r = new Random();
        instance.setXY(vect[r.nextInt(vect.length)], vect[r.nextInt(vect.length)]);
        Point2D midPoint = instance.getPoint().midpoint(instance.getX() + instance.getSizeX(), instance.getY() + instance.getSizeY());
        try {
            assertTrue(instance.containsPoint(midPoint.getX(), midPoint.getY()));
            assertFalse(instance.containsPoint(10 * midPoint.getX(), 10 * midPoint.getY()));
        } catch (AssertionError ex) {
            fail("The containsPoint failed");
        }
    }

    /**
     * Test of getPoint method, of class ConcreteShapeEllipses.
     */
    @Test
    public void testGetPoint() {
        System.out.println("getPoint");
        for (int i = 0; i < vect.length; i++) {
            instance.setXY(vect[i], vect2[i]);
            Point2D expResult = new Point2D(vect[i] - 150.0 / 2, vect2[i] - 90.0 / 2);
            Point2D result = instance.getPoint();
            try {
                assertNotNull(result);
                assertEquals(expResult, result);
            } catch (AssertionError ex) {
                fail("The getPoint failed");
            }
        }
    }
}
