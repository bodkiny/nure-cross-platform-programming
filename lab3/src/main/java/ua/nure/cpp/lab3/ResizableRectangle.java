package ua.nure.cpp.lab3;

import javafx.scene.shape.Rectangle;

public class ResizableRectangle extends Rectangle {
    public ResizableRectangle(double width, double height) {
        super(width, height);
        enableDrag();
    }

    private void enableDrag() {
        final Delta dragDelta = new Delta();

        setOnMousePressed(e -> {
            dragDelta.x = getX() - e.getX();
            dragDelta.y = getY() - e.getY();
        });

        setOnMouseDragged(e -> {
            double newX = e.getX() + dragDelta.x;
            if (newX > 0 && newX < getScene().getWidth()) {
                setX(newX);
            }
            double newY = e.getY() + dragDelta.y;
            if (newY > 0 && newY < getScene().getHeight()) {
                setY(newY);
            }
        });

        setOnScroll(e -> {
            if (e.getDeltaY() > 0) {
                setWidth(getWidth() + 5);
                setHeight(getHeight() + 5);
            } else {
                setWidth(getWidth() - 5);
                setHeight(getHeight() - 5);
            }
        });
    }

    private class Delta {
        double x, y;
    }
}
