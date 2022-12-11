/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import Factory.Creator;
import Memory.Memory;
import Shapes.Shape;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author Davide //Receiver
 */
public class Select {

    private List<Shape> list;
    private Shape selectedShape;
    private Shape copyShape;
    private Creator creator = new Creator();
    private Shape pasteShape;
    private Memory memory;
    private double deg;

    public Select(List<Shape> listShape, Shape selectedShape) {
        this.list = listShape;
        this.selectedShape = selectedShape;
        this.memory = new Memory();

    }

    public List<Shape> getShape() {
        return list;
    }

    public Shape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }

    public Shape getCopyShape() {
        return copyShape;
    }

    public void setCopyShape(Shape copyShape) {
        this.copyShape = copyShape;
    }

    public Memory getMemory() {
        return memory;
    }

    public Shape getPasteShape() {
        return pasteShape;
    }

    public void delete() {

        if (this.selectedShape == null) {
            return;
        }

        this.list.remove(this.selectedShape);
        this.memory.addStackShape(this.selectedShape);
    }

    public void copy() {

        if (this.selectedShape == null) {
            return;
        }

        if (this.getSelectedShape().getType().equals("Line")) {
            this.copyShape = creator.createShape(this.selectedShape.getType(), this.selectedShape.getGraphicsContext(), this.selectedShape.getX(), this.selectedShape.getY(), this.selectedShape.getLineColor(), null, this.selectedShape.getSizeX(), 0, this.selectedShape.getDegrees());
        } else if (this.getSelectedShape().getType().equals("Text")) {
            this.copyShape = creator.createShape(this.selectedShape.getType(), this.selectedShape.getGraphicsContext(), this.selectedShape.getX(), this.selectedShape.getY(), this.selectedShape.getLineColor(), this.selectedShape.getFillColor(), this.selectedShape.getSizeX(), this.selectedShape.getSizeY(), this.selectedShape.getText(), this.getSelectedShape().getDegrees());
        } else if (this.getSelectedShape().getType().equals("IrregularPolygon")) {
            this.copyShape = this.selectedShape.clone();
        } else {
            this.copyShape = creator.createShape(this.selectedShape.getType(), this.selectedShape.getGraphicsContext(), this.selectedShape.getX(), this.selectedShape.getY(), this.selectedShape.getLineColor(), this.selectedShape.getFillColor(), this.selectedShape.getSizeX(), this.selectedShape.getSizeY(), this.getSelectedShape().getDegrees());
        }

        this.memory.addStackShape(this.copyShape);
    }

    public void paste(double x, double y) {

        if (this.copyShape == null) {
            return;
        }

        if (this.copyShape.getType().equals("Line")) {
            this.pasteShape = creator.createShape(this.copyShape.getType(), this.copyShape.getGraphicsContext(), this.copyShape.getX(), this.copyShape.getY(), this.copyShape.getLineColor(), null, this.copyShape.getSizeX(), 0, this.copyShape.getDegrees());
        } else if (this.copyShape.getType().equals("Text")) {
            this.pasteShape = creator.createShape(this.copyShape.getType(), this.copyShape.getGraphicsContext(), this.copyShape.getX(), this.copyShape.getY(), this.copyShape.getLineColor(), this.copyShape.getFillColor(), this.copyShape.getSizeX(), this.copyShape.getSizeY(), this.copyShape.getText(), this.copyShape.getDegrees());
        } else if (this.copyShape.getType().equals("IrregularPolygon")) {
            this.pasteShape = creator.createShape(this.copyShape.getType(), this.copyShape.getGraphicsContext(), 0, 0, this.copyShape.getLineColor(), this.copyShape.getFillColor());

        } else {
            this.pasteShape = creator.createShape(this.copyShape.getType(), this.copyShape.getGraphicsContext(), this.copyShape.getX(), this.copyShape.getY(), this.copyShape.getLineColor(), this.copyShape.getFillColor(), this.copyShape.getSizeX(), this.copyShape.getSizeY(), this.copyShape.getDegrees());
        }
        if (this.pasteShape.getType().equals("IrregularPolygon")) {
            double distX;
            double distY;
            double startX = this.copyShape.getAllX()[0];
            double startY = this.copyShape.getAllY()[0];
            Point2D point = new Point2D(startX, startY);
            Point2D clickPointX = new Point2D(x, startY);
            Point2D clickPointY = new Point2D(startX, y);
            distX = point.distance(clickPointX);
            distY = point.distance(clickPointY);

            if (x > startX && y > startY) {

            } else if (x < startX && y < startY) {
                distX = -distX;
                distY = -distY;
            } else if (x < startX && y > startY) {
                distX = -distX;
            } else if (x > startX && y < startY) {
                distY = -distY;
            }

            for (int i = 0; i < this.copyShape.getVertices(); i++) {

                double pastX = this.copyShape.getAllX()[i];
                double pastY = this.copyShape.getAllY()[i];

                double newX = pastX + distX;
                double newY = pastY + distY;

                this.pasteShape.setXY(newX, newY);

            }

        } else {
            this.pasteShape.setXY(x, y);
        }

        this.list.add(this.pasteShape);
        this.memory.addStackShape(this.pasteShape);
    }

    public void cut() {

        if (this.selectedShape == null) {
            return;
        }

        this.copyShape = this.selectedShape;
        delete();
    }

    public void move(double newX, double newY, double previousX, double previousY) {

        if (this.selectedShape == null) {
            return;
        }

        if (this.selectedShape.getType().equals("IrregularPolygon")) {
            double distX;
            double distY;

            double startX = this.selectedShape.getAllX()[0];
            double startY = this.selectedShape.getAllY()[0];

            Point2D point = new Point2D(startX, startY);
            Point2D clickPointX = new Point2D(newX, startY);
            Point2D clickPointY = new Point2D(startX, newY);
            distX = point.distance(clickPointX);
            distY = point.distance(clickPointY);

            if (newX > startX && newY > startY) {

            } else if (newX < startX && newY < startY) {
                distX = -distX;
                distY = -distY;
            } else if (newX < startX && newY > startY) {
                distX = -distX;
            } else if (newX > startX && newY < startY) {
                distY = -distY;
            }

            ArrayList<Double> arrayListX = new ArrayList<>();
            ArrayList<Double> arrayListY = new ArrayList<>();
            this.selectedShape.setPolygonX(arrayListX);
            this.selectedShape.setPolygonY(arrayListY);

            for (int i = 0; i < this.selectedShape.getVertices(); i++) {

                double pastX = this.selectedShape.getAllX()[i];
                double pastY = this.selectedShape.getAllY()[i];

                double setX = pastX + distX;
                double setY = pastY + distY;

                this.selectedShape.setXY(setX, setY);
            }

            this.memory.addStackDouble(startY);
            this.memory.addStackDouble(startX);
        } else {
            this.selectedShape.setXY(newX, newY);
            this.memory.addStackDouble(previousY);
            this.memory.addStackDouble(previousX);
        }

        this.memory.addStackShape(this.selectedShape);
    }

    public void changeColor(ColorPicker lineColor, ColorPicker fillColor) {

        if (this.selectedShape == null) {
            return;
        }

        if (this.selectedShape.getType().equals("Line")) {

            this.memory.addStackColor(this.selectedShape.getLineColor());
        } else {
            this.memory.addStackColor(this.selectedShape.getLineColor());
            this.memory.addStackColor(this.selectedShape.getFillColor());
        }

        if (this.selectedShape.getType().equals("Line")) {
            this.selectedShape.setLineColor(lineColor);

        } else {
            this.selectedShape.setLineColor(lineColor);
            this.selectedShape.setFillColor(fillColor);
        }
        this.memory.addStackShape(this.selectedShape);
    }

    public void changeSize(double sizeX, double sizeY) {

        if (this.selectedShape == null) {
            return;
        }

        if (this.selectedShape.getType().equals("Line")) {

            this.memory.addStackDouble(this.selectedShape.getY());
            this.memory.addStackDouble(this.selectedShape.getX() + this.selectedShape.getSizeX() / 2);
            this.memory.addStackDouble(this.selectedShape.getSizeX());

        } else {

            this.memory.addStackDouble(this.selectedShape.getY() + this.selectedShape.getSizeY() / 2);
            this.memory.addStackDouble(this.selectedShape.getX() + this.selectedShape.getSizeX() / 2);
            this.memory.addStackDouble(this.selectedShape.getSizeY());
            this.memory.addStackDouble(this.selectedShape.getSizeX());

        }

        if (this.selectedShape.getType().equals("Line")) {
            this.selectedShape.setSizeX(sizeX);
            this.selectedShape.setXY(this.selectedShape.getX() + this.selectedShape.getSizeX() / 2, this.selectedShape.getY());
        } else {
            this.selectedShape.setSizeX(sizeX);
            this.selectedShape.setSizeY(sizeY);
            this.selectedShape.setXY(this.selectedShape.getX() + this.selectedShape.getSizeX() / 2, this.selectedShape.getY() + this.selectedShape.getSizeY() / 2);
        }
        this.memory.addStackShape(this.selectedShape);
    }

    public void toFront(double index) {
        list.remove(selectedShape);
        list.add((int) index - 1, selectedShape);
        this.memory.addStackShape(selectedShape);
    }

    public void toBack(double index) {
        list.remove(selectedShape);
        list.add((int) index, selectedShape);
        this.memory.addStackShape(selectedShape);
    }

    public void rotate(double degrees) {

        if (this.selectedShape == null) {
            return;
        }

        this.memory.addStackDouble(selectedShape.getDegrees());
        this.selectedShape.setDegrees(degrees);
        this.memory.addStackShape(selectedShape);
    }

    public void toMirror(double degrees) {
        deg = selectedShape.getDegrees();
        if (this.selectedShape == null) {
            return;
        }

        this.memory.addStackDouble(selectedShape.getDegrees());
        this.selectedShape.setDegrees(degrees);
        this.memory.addStackShape(selectedShape);

        if (selectedShape.getType() != "Line") {
            this.memory.addStackDouble(selectedShape.getDegrees());
            this.selectedShape.setDegrees(-deg);
            selectedShape.setXY(selectedShape.getX() + 1.5 * selectedShape.getSizeX(), selectedShape.getY() + 0.5 * selectedShape.getSizeY());
        } else {
            this.memory.addStackDouble(selectedShape.getDegrees());
            this.selectedShape.setDegrees(-deg);
            selectedShape.setXY(selectedShape.getX() + 1.5 * selectedShape.getSizeX(), selectedShape.getY());
        }

    }
}
