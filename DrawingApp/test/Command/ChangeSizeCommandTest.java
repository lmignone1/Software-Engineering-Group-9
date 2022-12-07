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
 * @author artem
 */
public class ChangeSizeCommandTest {    
    
    private double sizeX;
    private double sizeY;
    private double previousX;
    private double previousY;
    
    //SELECT ATTRIBUTE
    private Select selectedShape;
    private Shape selectShape;
    private List<Shape> listShape;
    //TEST CHANGE SIZE COMMAND ATTRIBUTE
    private JFXPanel panel; 
    private ChangeSizeCommand instance;
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
    
    public ChangeSizeCommandTest() {
        
        panel = new JFXPanel();
        listShape = new ArrayList<>();
        selectShape = null;
        selectedShape = new Select(listShape,selectShape);
        creator = new Creator();
        canvas = new Canvas(1400,1000);
        
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
        
        rand = new Random();
        vect = new double[100];
        stream = rand.doubles(-999.999,999.999);
        count = 0;
        it = stream.iterator();
        while(count < vect.length && it.hasNext()){
            vect[count] = it.nextDouble();
            count++;
        }
        for(int i = 0; i<NUM; i++){
            createdShape = Creator.createShape(type.get(rand.nextInt(type.size())), 
                    canvas.getGraphicsContext2D(), vect[rand.nextInt(vect.length)], 
                    vect[rand.nextInt(vect.length)], listColor.get(rand.nextInt(listColor.size())), 
                    listColor.get(rand.nextInt(listColor.size())));
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
        selectShape = listShape.get(rand.nextInt(listShape.size()));
        selectedShape.setSelectedShape(selectShape);
        instance = new ChangeSizeCommand(selectedShape, vect[rand.nextInt(vect.length)], vect[rand.nextInt(vect.length)], vect[rand.nextInt(vect.length)], vect[rand.nextInt(vect.length)]);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class ChangeSizeCommand.
     */
    @Test
    public void testExecute() {
       
        System.out.println("execute");
        
        for(int i = 0; i < listShape.size(); i++){
            
            instance.sizeX = vect[i]+vect[i];
            if(selectedShape.getSelectedShape().getType().equals("Rectangle") || selectedShape.getSelectedShape().getType().equals("Ellipse")){
                instance.sizeY = vect[i]*vect[i];
            }
            instance.execute();
            
            try{
                assertTrue(listShape.contains(selectShape));
                assertEquals(selectedShape.getSelectedShape().getSizeX(), instance.sizeX, 0);
                
                if(selectedShape.getSelectedShape().getType().equals("Rectangle") || selectedShape.getSelectedShape().getType().equals("Ellipse")){
                    assertEquals(selectedShape.getSelectedShape().getSizeY(), instance.sizeY, 0);
                }
                assertEquals(selectedShape.getPreviousX(),instance.previousX,0);
                assertEquals(selectedShape.getPreviousY(),instance.previousY,0);
            }catch(AssertionError ex){
                fail("The excute of ChangeSizeCommand failed");
            }
            selectShape = listShape.get(rand.nextInt(listShape.size()));
            selectedShape.setSelectedShape(selectShape);
        }
    }      

    /**
     * Test of undo method, of class ChangeSizeCommand.
     */
    @Test
    public void testUndo() {
        
        System.out.println("undo");
        /*
        double prevSY = 0;
        
        
        for(int i = 0; i < listShape.size(); i++){
            
            double prevSX = selectShape.getSizeX();
            instance.sizeX = vect[i]+vect[i];
            
            if(selectedShape.getSelectedShape().getType().equals("Rectangle") || selectedShape.getSelectedShape().getType().equals("Ellipse")){
                prevSY = selectShape.getSizeY();
                instance.sizeY = vect[i]*vect[i];                
            }
            
            instance.execute();
            instance.undo();
            
            try{
                assertTrue(listShape.contains(selectShape));
                assertEquals(selectedShape.getPreviousSizeX(),prevSX,0);
                
                if(selectedShape.getSelectedShape().getType().equals("Rectangle") || selectedShape.getSelectedShape().getType().equals("Ellipse")){
                    assertEquals(selectedShape.getPreviousSizeY(),prevSY,0);
                }
                assertEquals(selectedShape.getPreviousX(),instance.previousX,0);
                assertEquals(selectedShape.getPreviousY(),instance.previousY,0);
            }catch(AssertionError ex){
                fail("The excute of ChangeSizeCommand failed");
            }
            selectShape = listShape.get(rand.nextInt(listShape.size()));
            selectedShape.setSelectedShape(selectShape);
        }
        */
    }
    
}
