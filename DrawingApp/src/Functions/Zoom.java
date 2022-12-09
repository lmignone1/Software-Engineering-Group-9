/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Scale;

/**
 *
 * @author loren
 */
public class Zoom {

    private double zoomFactor;

    public static void zoom(Scale scale, double newX, double newY, double wheel) {
        double zoomFactor = 1.05;
        double currentScaleX = scale.getX();
        double currentScaleY = scale.getY();

        if (wheel < 0) {
            zoomFactor = 0.95;
        }

        if (currentScaleX >= 1.0) {
            if (currentScaleX == 1.0 && wheel < 0) {
                return;
            }
            scale.setX(currentScaleX * zoomFactor);
            scale.setY(currentScaleY * zoomFactor);
        } else {
            scale.setX(1.0);
            scale.setY(1.0);
        }

        scale.setPivotX(newX);
        scale.setPivotY(newY);
        
        
        /*
        double zoomFactor = 1.05;
        double wheel = event.getDeltaY();
        if (wheel < 0) {
            zoomFactor = 0.95;
        }
        double currentScaleX = drawingCanvas.getScaleX();
        double currentScaleY = drawingCanvas.getScaleY();
        if (currentScaleX >= 1.0) {
            if (currentScaleX == 1.0 && wheel < 0) {
                return;
            }
            drawingCanvas.setScaleX(currentScaleX * zoomFactor);
            drawingCanvas.setScaleY(currentScaleY * zoomFactor);
        } else {
            drawingCanvas.setScaleX(1.0);
            drawingCanvas.setScaleY(1.0);
        }
        */
    }
}
