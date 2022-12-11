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

    
public class ToMirrorCommandTest {
    //SELECT ATTRIBUTE
    private Select selectedShape;
    private Shape selectShape;
    private List<Shape> listShape;
    //TEST MOVE COMMAND ATTRIBUTE
    private JFXPanel panel; 
    private ToMirrorCommand instance;
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
    private int count,count2;
    private PrimitiveIterator.OfDouble it;
    private double[] degreesVect;
    
    public ToMirrorCommandTest() {
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
        degreesVect = new double[100];
        count2 = 0;
        stream = rand.doubles(-360.0, 360.001);
        it = stream.iterator();
        while (count < degreesVect.length && it.hasNext()) {
        degreesVect[count] = it.nextDouble();
        count2++;
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
                    vect[rand.nextInt(vect.length)],degreesVect[rand.nextInt(degreesVect.length)]);
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
        instance = new ToMirrorCommand(selectedShape,degreesVect[rand.nextInt(degreesVect.length)]);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class ToMirrorCommand.
     */
    @Test
    public void testExecute() {
       System.out.println("execute");
       int expPositionX = 0;
       int expPositionY = 0;
       int expDegrees = 0; 
       for(int i = 1; i < listShape.size(); i++){
           
        expPositionX= (int) (selectedShape.getSelectedShape().getX()+selectedShape.getSelectedShape().getSizeX());
        expPositionY= (int) (selectedShape.getSelectedShape().getY());
        expDegrees= (int) (selectedShape.getSelectedShape().getDegrees());
        instance.execute();
        /*System.out.println(selectedShape.getSelectedShape().getType());
        System.out.println(expPositionX);
        System.out.println((int)selectedShape.getSelectedShape().getX());
        System.out.println('\n');*/
        try{   
            
           assertEquals(expPositionX,(int)selectedShape.getSelectedShape().getX(),0);
           assertEquals(expPositionY,(int)selectedShape.getSelectedShape().getY(),0);   
           assertEquals(expDegrees,-(int)selectedShape.getSelectedShape().getDegrees(),0);    
            } catch(AssertionError ex){
                fail("ERROR-2: The execute ToMirrorCommand failed");
            }
        selectShape = listShape.get(i);
        selectedShape.setSelectedShape(selectShape);
    }
    }

    /**
     * Test of undo method, of class ToMirrorCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        for(int i = 1; i < listShape.size(); i++){
        
        int expPositionX = (int) (selectedShape.getSelectedShape().getX());
        int expPositionY = (int) selectedShape.getSelectedShape().getY();
        int expDegrees = (int) selectedShape.getSelectedShape().getDegrees();
        
        instance.execute();
        instance.undo();
        try{   
            assertEquals(expPositionX,(int)selectedShape.getSelectedShape().getX(),0);
            assertEquals(expPositionY,(int)selectedShape.getSelectedShape().getY(),0);   
            assertEquals(expDegrees,(int)selectedShape.getSelectedShape().getDegrees(),0);   
            } catch(AssertionError ex){
                fail("ERROR-2: The Undo ToMirrorCommand failed");
            }
        selectShape = listShape.get(i);
        selectedShape.setSelectedShape(selectShape);
    }
    }
    
}
