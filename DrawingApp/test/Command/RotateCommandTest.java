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
public class RotateCommandTest {

    private Select selectedShape;
    private Shape selectShape;
    private List<Shape> listShape;
    private JFXPanel panel = new JFXPanel();
    private RotateCommand instance;
    private List<ColorPicker> listColor;
    private List<String> type;
    private final int NUM = 10;
    private double[] vect;
    private double[] degreesVect;
    private GraphicsContext gc;

    public RotateCommandTest() {
        degreesVect = new double[100];
        listShape = new ArrayList<>();
        selectShape = null;
        selectedShape = new Select(listShape, selectShape);
        Canvas canvas = new Canvas(1400, 1000);
        gc = canvas.getGraphicsContext2D();
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

        type = new ArrayList<>();
        type.add("Line");
        type.add("Rectangle");
        type.add("Ellipse");
        type.add("Text");

        int leftLimit = 97; //letter a
        int rightLimit = 122; //letter z
        int targetStringLength = 10;

        Random r = new Random();

        vect = new double[100];
        DoubleStream stream = r.doubles(-999.999, 999.999);
        int count = 0;
        PrimitiveIterator.OfDouble it = stream.iterator();
        while (count < vect.length && it.hasNext()) {
            vect[count] = it.nextDouble();
            count++;
        }

        count = 0;
        stream = r.doubles(-360.001, 360.001);
        it = stream.iterator();
        while (count < degreesVect.length && it.hasNext()) {
            degreesVect[count] = it.nextDouble();
            count++;
        }

        for (int i = 0; i < NUM; i++) {
            String generatedString = r.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            Shape createdShape = Creator.createShape(type.get(i % type.size()),
                    gc, vect[r.nextInt(vect.length)],
                    vect[r.nextInt(vect.length)], listColor.get(r.nextInt(listColor.size())),
                    listColor.get(r.nextInt(listColor.size())), vect[r.nextInt(vect.length)],
                    vect[r.nextInt(vect.length)], generatedString, degreesVect[r.nextInt(degreesVect.length)]);
            listShape.add(createdShape);
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

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class RotateCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Random r = new Random();

        for (int i = 0; i < listShape.size(); i++) {
            selectShape = listShape.get(i);
            selectedShape.setSelectedShape(selectShape);
            double deg = degreesVect[r.nextInt(degreesVect.length)];
            instance = new RotateCommand(selectedShape, deg);
            double oldDeg = selectShape.getDegrees();
            instance.execute();
            try {
                assertEquals(deg, selectedShape.getSelectedShape().getDegrees(), 0);
                assertFalse(selectedShape.getMemory().getStackDouble().isEmpty());
                assertTrue(selectedShape.getMemory().getStackShape().contains(selectShape));
                assertEquals(oldDeg, selectedShape.getMemory().getStackDouble().lastElement(), 0);
            } catch (AssertionError ex) {
                fail("The execute failed");
            }
        }

    }

    /**
     * Test of undo method, of class RotateCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        Random r = new Random();

        for (int i = 0; i < listShape.size(); i++) {
            selectShape = listShape.get(i);
            selectedShape.setSelectedShape(selectShape);
            double deg = degreesVect[r.nextInt(degreesVect.length)];
            instance = new RotateCommand(selectedShape, deg);
            double oldDeg = selectedShape.getSelectedShape().getDegrees();
            instance.execute();
            instance.undo();
            try {
                assertTrue(selectedShape.getMemory().getStackShape().isEmpty());
                assertEquals(oldDeg, selectedShape.getSelectedShape().getDegrees(), 0);
            } catch (AssertionError ex) {
                fail("The undo failed");
            }
        }
    }

    /**
     * Test of undo method, of class RotateCommand.
     */
    @Test
    public void testUndo2() {
        System.out.println("undo2");
        Random r = new Random();
        double[] oldDeg = new double[listShape.size()];

        for (int i = 0; i < listShape.size(); i++) {
            selectShape = listShape.get(i);
            selectedShape.setSelectedShape(selectShape);
            instance = new RotateCommand(selectedShape, degreesVect[r.nextInt(degreesVect.length)]);
            oldDeg[i] = selectedShape.getSelectedShape().getDegrees();
            instance.execute();
        }

        try {
            assertFalse(selectedShape.getMemory().getStackDouble().isEmpty());
            assertFalse(selectedShape.getMemory().getStackShape().isEmpty());
            assertEquals(listShape.size(), selectedShape.getMemory().getStackDouble().size());
            assertEquals(listShape.size(), selectedShape.getMemory().getStackShape().size());
        } catch (AssertionError ex) {
            fail("The undo2 failed");
        }

        for (int i = 0; i < listShape.size(); i++) {
            Shape currentShape = selectedShape.getMemory().getStackShape().peek();
            double currentDeg = currentShape.getDegrees();
            instance.undo();
            try {
                assertEquals(oldDeg[listShape.size() - i - 1], currentShape.getDegrees(), 0);
                if (!selectedShape.getMemory().getStackDouble().isEmpty()) {
                    assertNotEquals(oldDeg[listShape.size() - i - 1], selectedShape.getMemory().getStackDouble().lastElement());
                }
                assertFalse(selectedShape.getMemory().getStackShape().contains(currentShape));

            } catch (AssertionError ex) {
                fail("The undo2 failed");
            }
        }

        try {
            assertTrue(selectedShape.getMemory().getStackDouble().isEmpty());
            assertTrue(selectedShape.getMemory().getStackShape().isEmpty());
        } catch (AssertionError ex) {
            fail("The undo2 failed");
        }
    }

}
