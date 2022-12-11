/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Memory;

import Command.DeleteCommand;
import Command.Select;
import Factory.Creator;
import Shapes.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.Stack;
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
 * @author Davide
 */
public class MemoryTest {
    
    
    private Memory instance;
    private JFXPanel panel;
    
    //SELECT ATTRIBUTE
    private Select selectedShape;
    private Shape selectShape;
    private List<Shape> listShape;
    //CREATION SHAPE ATTRIBUTE
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
    private List<String> type;
    private final int NUM = 10;
    private Shape createdShape;
    //RANDOM
    private Random rand;
    private double[] vect;
    private DoubleStream stream;
    private int count;
    private PrimitiveIterator.OfDouble it;
    private double[] degreesVect;

    
    public MemoryTest() {
        
        degreesVect = new double[100];
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

        count = 0;
        stream = rand.doubles(-360.0, 360.001);
        it = stream.iterator();
        while (count < degreesVect.length && it.hasNext()) {
            degreesVect[count] = it.nextDouble();
            count++;
        }

        for (int i = 0; i < NUM; i++) {
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            createdShape = Creator.createShape(type.get(rand.nextInt(type.size())),
                    canvas.getGraphicsContext2D(), vect[rand.nextInt(vect.length)],
                    vect[rand.nextInt(vect.length)], listColor.get(rand.nextInt(listColor.size())),
                    listColor.get(rand.nextInt(listColor.size())), vect[rand.nextInt(vect.length)],
                    vect[rand.nextInt(vect.length)], generatedString, degreesVect[rand.nextInt(degreesVect.length)]);
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
        instance = new Memory();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of popStackShape method, of class Memory.
     */
    @Test
    public void testPopStackShape() {
        System.out.println("popStackShape");
        Memory instance = new Memory();
        Shape expResult = null;
        Shape result = instance.popStackShape();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of popStackDouble method, of class Memory.
     */
    @Test
    public void testPopStackDouble() {
        System.out.println("popStackDouble");
        Memory instance = new Memory();
        Double expResult = null;
        Double result = instance.popStackDouble();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of popStackColor method, of class Memory.
     */
    @Test
    public void testPopStackColor() {
        System.out.println("popStackColor");
        Memory instance = new Memory();
        ColorPicker expResult = null;
        ColorPicker result = instance.popStackColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStackShape method, of class Memory.
     */
    @Test
    public void testAddStackShape() {
        System.out.println("addStackShape");
        Shape selectedShape = null;
        Memory instance = new Memory();
        instance.addStackShape(selectedShape);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStackDouble method, of class Memory.
     */
    @Test
    public void testAddStackDouble() {
        System.out.println("addStackDouble");
        Double number = null;
        Memory instance = new Memory();
        instance.addStackDouble(number);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStackColor method, of class Memory.
     */
    @Test
    public void testAddStackColor() {
        System.out.println("addStackColor");
        ColorPicker color = null;
        Memory instance = new Memory();
        instance.addStackColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStackShape method, of class Memory.
     */
    @Test
    public void testGetStackShape() {
        System.out.println("getStackShape");
        Memory instance = new Memory();
        Stack<Shape> expResult = null;
        Stack<Shape> result = instance.getStackShape();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStackDouble method, of class Memory.
     */
    @Test
    public void testGetStackDouble() {
        System.out.println("getStackDouble");
        Memory instance = new Memory();
        Stack<Double> expResult = null;
        Stack<Double> result = instance.getStackDouble();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStackColor method, of class Memory.
     */
    @Test
    public void testGetStackColor() {
        System.out.println("getStackColor");
        Memory instance = new Memory();
        Stack<ColorPicker> expResult = null;
        Stack<ColorPicker> result = instance.getStackColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
