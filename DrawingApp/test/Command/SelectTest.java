/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Command;

import Factory.Creator;
import Memory.Memory;
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
 * @author Davide
 */
public class SelectTest {
    
    //SELECT ATTRIBUTE
    private Select instance;
    private Shape selectShape;
    private List<Shape> list;
    private JFXPanel panel;
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
    
    
    public SelectTest() {
        degreesVect = new double[100];
        panel = new JFXPanel();
        list = new ArrayList<>();
        selectShape = null;
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
            list.add(createdShape);
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
            try {
                assertNotEquals(currentShape, instance.getSelectedShape());
                assertEquals(list.get(i), instance.getSelectedShape());
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
     * Test of getMemory method, of class Select.
     */
    @Test
    public void testGetMemory() {
        System.out.println("getMemory");
        try{
           assertTrue(instance.getMemory() instanceof Memory);
           assertNotEquals(instance.getMemory(),null);
        }catch(AssertionError ex){
            fail("The getMemory failed");
        }
    }

    /**
     * Test of getPasteShape method, of class Select.
     */
    @Test
    public void testGetPasteShape() {
        System.out.println("getPasteShape");
        for (int i = 0; i < NUM; i++) {
            selectShape = list.get(i);
            instance.setCopyShape(selectShape);
            instance.paste(vect[rand.nextInt(vect.length)], vect[rand.nextInt(vect.length)]);
            Shape result = instance.getPasteShape();
            try {
                assertNotNull(result);
                assertTrue(result instanceof Shape);
            } catch (AssertionError ex) {
                fail("The getPasteShape failed");
            }
        }
    }   
}
