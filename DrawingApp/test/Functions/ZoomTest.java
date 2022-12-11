/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Functions;

import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.DoubleStream;
import javafx.embed.swing.JFXPanel;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Scale;
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
public class ZoomTest {

    private JFXPanel panel = new JFXPanel();
    private double[] vect, vect2;
    private Scale scale;

    public ZoomTest() {
        vect = new double[100];
        vect2 = new double[100];
        Random r = new Random();
        DoubleStream stream = r.doubles(0, 999.999);
        int count = 0;
        PrimitiveIterator.OfDouble it = stream.iterator();
        while (count < vect.length / 2 && it.hasNext()) {
            vect[count] = it.nextDouble();
            count++;
        }
        stream = r.doubles(-999.999, 0);
        count = vect.length / 2;
        it = stream.iterator();
        while (count < vect.length && it.hasNext()) {
            vect[count] = it.nextDouble();
            count++;

        }
        stream = r.doubles(-999.999, 999.999);
        count = 0;
        it = stream.iterator();
        while (count < vect2.length && it.hasNext()) {
            vect2[count] = it.nextDouble();
            count++;
        }
        scale = new Scale();
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
     * Test of zoom method, of class Zoom.
     */
    @Test
    public void testZoom() {
        System.out.println("zoom");
        Random r = new Random();
        Scale expResult = new Scale();

        for (int i = 0; i < vect.length; i++) {
            double newX = vect2[r.nextInt(vect2.length)];
            double newY = vect2[r.nextInt(vect2.length)];
            double wheel = vect[i];
            double zoomFactor = 1.05;

            Zoom.zoom(scale, newX, newY, wheel);

            double currentScaleX = expResult.getX();
            double currentScaleY = expResult.getY();

            if (wheel < 0) {
                zoomFactor = 0.95;
            }

            if (currentScaleX >= 1.0) {
                if (!(currentScaleX == 1.0 && wheel < 0)) {
                    expResult.setX(currentScaleX * zoomFactor);
                    expResult.setY(currentScaleY * zoomFactor);
                }
            } else {
                expResult.setX(1.0);
                expResult.setY(1.0);
            }
            
            expResult.setPivotX(newX);
            expResult.setPivotY(newY);

            try {
                assertEquals(expResult.getX(), scale.getX(), 0);
                assertEquals(expResult.getY(), scale.getY(), 0);
                assertEquals(expResult.getPivotX(), scale.getPivotX(), 0);
                assertEquals(expResult.getPivotY(), scale.getPivotY(), 0);
            } catch (AssertionError ex) {
                fail("The zoom failed");
            }
        }
    }

}
