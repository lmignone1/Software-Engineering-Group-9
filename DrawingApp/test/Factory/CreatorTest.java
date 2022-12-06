/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Factory;

import Shapes.Shape;
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
 * @author loren
 */
public class CreatorTest {

    private JFXPanel panel = new JFXPanel();
    private double[] vect;
    private List<ColorPicker> listColor;
    private GraphicsContext gc;
    private List<String> mode;

    @SuppressWarnings("empty-statement")
    public CreatorTest() {
        vect = new double[100];
        Random r = new Random();
        DoubleStream stream = r.doubles(-999.999, 999.999);
        int count = 0;
        PrimitiveIterator.OfDouble it = stream.iterator();
        while (count < vect.length && it.hasNext()) {
            vect[count] = it.nextDouble();
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

        Canvas canvas = new Canvas(1400, 1000);
        gc = canvas.getGraphicsContext2D();
        mode = new ArrayList<>();
        mode.add("Line");
        mode.add("Rectangle");
        mode.add("Ellipse");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createShape method, of class Creator.
     */
    @Test
    public void testCreateShape_6args() {
        System.out.println("createShape");
        Random r = new Random();
        for (String elem : mode) {
            double x = vect[r.nextInt(vect.length)];
            double y = vect[r.nextInt(vect.length)];
            ColorPicker fillColor = listColor.get(r.nextInt(listColor.size()));
            ColorPicker lineColor = listColor.get(r.nextInt(listColor.size()));
            Shape result = Creator.createShape(elem, gc, x, y, lineColor, fillColor);
            try {
                assertNotNull(result);
                assertEquals(elem, result.getType());
                assertEquals(gc, result.getGraphicsContext());
                assertEquals(lineColor.getValue(), result.getLineColor().getValue());
                if (elem.equals(mode.get(0))) {
                    assertEquals(x - 100.0 / 2, result.getX(), 0);
                    assertEquals(y, result.getY(), 0);
                } else if (elem.equals(mode.get(1))) {
                    assertEquals(x - 100.0 / 2, result.getX(), 0);
                    assertEquals(y - 50.0 / 2, result.getY(), 0);
                    assertEquals(fillColor.getValue(), result.getFillColor().getValue());
                } else {
                    assertEquals(x - 150.0 / 2, result.getX(), 0);
                    assertEquals(y - 90.0 / 2, result.getY(), 0);
                    assertEquals(fillColor.getValue(), result.getFillColor().getValue());
                }
            } catch (AssertionError ex) {
                fail("The createShape failed");
            }
        }
    }

    /**
     * Test of createShape method, of class Creator.
     */
    @Test
    public void testCreateShape_8args() {
        System.out.println("createShape");
        Random r = new Random();
        for (String elem : mode) {
            double x = vect[r.nextInt(vect.length)];
            double y = vect[r.nextInt(vect.length)];
            double sizeX = vect[r.nextInt(vect.length)];
            double sizeY = vect[r.nextInt(vect.length)];
            ColorPicker fillColor = listColor.get(r.nextInt(listColor.size()));
            ColorPicker lineColor = listColor.get(r.nextInt(listColor.size()));
            Shape result = Creator.createShape(elem, gc, x, y, lineColor, fillColor, sizeX, sizeY);
            try {
                assertNotNull(result);
                assertEquals(elem, result.getType());
                assertEquals(gc, result.getGraphicsContext());
                assertEquals(lineColor.getValue(), result.getLineColor().getValue());
                if (elem.equals(mode.get(0))) {
                    assertEquals(x - sizeX / 2, result.getX(), 0);
                    assertEquals(y, result.getY(), 0);
                    assertEquals(sizeX, result.getSizeX(), 0);
                } else if (elem.equals(mode.get(1))) {
                    assertEquals(x - sizeX / 2, result.getX(), 0);
                    assertEquals(y - sizeY / 2, result.getY(), 0);
                    assertEquals(fillColor.getValue(), result.getFillColor().getValue());
                    assertEquals(sizeX, result.getSizeX(), 0);
                    assertEquals(sizeY, result.getSizeY(), 0);
                } else {
                    assertEquals(x - sizeX / 2, result.getX(), 0);
                    assertEquals(y - sizeY / 2, result.getY(), 0);
                    assertEquals(fillColor.getValue(), result.getFillColor().getValue());
                    assertEquals(sizeX, result.getSizeX(), 0);
                    assertEquals(sizeY, result.getSizeY(), 0);
                }
            } catch (AssertionError ex) {
                fail("The createShape failed");
            }
        }
    }

}
