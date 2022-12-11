/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Decorator;

import java.util.Random;
import javafx.embed.swing.JFXPanel;
import javafx.scene.canvas.Canvas;
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
public class GridDecoratorTest {

    private JFXPanel panel = new JFXPanel();
    private GridDecorator instance;
    private CanvasComponent concreteCanvas;
    private Canvas canvas;

    public GridDecoratorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        canvas = new Canvas();
        concreteCanvas = new ConcreteCanvas(canvas);
        instance = new GridDecorator(concreteCanvas);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class GridDecorator.
     */
    @Test
    public void testExecute() {
        Random r = new Random();
        int random;
        for (int i = 0; i < 10; i++) {
            random = r.nextInt(999);
            instance.setGridSizeInput(random);

            try {
                assertEquals(canvas, instance.getCanvas());
                assertEquals(instance.getGridSizeInput(), random);
            } catch (AssertionError ex) {
                fail("execute is failed");
            }
        }
    }

}
