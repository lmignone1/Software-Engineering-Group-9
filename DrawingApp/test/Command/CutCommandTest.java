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
public class CutCommandTest {

    private JFXPanel panel = new JFXPanel();
    private CutCommand instance;

    private Select selectedShape;
    private Shape selectShape;
    private List<Shape> list;

    private double[] vect;
    private GraphicsContext gc;
    private List<ColorPicker> listColor = null;
    private double[] degreesVect;

    private Random r;

    private final int NUM = 10;

    public CutCommandTest() {
        vect = new double[100];
        r = new Random();
        degreesVect = new double[100];
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

        int leftLimit = 97; //letter a
        int rightLimit = 122; //letter z
        int targetStringLength = 10;
        Random random = new Random();

        Canvas canvas = new Canvas(1400, 1000);
        gc = canvas.getGraphicsContext2D();
        String[] type = {"Line", "Rectangle", "Ellipse", "Text"};
        list = new ArrayList<>();
        Creator c = new Creator();
        for (int i = 0; i < NUM; i++) {
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            Shape shape = c.createShape(type[r.nextInt(type.length)], gc, vect[r.nextInt(vect.length)],
                    vect[r.nextInt(vect.length)],
                    listColor.get(r.nextInt(listColor.size())),
                    listColor.get(r.nextInt(listColor.size())),
                    vect[r.nextInt(vect.length)], vect[r.nextInt(vect.length)],
                    generatedString, degreesVect[r.nextInt(degreesVect.length)]);
            list.add(shape);
        }
        selectedShape = new Select(list, null);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        selectShape = list.get(r.nextInt(list.size()));
        selectedShape.setSelectedShape(selectShape);
        instance = new CutCommand(selectedShape, 0);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class CutCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("TEST: execute cutCommand");
        for (int i = 1; i < NUM; i++) {
            instance.execute();
            try {
                assertEquals(selectedShape.getCopyShape(), selectedShape.getSelectedShape());
                assertFalse(list.contains(selectShape));
                assertFalse(selectedShape.getMemory().getStackShape().isEmpty());
                assertTrue(selectedShape.getMemory().getStackShape().contains(selectShape));
            } catch (AssertionError ex) {
                fail("ERROR-2: The execute cutCommand failed");
            }
            if (list.isEmpty()) {
                break;
            }

            selectShape = list.get(r.nextInt(list.size()));
            selectedShape.setSelectedShape(selectShape);
            //instance.execute();
        }

    }

    /**
     * Test of undo method, of class CutCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("TEST: Undo cutCommand");

        for (int i = 0; i < NUM; i++) {
            instance.execute();
            instance.undo();
            try {
                assertTrue(list.contains(selectShape));
                assertTrue(selectedShape.getMemory().getStackShape().isEmpty());
                assertFalse(selectedShape.getMemory().getStackShape().contains(selectShape));
                assertEquals(null, selectedShape.getCopyShape());
            } catch (AssertionError ex) {
                fail("ERROR: The undo of cutCommand failed");
            }
            selectShape = list.get(r.nextInt(list.size()));
            selectedShape.setSelectedShape(selectShape);
        }

    }

    /**
     * Test2 of undo method, of class CutCommand.
     */
    @Test
    public void testUndo2() {
        System.out.println("TEST2: Undo cutCommand");

        Shape expShape;

        for (int i = 0; i < NUM; i++) {
            instance.execute();
            if (list.isEmpty()) {
                break;
            }
            selectShape = list.get(r.nextInt(list.size()));
            selectedShape.setSelectedShape(selectShape);
        }

        assertTrue(list.isEmpty());

        for (int i = 0; i < NUM; i++) {
            expShape = selectedShape.getMemory().getStackShape().peek();
            instance.undo();
            try {
                assertTrue(list.contains(expShape));
                assertFalse(selectedShape.getMemory().getStackShape().contains(expShape));
            } catch (AssertionError ex) {
                fail(" ERROR-2: The undo of cutCommand failed");
            }
        }
        assertFalse(list.isEmpty());

    }
}
