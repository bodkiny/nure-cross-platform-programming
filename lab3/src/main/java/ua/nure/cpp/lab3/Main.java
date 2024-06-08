package ua.nure.cpp.lab3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        ResizableCircle circle = new ResizableCircle(50);
        circle.setCenterX(100);
        circle.setCenterY(100);

        ResizableRectangle rectangle = new ResizableRectangle(100, 50);
        rectangle.setX(200);
        rectangle.setY(200);

        pane.getChildren().addAll(circle, rectangle);

        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
