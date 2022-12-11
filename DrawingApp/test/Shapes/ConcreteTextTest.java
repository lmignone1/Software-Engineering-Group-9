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
 * @author artem
 */
public class ConcreteTextTest {

    private ConcreteText instance;
    private JFXPanel panel = new JFXPanel();
    private double[] vect = null;
    private double[] vect2 = null;
    private List<ColorPicker> listColor = null;
    private String string;
    private double[] degreesVect;

    public ConcreteTextTest() {
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
        instance = new ConcreteText();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setFillColor method, of class ConcreteText.
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
     * Test of getFillColor method, of class ConcreteText.
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
     * Test of setXY method, of class ConcreteText.
     */
    @Test
    public void testSetXY() {
        System.out.println("setXY");
        double[] x = vect;
        double[] y = vect2;

        for (int i = 0; i < vect.length; i++) {
            double currentX = instance.getX();
            double currentY = instance.getY();
            instance.setXY(x[i], y[i]);
            try {
                assertNotEquals(currentX, instance.getX());
                assertNotEquals(currentY, instance.getY());
                assertEquals(x[i] - 50.0 / 2, instance.getX(), 0);
                assertEquals(y[i] - 0.1 / 2, instance.getY(), 0);
            } catch (AssertionError ex) {
                fail("The setXY failed");
            }
        }
    }

    /**
     * Test of draw method, of class ConcreteText.
     */
    @Test
    public void testDraw() {
        System.out.println("drawShape");
        Random r = new Random();
        Canvas drawingCanvas = new Canvas(800, 600);
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        Canvas expCanvas = new Canvas(800, 600);
        GraphicsContext expGC = expCanvas.getGraphicsContext2D();
        instance.setGraphicsContext(gc);

        expGC.setLineWidth(2);
        double w = 50.0;
        double h = 0.1;
        Iterator<ColorPicker> it = listColor.iterator();

        int leftLimit = 97; //letter a
        int rightLimit = 122; //letter z
        int targetStringLength = 10;
        Random random = new Random();

        for (int i = 0; i < vect.length; i++) {
            instance.setXY(vect[i], vect2[i]);
            if (!it.hasNext()) {
                it = listColor.iterator();
            }
            ColorPicker color = it.next();
            ColorPicker cp = new ColorPicker();
            cp.setValue(Color.TRANSPARENT);
            instance.setLineColor(color);
            instance.setFillColor(color);

            GraphicsContext instanceGC = instance.getGraphicsContext();
            expGC.setStroke(cp.getValue());
            double x = vect[i] - w / 2;
            double y = vect2[i] - h / 2;
            double deg = degreesVect[r.nextInt(degreesVect.length)];
            instance.setDegrees(deg);
            expGC.setFill(color.getValue());
            expGC.strokeRect(x, y, w, h);
            expGC.fillRect(x, y, w, h);

            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            instance.setText(generatedString);
            expGC.fillText(generatedString, x + w / 4, y);

            instance.draw();

            try {
                assertEquals(expGC.getStroke(), instanceGC.getStroke());
                assertEquals(expGC.getLineWidth(), instanceGC.getLineWidth(), 0);
                assertEquals(expGC.getFill(), instanceGC.getFill());
                assertEquals(deg, instance.getDegrees(), 0);
                assertEquals(x, instance.getX(), 0);
                assertEquals(y, instance.getY(), 0);
                assertEquals(w, instance.getSizeX(), 0);
                assertEquals(h, instance.getSizeY(), 0);
                assertEquals(generatedString, instance.getText());
            } catch (AssertionError ex) {
                fail("The drawShape failed");
            }
        }
    }

    /**
     * Test of containsPoint method, of class ConcreteText.
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
     * Test of getPoint method, of class ConcreteText.
     */
    @Test
    public void testGetPoint() {
        System.out.println("getPoint");
        for (int i = 0; i < vect.length; i++) {
            instance.setXY(vect[i], vect2[i]);
            Point2D expResult = new Point2D(vect[i] - 50.0 / 2, vect2[i] - 0.1 / 2);
            Point2D result = instance.getPoint();
            try {
                assertNotNull(result);
                assertEquals(expResult.getX(), result.getX(), 0);
                assertEquals(expResult.getY(), result.getY(), 0);
            } catch (AssertionError ex) {
                fail("The getPoint failed");
            }
        }
    }

    /**
     * Test of getType method, of class ConcreteText.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        try {
            assertNotNull(instance.getType());
            assertEquals("Text", instance.getType());
        } catch (AssertionError ex) {
            fail("The getType failed");
        }
    }

    /**
     * Test of SetSizeX method, of class ConcreteText.
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
     * Test of getSizeX method, of class ConcreteText.
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
     * Test of setSizeY method, of class ConcreteText.
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
     * Test of getSizeY method, of class ConcreteText.
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
     * Test of setText method, of class ConcreteText.
     */
    @Test
    public void testSetText() {
        System.out.println("getText");
        int leftLimit = 97; //letter a
        int rightLimit = 122; //letter z
        int targetStringLength = 10;
        Random random = new Random();

        try {
            for (int i = 0; i < 10; i++) {
                String generatedString = random.ints(leftLimit, rightLimit + 1)
                        .limit(targetStringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();

                String currentString = instance.getText();
                instance.setText(generatedString);

                assertNotEquals(currentString, instance.getText());
                assertEquals(generatedString, instance.getText());

            }
        } catch (AssertionError ex) {
            fail("The setText failed");
        }

    }

    /**
     * Test of getText method, of class ConcreteText.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        int leftLimit = 97; //letter a
        int rightLimit = 122; //letter z
        int targetStringLength = 10;
        Random random = new Random();

        try {
            for (int i = 0; i < 10; i++) {
                String generatedString = random.ints(leftLimit, rightLimit + 1)
                        .limit(targetStringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();

                instance.setText(generatedString);
                String result = instance.getText();
                assertNotNull(result);
                assertEquals(generatedString, result);

            }
        } catch (AssertionError ex) {
            fail("The getText failed");
        }
    }

    /**
     * Test of toString method, of class ConcreteText.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        int leftLimit = 97; //letter a
        int rightLimit = 122; //letter z
        int targetStringLength = 10;

        Random r = new Random();
        String generatedString = r.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        double x = vect[r.nextInt(vect.length)];
        double y = vect[r.nextInt(vect.length)];
        ColorPicker lineColor = listColor.get(r.nextInt(listColor.size()));
        ColorPicker fillColor = listColor.get(r.nextInt(listColor.size()));
        double sizeX = vect[r.nextInt(vect.length)];
        double sizeY = vect[r.nextInt(vect.length)];
        double deg = degreesVect[r.nextInt(degreesVect.length)];

        String s = "Text" + " " + x + " " + y + " " + lineColor.getValue() + " " + fillColor.getValue() + " " + sizeX + " " + sizeY + " " + generatedString + " " + deg;
        instance.setSizeX(sizeX);
        instance.setSizeY(sizeY);
        instance.setXY(x, y);
        instance.setLineColor(lineColor);
        instance.setDegrees(deg);
        instance.setFillColor(fillColor);
        instance.setText(generatedString);

        try {
            assertEquals(s, instance.toString());
        } catch (AssertionError ex) {
            System.out.println(s + "\n" + instance.toString()); // it can fail not for a very bug but because of a round problem on the 13 decimal digit (can be easily resolved with round func)
            fail("The toString failed");
        }
    }

}
