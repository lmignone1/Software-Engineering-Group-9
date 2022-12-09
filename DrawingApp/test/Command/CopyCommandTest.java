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
 * @author Davide
 */
public class CopyCommandTest {
    
    //SELECT ATTRIBUTE
    private Select selectedShape;
    private Shape selectShape;
    private List<Shape> listShape;
    //TEST COPY COMMAND ATTRIBUTE
    private JFXPanel panel; 
    private CopyCommand instance;
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
    
    
    public CopyCommandTest() {
        
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
        type.add("Text");
        
        int leftLimit = 97; //letter a
        int rightLimit = 122; //letter z
        int targetStringLength = 10;
        Random random = new Random();
        
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
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
            
            createdShape = Creator.createShape(type.get(rand.nextInt(type.size())), 
                    canvas.getGraphicsContext2D(), vect[rand.nextInt(vect.length)], 
                    vect[rand.nextInt(vect.length)], listColor.get(rand.nextInt(listColor.size())), 
                    listColor.get(rand.nextInt(listColor.size())), vect[rand.nextInt(vect.length)],
                    vect[rand.nextInt(vect.length)], generatedString);
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
        instance = new CopyCommand(selectedShape);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class CopyCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("TEST: execute copyCommand");
        String expType;
        GraphicsContext expGc;
        double expX,expY;
        ColorPicker expLineColor,expFillColor;
       
        
        for(int i = 1; i < listShape.size(); i++){
            
            expType = selectShape.getType();
            expGc = selectShape.getGraphicsContext();
            expLineColor = selectShape.getLineColor();
            
            if(expType.equals("Line")){
                expX = selectShape.getX() - (selectShape.getSizeX()/2);
                expY = selectShape.getY();
                expFillColor = null;
            }else{
                expX = selectShape.getX() - (selectShape.getSizeX()/2);
                expY = selectShape.getY() - (selectShape.getSizeY()/2);
                expFillColor = selectShape.getFillColor();
                
            }
            
            instance.execute();
            try{
                assertEquals(expType,selectedShape.getCopyShape().getType());
                assertEquals(expGc,selectedShape.getCopyShape().getGraphicsContext());
                assertEquals(expX,selectedShape.getCopyShape().getX(),0);
                assertEquals(expY,selectedShape.getCopyShape().getY(),0);
                assertEquals(expLineColor.getValue(),selectedShape.getCopyShape().getLineColor().getValue());
                assertFalse(selectedShape.getMemory().getStackShape().isEmpty());
                assertTrue(selectedShape.getMemory().getStackShape().contains(selectedShape.getCopyShape()));
                
                if(!expType.equals("Line")){
                    assertEquals(expFillColor.getValue(),selectedShape.getCopyShape().getFillColor().getValue());
                }
                assertNotEquals(selectedShape.getCopyShape(),selectedShape.getSelectedShape());
            }catch(AssertionError ex){
                fail("ERROR: The excute of CopyCommand failed");
            }
            selectShape = listShape.get(i);
            selectedShape.setSelectedShape(selectShape);
        }
    }

    /**
     * Test of undo method, of class CopyCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("TEST: Undo copyCommand");
        
        for(int i = 1; i < listShape.size(); i++){
            instance.execute();
            instance.undo();
            try{
                assertEquals(null,selectedShape.getCopyShape());
                assertNotEquals(selectedShape.getSelectedShape(),selectedShape.getCopyShape());
                assertTrue(selectedShape.getMemory().getStackShape().isEmpty());
                assertFalse(selectedShape.getMemory().getStackShape().contains(selectedShape.getCopyShape()));
                
            }catch(AssertionError ex){
                fail("ERROR: The undo of CopyCommand failed");
            }
            selectShape = listShape.get(i);
            selectedShape.setSelectedShape(selectShape);
        }
        
    }
    
    /**
     * Test2 of undo method, of class CopyCommand.
     */
    @Test
    public void testUndo2() {
        System.out.println("TEST2: Undo copyCommand");
        
        Shape expShape;
        
        for(int i = 0; i < listShape.size(); i++){
            instance.execute();
            selectShape = listShape.get(i);
            selectedShape.setSelectedShape(selectShape);
        }
        
        for(int i = 0; i < listShape.size(); i++){
            expShape = selectedShape.getMemory().getStackShape().peek();
            instance.undo();
            try{
                assertEquals(null,selectedShape.getCopyShape());
                assertFalse(selectedShape.getMemory().getStackShape().contains(expShape));
                
            }catch(AssertionError ex){
                fail("ERROR-2: The undo of CopyCommand failed");
            }
        }
        
    }
    
    
    
    
    
}
