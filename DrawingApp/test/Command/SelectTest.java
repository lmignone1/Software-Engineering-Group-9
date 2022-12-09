/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Command;

import Factory.Creator;
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
public class SelectTest {

    private JFXPanel panel = new JFXPanel();
    private Select instance;
    private List<Shape> list;
    private Shape selectShape;

    private double[] vect;
    private GraphicsContext gc;
    private List<ColorPicker> listColor = null;

    private final int NUM = 10;

    public SelectTest() {
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
        String[] type = {"Line", "Rectangle", "Ellipse"};
        list = new ArrayList<>();
        Creator c = new Creator();
        for (int i = 0; i < NUM; i++) {
            Shape shape = c.createShape(type[r.nextInt(type.length)], gc, vect[r.nextInt(vect.length)],
                    vect[r.nextInt(vect.length)],
                    listColor.get(r.nextInt(listColor.size())),
                    listColor.get(r.nextInt(listColor.size())));
            list.add(shape);
        }
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Select(list, null);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getShape method, of class Select.
     */
    @Test
    public void testGetShape() {
        System.out.println("getShape");
        List<Shape> result = instance.getShape();
        try {
            assertNotNull(result);
            assertEquals(list, result);
        } catch (AssertionError ex) {
            fail("The getShape failed");
        }
    }

    /**
     * Test of getSelectedShape method, of class Select.
     */
    @Test
    public void testGetSelectedShape() {
        System.out.println("getSelectedShape");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            instance.setSelectedShape(selectShape);
            Shape result = instance.getSelectedShape();
            try {
                assertNotNull(result);
                assertEquals(selectShape, result);
            } catch (AssertionError ex) {
                fail("The getSelectedShape failed");
            }
        }
    }

    /**
     * Test of setSelectedShape method, of class Select.
     */
    @Test
    public void testSetSelectedShape() {
        System.out.println("setSelectedShape");
        for (int i = 0; i < list.size(); i++) {
            Shape currentShape = instance.getSelectedShape();
            instance.setSelectedShape(list.get(i));
            System.out.println(currentShape);
            System.out.println(instance.getSelectedShape());
            try {
                //assertNotEquals(currentShape, instance.getSelectedShape());
                //assertEquals(list.get(i), instance.getSelectedShape());
            } catch (AssertionError ex) {
                fail("The setSelectedShape failed");
            }
        }
    }

