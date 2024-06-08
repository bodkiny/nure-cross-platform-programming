package ua.nure.cpp.lab3;

import javafx.scene.shape.Circle;

public class ResizableCircle extends Circle {
    public ResizableCircle(double radius) {
        super(radius);
        enableDrag();
    }

    private void enableDrag() {
        final Delta dragDelta = new Delta();

        setOnMousePressed(e -> {
            dragDelta.x = getCenterX() - e.getX();
            dragDelta.y = getCenterY() - e.getY();
        });

        setOnMouseDragged(e -> {
            double newX = e.getX() + dragDelta.x;
            if (newX > 0 && newX < getScene().getWidth()) {
                setCenterX(newX);
            }
            double newY = e.getY() + dragDelta.y;
            if (newY > 0 && newY < getScene().getHeight()) {
                setCenterY(newY);
            }
        });

        setOnScroll(e -> {
            if (e.getDeltaY() > 0) {
                setRadius(getRadius() + 5);
            } else {
                setRadius(getRadius() - 5);
            }
        });
    }

    private class Delta {
        double x, y;
    }
}
