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
 * @author Acer
 */
public class ConcreteShapeLinesTest {

    private ConcreteShapeLines instance;
    private JFXPanel panel = new JFXPanel();
    private double[] vect = null;
    private double[] vect2 = null;
    private List<ColorPicker> listColor = null;
    private double[] degreesVect;

    public ConcreteShapeLinesTest() {
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
        instance = new ConcreteShapeLines();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setXY method, of class ConcreteShapeLines.
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
                assertEquals(x[i] - 100.0 / 2, instance.getX(), 0);
                assertEquals(y[i], instance.getY(), 0);
            }
        } catch (AssertionError ex) {
            fail("The setXY failed");
        }
    }

    /**
     * Test of draw method, of class ConcreteShapeLines.
     */
    @Test
    public void testDraw() {
        System.out.println("drawShape");
        Random r = new Random();
        Canvas drawingCanvas = new Canvas(1400, 1000);
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        Canvas expCanvas = new Canvas(1400, 1000);
        GraphicsContext expGC = expCanvas.getGraphicsContext2D();
        double[] startX = vect;
        double[] startY = vect2;
        instance.setGraphicsContext(gc);
        expGC.setLineWidth(2);
        double len = 100.0;
        Iterator<ColorPicker> it = listColor.iterator();
        double deg = degreesVect[r.nextInt(degreesVect.length)];
        instance.setDegrees(deg);
        for (int i = 0; i < vect.length; i++) {
            instance.setXY(startX[i], startY[i]);
            if (!it.hasNext()) {
                it = listColor.iterator();
            }
            ColorPicker color = it.next();
            instance.setLineColor(color);
            instance.draw();
            GraphicsContext instanceGC = instance.getGraphicsContext();
            expGC.setStroke(color.getValue());
            double x1 = startX[i] - len / 2;
            double y1 = startY[i];
            double x2 = x1 + len;
            double y2 = startY[i];
            expGC.strokeLine(x1, y1, x2, y2);

            try {
                assertEquals(expGC.getStroke(), instanceGC.getStroke());
                assertEquals(expGC.getLineWidth(), instanceGC.getLineWidth(), 0);
                assertEquals(deg, instance.getDegrees(), 0);
                assertEquals(x1, instance.getX(), 0);
                assertEquals(y1, instance.getY(), 0);
                assertEquals(x2, instance.getEndX(), 0);
                assertEquals(y2, instance.getEndY(), 0);
            } catch (AssertionError ex) {
                fail("The drawShape failed");
            }
        }
    }

    /**
     * Test of setEndX method, of class ConcreteShapeLines.
     */
    @Test
    public void testsetEndX() {
        System.out.println("setEndX");
        for (int i = 0; i < vect.length; i++) {
            double currentEndX = instance.getEndX();
            instance.setEndX(vect[i]);
            assertNotEquals(currentEndX, instance.getEndX());
            assertEquals(vect[i], instance.getEndX(), 0);
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
            for (int i = 0; i < vect.length; i++) {
                instance.setEndX(expResult[i]);
                double result = instance.getEndX();
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            }
        } catch (AssertionError ex) {
            fail("The getEndX failed");
        }
    }

    /**
     * Test of setEndY method, of class ConcreteShapeLines.
     */
    @Test
    public void testsetEndY() {
        System.out.println("setEndY");
        for (int i = 0; i < vect.length; i++) {
            double currentEndY = instance.getEndY();
            instance.setEndY(vect[i]);
            assertNotEquals(currentEndY, instance.getEndY());
            assertEquals(vect[i], instance.getEndY(), 0);
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
            for (int i = 0; i < vect.length; i++) {
                instance.setEndY(expResult[i]);
                double result = instance.getEndY();
                assertNotNull(result);
                assertEquals(expResult[i], result, 0);
            }
        } catch (AssertionError ex) {
            fail("The getEndY failed");
        }
    }

    /**
     * Test of getType method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        try {
            assertNotNull(instance.getType());
            assertEquals("Line", instance.getType());
        } catch (AssertionError ex) {
            fail("The getType failed");
        }
    }

    /**
     * Test of containsPoint method, of class ConcreteShapeLines.
     */
    @Test
    public void testContainsPoint() {
        System.out.println("containsPoint");
        Random r = new Random();
        instance.setXY(vect[r.nextInt(vect.length)], vect[r.nextInt(vect.length)]);
        Point2D midPoint = instance.getPoint().midpoint(instance.getEndX(), instance.getEndY());
        try {
            assertTrue(instance.containsPoint(midPoint.getX(), midPoint.getY()));
            assertFalse(instance.containsPoint(10 * midPoint.getX(), 10 * midPoint.getY()));
        } catch (AssertionError ex) {
            fail("The containsPoint failed");
        }
    }

    /**
     * Test of getPoint method, of class ConcreteShapeLines.
     */
    @Test
    public void testGetPoint() {
        System.out.println("getPoint");
        for (int i = 0; i < vect.length; i++) {
            instance.setXY(vect[i], vect2[i]);
            Point2D expResult = new Point2D(vect[i] - 100.0 / 2, vect2[i]);
            Point2D result = instance.getPoint();
            try {
                assertNotNull(result);
                assertEquals(expResult, result);
            } catch (AssertionError ex) {
                fail("The getPoint failed");
            }
        }
    }

    /**
     * Test of SetSizeX method, of class ConcreteShapeLines.
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
     * Test of getSizeX method, of class ConcreteShapeLines.
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
     * Test of getFillColor method, of class ConcreteShapeLines.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testGetFilLColor() {
        System.out.println("getFillColor");
        instance.getFillColor();
    }

    /**
     * Test of setFillColor method, of class ConcreteShapeLines.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testSetFillColor() {
        System.out.println("setFillColor");
        instance.setFillColor(new ColorPicker(Color.CHOCOLATE));
    }

    /**
     * Test of setSizeY method, of class ConcreteShapeLines.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testSetSizeY() {
        System.out.println("setSizeY");
        instance.setSizeY(234.0);
    }

    /**
     * Test of getSizeY method, of class ConcreteShapeLines.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testGetSizeY() {
        System.out.println("getSizeY");
        instance.getSizeY();
    }

    /**
     * Test of toString method, of class ConcreteShapeLines.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Random r = new Random();
        double x = vect[r.nextInt(vect.length)];
        double y = vect[r.nextInt(vect.length)];
        ColorPicker lineColor = listColor.get(r.nextInt(listColor.size()));
        ColorPicker fillColor = listColor.get(r.nextInt(listColor.size()));
        double sizeX = vect[r.nextInt(vect.length)];
        double sizeY = vect[r.nextInt(vect.length)];
        double deg = degreesVect[r.nextInt(degreesVect.length)];

        String s = "Lines" + " " + x + " " + y + " " + lineColor.getValue() + " " + fillColor.getValue() + " " + sizeX + " " + sizeY + " " + "nothing" + " " + deg;
        instance.setSizeX(sizeX);
        instance.setSizeY(sizeY);
        instance.setXY(x, y);
        instance.setLineColor(lineColor);
        instance.setDegrees(deg);
        instance.setFillColor(fillColor);

        try {
            assertEquals(s, instance.toString());
        } catch (AssertionError ex) {
            System.out.println(s + "\n" + instance.toString()); // it can fail not for a very bug but because of a round problem on the 13 decimal digit (can be easily resolved with round func)
            fail("The toString failed");
        }
    }
}
