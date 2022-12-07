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
public class MoveCommandTest {
    
    //SELECT ATTRIBUTE
    private Select selectedShape;
    private Shape selectShape;
    private List<Shape> listShape;
    //TEST MOVE COMMAND ATTRIBUTE
    private JFXPanel panel; 
    private MoveCommand instance;
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
    private final int NUM = 30;
    private Shape createdShape;
    //RANDOM
    private Random rand;
    private double[] vect;
    private DoubleStream stream;
    private int count;
    private PrimitiveIterator.OfDouble it;
  
    
    public MoveCommandTest() {
        
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
        selectShape = listShape.get(0);
        selectedShape.setSelectedShape(selectShape);
        instance = new MoveCommand(selectedShape,vect[0],vect[1],vect[2],vect[3]);
       }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testExecute() {
       System.out.println("TEST: Execute moveCommand");
           
       double expX = vect[0] - selectedShape.getSelectedShape().getSizeX()/2;
       double expY;
       double expPreX = vect[2];
       double expPreY = vect[3];
       
       if(selectedShape.getSelectedShape().getType().equals("Line")){
           expY = vect[1];
       }else{
           expY = vect[1] - selectedShape.getSelectedShape().getSizeY()/2;
       }
       
       int count = 4;
            
       for(int i = 0; i < listShape.size(); i++){
            
            instance.execute();

            try{
                assertTrue(listShape.contains(selectShape));
                assertEquals(expX,selectedShape.getSelectedShape().getX(),0);
                assertEquals(expY,selectedShape.getSelectedShape().getY(),0);
                assertTrue(selectedShape.getMemory().getStackDouble().contains(expPreX));
                assertTrue(selectedShape.getMemory().getStackDouble().contains(expPreY));
            }catch(AssertionError ex){
                fail("The excute of moveCommand failed");
            }

            selectShape = listShape.get(i);
            selectedShape.setSelectedShape(selectShape);
            instance = new MoveCommand(selectedShape,vect[count+4],vect[count+5],vect[count+6],vect[count+7]);


            expX = vect[count+4] - selectedShape.getSelectedShape().getSizeX()/2; 
            expPreX = vect[count+6];
            expPreY = vect[count+7];

            if(selectedShape.getSelectedShape().getType().equals("Line")){
               expY = vect[count+5];
            }else{
               expY = vect[count+5] - selectedShape.getSelectedShape().getSizeY()/2;
            }
        }
    }

    /**
     * Test of undo method, of class DeleteCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        
        
        /*
        for(int i = 0; i < listShape.size(); i++){
           
            instance.previousX=vect[i]+vect[i];
            instance.previousY=vect[i]*vect[i];
            instance.execute();
            instance.undo();
            try{
                assertTrue(listShape.contains(selectShape));
                
                
                assertEquals(selectedShape.getPreviousX(),instance.previousX,0);
                assertEquals(selectedShape.getPreviousY(),instance.previousY,0);
                
            }catch(AssertionError ex){
                fail("The undo of moveCommand failed");
            }
            selectShape = listShape.get(rand.nextInt(listShape.size()));
            selectedShape.setSelectedShape(selectShape);
        }
        */
    }
    
}