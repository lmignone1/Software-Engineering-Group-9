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
    
    public ConcreteShapeLinesTest() {
        vect = new double[100];
        vect2 = new double[100];
        Random r = new Random();
        DoubleStream stream = r.doubles(-999.999, 999.999);
        int count = 0;
        PrimitiveIterator.OfDouble it = stream.iterator();
        while(count < 2*vect.length && it.hasNext()) {
            if (count < vect.length) {
                vect[count] = it.nextDouble();
            }
            else {
                vect2[count-vect.length] = it.nextDouble();
            }
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
        double currentX=instance.getX();
        double currentY=instance.getY();
        double[] X= vect;
        double[] Y= vect2;
        
        try {
            for(int i=0;i<vect.length;i++){
            instance.setX(X[i]);
            instance.setY(Y[i]);
            assertNotEquals(currentX, instance.getX());
            assertNotEquals(currentY, instance.getY());
            assertEquals(X[i], instance.getX(),0);
            assertEquals(Y[i], instance.getY(),0);
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
        Canvas drawingCanvas = new Canvas(1400, 1000);
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        Canvas expCanvas = new Canvas(1400, 1000);
        GraphicsContext expGC = expCanvas.getGraphicsContext2D();
        double[] startX= vect;
        double[] startY= vect2;
        instance.setGraphicsContext(gc);
        expGC.setLineWidth(2);
        double len = 100.0;
        Iterator<ColorPicker> it = listColor.iterator();
        
        for(int i = 0; i < vect.length; i++) {
            instance.setX(startX[i]);
            instance.setY(startY[i]);
            if (!it.hasNext()) {
                it = listColor.iterator();
            }
            ColorPicker color = it.next();
            instance.setLineColor(color);
            instance.draw();
            GraphicsContext instanceGC = instance.getGraphicsContext();
            expGC.setStroke(color.getValue());
            double x1 = startX[i] - len/2;
            double y1 = startY[i];
            double x2 = startY[i] + len/2;
            double y2 = startY[i];
            expGC.strokeLine(x1, y1, x2, y2);
            try {
                assertEquals(expGC.getStroke(), instanceGC.getStroke());
                assertEquals(expGC.getLineWidth(), instanceGC.getLineWidth(), 0);
                assertEquals(x1, instance.getX() - len/2, 0);
                assertEquals(y1, instance.getY(), 0);
                assertEquals(x2, instance.getY() + len/2, 0);
                assertEquals(y2, instance.getY(), 0);
            } catch (AssertionError ex){
                fail("The drawShape failed");
            }
        }
    }
    
}
