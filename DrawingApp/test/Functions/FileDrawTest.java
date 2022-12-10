/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Functions;

import Factory.Creator;
import Shapes.Shape;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class FileDrawTest {

    private JFXPanel panel = new JFXPanel();
    private List<Shape> listShape;
    private List<Shape> listShapeResult;
    private String line1, line2, line3, line4, path, completePath;
    private GraphicsContext gc;
    private List<String> type;

    public FileDrawTest() {

        line1 = "Line 410.9523809523809 53.01587301587302 0x1a3399ff 0xffffffff 100.0 0.0 nothing";
        line2 = "Rectangle 130.95238095238093 237.53968253968253 0x4d804dff 0x4d1a4dff 100.0 50.0 nothing";
        line3 = "Ellipse 415.15873015873024 362.9365079365079 0x1a3399ff 0xe64d4dff 150.0 90.0 nothing";
        line4 = "Text 458.6666666666667 148.0 0x000000ff 0xe64d4dff 50.0 0.1 Test";
        
        type = new ArrayList<>();
        type.add("Line");
        type.add("Rectangle");
        type.add("Ellipse");
        type.add("Text");

        listShape = new ArrayList<>();
        Canvas c = new Canvas(1400, 1000);
        gc = c.getGraphicsContext2D();

        listShape.add(Creator.createShape(type.get(0), gc, 410.9523809523809, 53.01587301587302,
                new ColorPicker(Color.valueOf("0x1a3399ff")), new ColorPicker(Color.valueOf("0xffffffff")), 100.0, 0.0));

        listShape.add(Creator.createShape(type.get(1), gc, 130.95238095238093, 237.53968253968253,
                new ColorPicker(Color.valueOf("0x4d804dff")), new ColorPicker(Color.valueOf("0x4d1a4dff")), 100.0, 50.0));

        listShape.add(Creator.createShape(type.get(2), gc, 415.15873015873024, 362.9365079365079,
                new ColorPicker(Color.valueOf("0x1a3399ff")), new ColorPicker(Color.valueOf("0xe64d4dff")), 150.0, 90.0));

        listShape.add(Creator.createShape(type.get(3), gc, 458.6666666666667, 148.0, 
                new ColorPicker(Color.valueOf("0x000000ff")), new ColorPicker(Color.valueOf("0xe64d4dff")), 50.0, 0.1, "Test"));
        
        path = "prova";
        completePath = path + ".txt";
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        listShapeResult = new ArrayList<>();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of saveDraw method, of class FileDraw.
     */
    @Test
    public void testSaveDraw() throws IOException {
        System.out.println("saveDraw");
        
        FileDraw.saveDraw(listShape, path);
        
        FileReader f = new FileReader(completePath);
        BufferedReader b = new BufferedReader(f);
        try {
            assertNotNull(f);
            for (int i = 0; i < type.size(); i++) {
                String line = b.readLine();
                switch (type.get(i)) {
                    case "Line":
                        assertEquals(line1, line);
                        break;
                    case "Rectangle":
                        assertEquals(line2, line);
                        break;
                    case "Ellipse":
                        assertEquals(line3, line);
                        break;
                    case "Text":
                        assertEquals(line4, line);
                        break;
                }
            }
        } catch (AssertionError ex) {
            fail("The saveDraw failed");
        } catch (NullPointerException e2) {
            f.close();
            b.close();
        }
    }

    /**
     * Test of loadDraw method, of class FileDraw.
     */
    @Test
    public void testLoadDraw() throws Exception {
        System.out.println("loadDraw");
        
        FileDraw.loadDraw(listShapeResult, completePath, gc);
        
        try {
            assertNotNull(listShapeResult);
            assertEquals(listShape.size(), listShapeResult.size());
            for(int i = 0; i < listShape.size(); i++){
                assertEquals(listShape.get(i).getType(), listShapeResult.get(i).getType());
                assertEquals(gc, listShapeResult.get(i).getGraphicsContext());
                assertEquals(listShape.get(i).getLineColor().getValue(), listShapeResult.get(i).getLineColor().getValue());
                assertEquals(listShape.get(i).getX(), listShapeResult.get(i).getX(), 0);
                assertEquals(listShape.get(i).getY(), listShapeResult.get(i).getY(), 0);
                assertEquals(listShape.get(i).getSizeX(), listShapeResult.get(i).getSizeX(), 0);
                assertEquals(listShape.get(i).getPoint(), listShapeResult.get(i).getPoint());
                if(!listShape.get(i).getType().equals(type.get(0))){
                    assertEquals(listShape.get(i).getSizeY(), listShapeResult.get(i).getSizeY(), 0);
                    assertEquals(listShape.get(i).getFillColor().getValue(), listShapeResult.get(i).getFillColor().getValue());
                }
                if(listShape.get(i).getType().equals(type.get(3))){
                    assertEquals(listShape.get(i).getText(), listShapeResult.get(i).getText());
                }
            }
        } catch (AssertionError ex){
            fail("The loadFile failed");
        }
       
        
        
        
        
        
        
        
        
        
        
        
    }

}
