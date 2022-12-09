/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Decorator;

import javafx.embed.swing.JFXPanel;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
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
public class ScrollBarsBorderPaneTest {
    
    private JFXPanel panel = new JFXPanel();
    private ScrollBarsBorderPane instance;
    private BorderPaneComponent concreteBorderPane;
    private BorderPane borderPane;
    private Canvas canvas;
    
    public ScrollBarsBorderPaneTest() {
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
        borderPane = new BorderPane();
        concreteBorderPane = new ConcreteBorderPane(borderPane);
        instance = new ScrollBarsBorderPane(concreteBorderPane,canvas);
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of setScrollBars method, of class ScrollBarsBorderPane.
     */
    @Test
    public void testSetScrollBars() {
        System.out.println("TEST: SetScrollBars");
        
        ScrollPane scrollPane;
        instance.setScrollBars();
        scrollPane = (ScrollPane) instance.borderPane.getBorderPane().getCenter();
        try{
            assertNotEquals(null,instance.borderPane);
            assertFalse(instance.borderPane.getBorderPane().getChildren().isEmpty());
            assertTrue(instance.borderPane.getBorderPane().getCenter() instanceof ScrollPane);
            
            assertEquals(canvas,scrollPane.getContent());
            assertNotEquals(null,scrollPane);
            assertEquals(ScrollPane.ScrollBarPolicy.AS_NEEDED,scrollPane.getHbarPolicy());
            assertEquals(ScrollPane.ScrollBarPolicy.AS_NEEDED,scrollPane.getVbarPolicy());

        }catch(AssertionError ex){
            fail("ERROR: SetScrollBars failed");
        }
        
        
       

    }
    
}