    /**
     * Test of getCopyShape method, of class Select.
     */
    @Test
    public void testGetCopyShape() {
        System.out.println("getCopyShape");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            instance.setCopyShape(selectShape);
            Shape result = instance.getCopyShape();
            try {
                assertNotNull(result);
                assertEquals(selectShape, result);
            } catch (AssertionError ex) {
                fail("The GetCopyShape failed");
            }
        }
    }

    /**
     * Test of setCopyShape method, of class Select.
     */
    @Test
    public void testSetCopyShape() {
        System.out.println("setCopyShape");
        for (int i = 0; i < list.size(); i++) {
            Shape currentShape = instance.getCopyShape();
            instance.setCopyShape(list.get(i));
            try {
                assertNotEquals(currentShape, instance.getCopyShape());
                assertEquals(list.get(i), instance.getCopyShape());
            } catch (AssertionError ex) {
                fail("The setCopyShape failed");
            }
        }
    }

    /**
     * Test of getPreviusLineColor method, of class Select.
     */
    @Test
    public void testGetPreviusLineColor() {
        System.out.println("getPreviusLineColor");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            instance.setSelectedShape(selectShape);
            for (ColorPicker color : listColor) {
                ColorPicker oldColor = selectShape.getLineColor();
                instance.setPreviusLineColor(instance.getSelectedShape().getLineColor());
                instance.getSelectedShape().setLineColor(color);
                try {
                    assertNotNull(instance.getPreviusLineColor());
                    assertEquals(oldColor.getValue(), instance.getPreviusLineColor().getValue());
                } catch (AssertionError ex) {
                    fail("getPreviusLineColor");
                }
            }
        }
    }

    /**
     * Test of setPreviusLineColor method, of class Select.
     */
    @Test
    public void testSetPreviusLineColor() {
        System.out.println("setPreviusLineColor");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            instance.setSelectedShape(selectShape);
            for (ColorPicker color : listColor) {
                ColorPicker currentColor = instance.getPreviusLineColor();
                instance.getSelectedShape().setLineColor(color);
                instance.setPreviusLineColor(instance.getSelectedShape().getLineColor());
                try {
                    assertNotEquals(currentColor, instance.getPreviusLineColor());
                    assertEquals(color.getValue(), instance.getPreviusLineColor().getValue());
                } catch (AssertionError ex) {
                    fail("The setPreviusLineColor failed");
                }
            }
        }
    }

    /**
     * Test of getPreviusFillColor method, of class Select.
     */
    @Test
    public void testGetPreviusFillColor() {
        System.out.println("getPreviusFillColor");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            if (!selectShape.getType().equals("Line")) {
                instance.setSelectedShape(selectShape);
                for (ColorPicker color : listColor) {
                    ColorPicker oldColor = selectShape.getFillColor();
                    instance.setPreviusFillColor(instance.getSelectedShape().getFillColor());
                    instance.getSelectedShape().setFillColor(color);
                    try {
                        assertNotNull(instance.getPreviusFillColor());
                        assertEquals(oldColor.getValue(), instance.getPreviusFillColor().getValue());
                    } catch (AssertionError ex) {
                        fail("getPreviusFillColor");
                    }
                }
            }
        }
    }

    /**
     * Test of setPreviusFillColor method, of class Select.
     */
    @Test
    public void testSetPreviusFillColor() {
        System.out.println("setPreviusFillColor");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            if (!selectShape.getType().equals("Line")) {
                instance.setSelectedShape(selectShape);
                for (ColorPicker color : listColor) {
                    ColorPicker currentColor = instance.getPreviusFillColor();
                    instance.getSelectedShape().setFillColor(color);
                    instance.setPreviusFillColor(instance.getSelectedShape().getFillColor());
                    try {
                        assertNotEquals(currentColor, instance.getPreviusFillColor());
                        assertEquals(color.getValue(), instance.getPreviusFillColor().getValue());
                    } catch (AssertionError ex) {
                        fail("The setPreviusFillColor failed");
                    }
                }
            }
        }
    }

    /**
     * Test of getPreviousSizeX method, of class Select.
     */
    @Test
    public void testGetPreviousSizeX() {
        System.out.println("getPreviousSizeX");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            instance.setSelectedShape(selectShape);
            for (int j = 0; j < vect.length; j++) {
                double oldSizeX = selectShape.getSizeX();
                instance.setPreviousSizeX(instance.getSelectedShape().getSizeX());
                instance.getSelectedShape().setSizeX(vect[j]);
                try {
                    assertNotNull(instance.getPreviousSizeX());
                    assertEquals(oldSizeX, instance.getPreviousSizeX(), 0);
                } catch (AssertionError ex) {
                    fail("The getPreviousSizeX failed");
                }
            }
        }
    }

    /**
     * Test of setPreviousSizeX method, of class Select.
     */
    @Test
    public void testSetPreviousSizeX() {
        System.out.println("setPreviousSizeX");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            instance.setSelectedShape(selectShape);
            for (int j = 0; j < vect.length; j++) {
                double currentSizeX = instance.getPreviousSizeX();
                instance.getSelectedShape().setSizeX(vect[j]);
                instance.setPreviousSizeX(instance.getSelectedShape().getSizeX());
                try {
                    assertNotEquals(currentSizeX, instance.getPreviousSizeX());
                    assertEquals(vect[j], instance.getPreviousSizeX(), 0);
                } catch (AssertionError ex) {
                    fail("The setPreviousSizeX failed");
                }
            }
        }
    }

    /**
     * Test of getPreviousSizeY method, of class Select.
     */
    @Test
    public void testGetPreviousSizeY() {
        System.out.println("getPreviousSizeY");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            if (!selectShape.getType().equals("Line")) {
                instance.setSelectedShape(selectShape);
                for (int j = 0; j < vect.length; j++) {
                    double oldSizeY = selectShape.getSizeY();
                    instance.setPreviousSizeY(instance.getSelectedShape().getSizeY());
                    instance.getSelectedShape().setSizeY(vect[j]);
                    try {
                        assertNotNull(instance.getPreviousSizeY());
                        assertEquals(oldSizeY, instance.getPreviousSizeY(), 0);
                    } catch (AssertionError ex) {
                        fail("The getPreviousSizeY failed");
                    }
                }
            }
        }
    }

    /**
     * Test of setPreviousSizeY method, of class Select.
     */
    @Test
    public void testSetPreviousSizeY() {
        System.out.println("setPreviousSizeY");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            if (!selectShape.getType().equals("Line")) {
                instance.setSelectedShape(selectShape);
                for (int j = 0; j < vect.length; j++) {
                    double currentSizeY = instance.getPreviousSizeY();
                    instance.getSelectedShape().setSizeY(vect[j]);
                    instance.setPreviousSizeY(instance.getSelectedShape().getSizeY());
                    try {
                        assertNotEquals(currentSizeY, instance.getPreviousSizeY());
                        assertEquals(vect[j], instance.getPreviousSizeY(), 0);
                    } catch (AssertionError ex) {
                        fail("The setPreviousSizeY failed");
                    }
                }
            }
        }
    }

    /**
     * Test of getPreviousX method, of class Select.
     */
    @Test
    public void testGetPreviousX() {
        System.out.println("getPreviousX");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            instance.setSelectedShape(selectShape);
            for (int j = 0; j < vect.length; j++) {
                double oldX = selectShape.getX();
                instance.setPreviousX(instance.getSelectedShape().getX());
                instance.getSelectedShape().setX(vect[j]);
                try {
                    assertNotNull(instance.getPreviousX());
                    assertEquals(oldX, instance.getPreviousX(), 0);
                } catch (AssertionError ex) {
                    fail("The getPreviousX failed");
                }
            }
        }
    }

    /**
     * Test of getPreviousY method, of class Select.
     */
    @Test
    public void testGetPreviousY() {
        System.out.println("getPreviousY");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            instance.setSelectedShape(selectShape);
            for (int j = 0; j < vect.length; j++) {
                double oldY = selectShape.getY();
                instance.setPreviousY(instance.getSelectedShape().getY());
                instance.getSelectedShape().setY(vect[j]);
                try {
                    assertNotNull(instance.getPreviousY());
                    assertEquals(oldY, instance.getPreviousY(), 0);
                } catch (AssertionError ex) {
                    fail("The getPreviousY failed");
                }
            }
        }
    }

    /**
     * Test of setPreviousX method, of class Select.
     */
    @Test
    public void testSetPreviousX() {
        System.out.println("setPreviousX");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            instance.setSelectedShape(selectShape);
            for (int j = 0; j < vect.length; j++) {
                double currentX = instance.getPreviousX();
                instance.getSelectedShape().setX(vect[j]);
                instance.setPreviousX(instance.getSelectedShape().getX());
                try {
                    assertNotEquals(currentX, instance.getPreviousX());
                    assertEquals(vect[j], instance.getPreviousX(), 0);
                } catch (AssertionError ex) {
                    fail("The setPreviousX failed");
                }
            }
        }
    }

    /**
     * Test of setPreviousY method, of class Select.
     */
    @Test
    public void testSetPreviousY() {
        System.out.println("setPreviousY");
        for (int i = 0; i < list.size(); i++) {
            selectShape = list.get(i);
            instance.setSelectedShape(selectShape);
            for (int j = 0; j < vect.length; j++) {
                double currentY = instance.getPreviousY();
                instance.getSelectedShape().setY(vect[j]);
                instance.setPreviousY(instance.getSelectedShape().getY());
                try {
                    assertNotEquals(currentY, instance.getPreviousY());
                    assertEquals(vect[j], instance.getPreviousY(), 0);
                } catch (AssertionError ex) {
                    fail("The setPreviousY failed");
                }
            }
        }
    }
}
