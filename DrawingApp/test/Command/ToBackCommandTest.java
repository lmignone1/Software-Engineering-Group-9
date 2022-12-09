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
 * @author Acer
 */
public class ToBackCommandTest {
    private JFXPanel panel = new JFXPanel();
    private ToBackCommand instance;
    
    private Select selectedShape;
    private Shape selectShape;
    private List<Shape> list;
    
    private double[] vect;
    private GraphicsContext gc;
    private List<ColorPicker> listColor = null;
    
    private Random r;
    
    private final int NUM = 10;
    
    public ToBackCommandTest() {
        vect = new double[100];
        r = new Random();
        DoubleStream stream = r.doubles(-999.999, 999.999);
        int count = 0;
        PrimitiveIterator.OfDouble it = stream.iterator();
        while(count < vect.length && it.hasNext()) {
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
        
        int leftLimit = 97; //letter a
        int rightLimit = 122; //letter z
        int targetStringLength = 10;
        Random random = new Random();
        
        Canvas canvas = new Canvas(1400, 1000);
        gc = canvas.getGraphicsContext2D();
        String[] type = {"Line", "Rectangle", "Ellipse", "Text"};
        list = new ArrayList<>();
        Creator c = new Creator();
        for(int i = 0; i < NUM; i++){
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
            
            Shape shape = c.createShape(type[r.nextInt(type.length)], gc, vect[r.nextInt(vect.length)], 
                    vect[r.nextInt(vect.length)],
                    listColor.get(r.nextInt(listColor.size())),
                    listColor.get(r.nextInt(listColor.size())),
                    vect[r.nextInt(vect.length)], vect[r.nextInt(vect.length)],
                    generatedString);
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
        instance = new ToBackCommand(selectedShape,list.indexOf(selectedShape.getSelectedShape()));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class ToBackCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        for(int i = 1; i < list.size(); i++){
        instance.execute();
        int expPosition=0;
        try {
                    assertEquals(expPosition,list.indexOf(selectedShape.getSelectedShape()));
                    assertEquals(selectedShape.getSelectedShape(),list.get(0));
            } catch(AssertionError ex){
                fail("ERROR-2: The execute ToBackCommand failed");
            }
        selectShape = list.get(i);
        selectedShape.setSelectedShape(selectShape);
    }
}
    /**
     * Test of undo method, of class ToBackCommand.
     */
    @Test
    public void testUndo() {
       System.out.println("undo");
       int expPosition;
       for(int i = 0; i < list.size(); i++){
       instance.execute();
       instance.undo();
       expPosition=list.indexOf(selectedShape.getSelectedShape());
        try {
            
            assertEquals(expPosition,list.indexOf(selectedShape.getSelectedShape()));
            assertEquals(selectedShape.getSelectedShape(),list.get(expPosition));
            } catch(AssertionError ex){
                fail("ERROR-2: The undo ToBackCommand failed");
            }
       selectShape = list.get(i);
       selectedShape.setSelectedShape(selectShape);
    }
        
    }
}
