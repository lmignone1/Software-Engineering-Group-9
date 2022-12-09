/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Decorator;

import javafx.embed.swing.JFXPanel;
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
public class ConcreteBorderPaneTest {
    
    private JFXPanel panel = new JFXPanel();
    private ConcreteBorderPane instance;
    private BorderPane borderPane;
      
    
    public ConcreteBorderPaneTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        borderPane = new BorderPane();
        instance = new ConcreteBorderPane(borderPane);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBorderPane method, of class ConcreteBorderPane.
     */
    @Test
    public void testGetBorderPane() {
        System.out.println("TEST: GetBorderPane");
        BorderPane result = instance.getBorderPane();
        try{
            assertNotEquals(null,result);
            assertEquals(borderPane, result);
        }catch(AssertionError ex){
             fail("ERROR: The GetBorderPane failed");
        }
       
    }

}
