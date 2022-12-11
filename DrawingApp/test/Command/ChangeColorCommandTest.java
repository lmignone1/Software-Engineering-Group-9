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
public class ChangeColorCommandTest {

    private Select selectedShape;
    private Shape selectShape;
    private List<Shape> listShape;
    private JFXPanel panel;
    private ChangeColorCommand instance;
    private Creator creator;
    private Canvas canvas;
    private List<ColorPicker> listColor;
    private ColorPicker colorPickerWhite;
    private ColorPicker colorPickerRed;
    private ColorPicker colorPickerBlue;
    private ColorPicker colorPickerYellow;
    private ColorPicker colorPickerOrange;
    private ColorPicker colorPickerGreen;
    private ColorPicker colorPickerPurple;
    private ColorPicker colorPickerBlack;
    private ColorPicker colorPickerChocolate;
    private ColorPicker colorPickerColar;
    private ColorPicker colorPickerCyan;
    private ColorPicker colorPickerGray;
    private List<String> type;
    private final int NUM = 10;
    private Shape createdShape;
    //RANDOM
    private Random rand;
    private double[] vect;
    private DoubleStream stream;
    private int count;
    private PrimitiveIterator.OfDouble it;

    public ChangeColorCommandTest() {
        panel = new JFXPanel();
        listShape = new ArrayList<>();
        selectShape = null;
        selectedShape = new Select(listShape, selectShape);
        creator = new Creator();
        canvas = new Canvas(1400, 1000);

        listColor = new ArrayList<>();

        colorPickerWhite = new ColorPicker(Color.WHITE);
        colorPickerRed = new ColorPicker(Color.RED);
        colorPickerBlue = new ColorPicker(Color.BLUE);
        colorPickerYellow = new ColorPicker(Color.YELLOW);
        colorPickerOrange = new ColorPicker(Color.ORANGE);
        colorPickerGreen = new ColorPicker(Color.GREEN);
        colorPickerPurple = new ColorPicker(Color.PURPLE);
        colorPickerBlack = new ColorPicker(Color.BLACK);
        colorPickerChocolate = new ColorPicker(Color.CHOCOLATE);
        colorPickerColar = new ColorPicker(Color.CORAL);
        colorPickerCyan = new ColorPicker(Color.CYAN);
        colorPickerGray = new ColorPicker(Color.GRAY);

        listColor.add(colorPickerWhite);
        listColor.add(colorPickerRed);
        listColor.add(colorPickerBlue);
        listColor.add(colorPickerYellow);
        listColor.add(colorPickerOrange);
        listColor.add(colorPickerGreen);
        listColor.add(colorPickerPurple);
        listColor.add(colorPickerBlack);
        listColor.add(colorPickerChocolate);
        listColor.add(colorPickerColar);
        listColor.add(colorPickerCyan);
        listColor.add(colorPickerGray);

        type = new ArrayList<>();
        type.add("Line");
        type.add("Rectangle");
        type.add("Ellipse");
        type.add("Text");

        int leftLimit = 97; //letter a
        int rightLimit = 122; //letter z
        int targetStringLength = 10;
        Random random = new Random();

        rand = new Random();
        vect = new double[100];
        stream = rand.doubles(-999.999, 999.999);
        count = 0;
        it = stream.iterator();
        while (count < vect.length && it.hasNext()) {
            vect[count] = it.nextDouble();
            count++;
        }
        for (int i = 0; i < NUM; i++) {
            /*
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
             */
            createdShape = Creator.createShape(type.get(rand.nextInt(type.size())),
                    canvas.getGraphicsContext2D(), vect[rand.nextInt(vect.length)],
                    vect[rand.nextInt(vect.length)], listColor.get(rand.nextInt(listColor.size())),
                    listColor.get(rand.nextInt(listColor.size())), vect[rand.nextInt(vect.length)],
                    vect[rand.nextInt(vect.length)], 0);
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
        selectShape = listShape.get(0);
        selectedShape.setSelectedShape(selectShape);
        if (selectedShape.getSelectedShape().getType().equals("Line")) {
            instance = new ChangeColorCommand(selectedShape, listColor.get(0), null);
        } else {
            instance = new ChangeColorCommand(selectedShape, listColor.get(0), listColor.get(1));
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class ChangeColorCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("TEST: Execute ChangeColorCommand");
        ColorPicker expectLine = listColor.get(0);
        ColorPicker expectFill = listColor.get(1);
        ColorPicker pastColorLine;
        ColorPicker pastColorFill = null;
        for (int i = 1; i < listShape.size(); i++) {
            pastColorLine = this.selectedShape.getSelectedShape().getLineColor();
            if (!this.selectedShape.getSelectedShape().getType().equals("Line")) {
                pastColorFill = this.selectedShape.getSelectedShape().getFillColor();
            }
            instance.execute();

            try {
                assertTrue(listShape.contains(selectShape));
                assertEquals(expectLine.getValue(), selectedShape.getSelectedShape().getLineColor().getValue());
                assertTrue(this.selectedShape.getMemory().getStackColor().contains(pastColorLine));
                if (!selectedShape.getSelectedShape().getType().equals("Line")) {
                    assertEquals(expectFill.getValue(), selectedShape.getSelectedShape().getFillColor().getValue());
                    assertTrue(this.selectedShape.getMemory().getStackColor().contains(pastColorFill));
                }

            } catch (AssertionError ex) {
                fail("ERROR: The excute of ChangeColorCommand failed");
            }
            selectShape = listShape.get(i);
            selectedShape.setSelectedShape(selectShape);

            if (selectedShape.getSelectedShape().getType().equals("Line")) {
                instance = new ChangeColorCommand(selectedShape, listColor.get(i), null);
            } else {
                instance = new ChangeColorCommand(selectedShape, listColor.get(i), listColor.get(i + 1));
            }
            expectLine = listColor.get(i);
            expectFill = listColor.get(i + 1);

        }
    }

    /**
     * Test of undo method, of class ChangeColorCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("TEST: Undo ChangeColorCommand");

        ColorPicker expLine;
        ColorPicker expFill = null;

        for (int i = 1; i < listShape.size(); i++) {
            expLine = selectedShape.getSelectedShape().getLineColor();
            if (!this.selectedShape.getSelectedShape().getType().equals("Line")) {
                expFill = this.selectedShape.getSelectedShape().getFillColor();
            }

            instance.execute();
            instance.undo();
            try {
                assertTrue(listShape.contains(selectShape));
                assertEquals(expLine.getValue(), selectedShape.getSelectedShape().getLineColor().getValue());
                if (!selectedShape.getSelectedShape().getType().equals("Line")) {
                    assertEquals(expFill.getValue(), selectedShape.getSelectedShape().getFillColor().getValue());
                }

            } catch (AssertionError ex) {
                fail("ERROR: The Undo of ChangeColorCommand failed");
            }
            selectShape = listShape.get(i);
            selectedShape.setSelectedShape(selectShape);

            if (selectedShape.getSelectedShape().getType().equals("Line")) {
                instance = new ChangeColorCommand(selectedShape, listColor.get(i), null);
            } else {
                instance = new ChangeColorCommand(selectedShape, listColor.get(i), listColor.get(i + 1));
            }

        }
    }
}
