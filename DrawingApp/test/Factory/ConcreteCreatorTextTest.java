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
 * @author artem
 */
public class ConcreteCreatorTextTest {
    private ConcreteCreatorText instance;
    private JFXPanel panel = new JFXPanel();
    private double[] vect;
    private List<ColorPicker> listColor;
    private GraphicsContext gc;
    private final int NUM = 10;
    
    public ConcreteCreatorTextTest() {
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
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ConcreteCreatorText();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createShape method, of class ConcreteCreatorText.
     */
    @Test
    public void testCreateShape() {
        int leftLimit = 97; //letter a
        int rightLimit = 122; //letter z
        int targetStringLength = 10;
        Random random = new Random();
        
        System.out.println("createShape");
        Random r = new Random();
        
        for (int i = 0; i < NUM; i++) {
            double x = vect[r.nextInt(vect.length)];
            double y = vect[r.nextInt(vect.length)];
            ColorPicker lineColor = listColor.get(r.nextInt(listColor.size()));
            ColorPicker fillColor = listColor.get(r.nextInt(listColor.size()));
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
            
            Shape result = instance.createShape(gc, x, y, lineColor, fillColor, generatedString);
            try {
                assertNotNull(result);
                assertEquals(gc, result.getGraphicsContext());
                assertEquals(lineColor.getValue(), result.getLineColor().getValue());
                assertEquals(fillColor.getValue(), result.getFillColor().getValue());
                assertEquals(generatedString, result.getText());
            } catch (AssertionError ex) {
                fail("The createShape failed");
            }
        }
    }
    
}
