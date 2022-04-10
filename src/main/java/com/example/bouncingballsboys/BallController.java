package com.example.bouncingballsboys;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class BallController implements Initializable {

    @FXML private AnchorPane anchorPane;
    @FXML private Circle blueBall;
    @FXML private Circle purpleBall;

    public void moveBBall() {
        Timeline timelineBlue = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            double deltaBlueX = 2;
            double deltaBlueY = 2;

            @Override
            public void handle(ActionEvent actionEvent) {
                blueBall.setLayoutX(blueBall.getLayoutX() + deltaBlueX);
                blueBall.setLayoutY(blueBall.getLayoutY() + deltaBlueY);

                Bounds bounds = anchorPane.getBoundsInLocal();
                boolean rightBorder = blueBall.getLayoutX() >= (bounds.getMaxX() - blueBall.getRadius());
                boolean leftBorder = blueBall.getLayoutX() <= (bounds.getMinX() + blueBall.getRadius());
                boolean bottomBorder = blueBall.getLayoutY() >= (bounds.getMaxY() - blueBall.getRadius());
                boolean upperBorder = blueBall.getLayoutY() <= (bounds.getMinY() + blueBall.getRadius());

                if (rightBorder || leftBorder) {
                    deltaBlueX *= -1;
                }
                if (bottomBorder || upperBorder) {
                    deltaBlueY *= -1;
                }

                // collision detection:
                double dx = blueBall.getLayoutX() - purpleBall.getLayoutX();
                double dy = blueBall.getLayoutY() - purpleBall.getLayoutY();
                double distance = Math.sqrt(dx * dx + dy * dy);

                if (distance < blueBall.getRadius() + purpleBall.getRadius()){
                    deltaBlueX *= -1;
                    deltaBlueY *= -1;
                }

            }
        }));
        timelineBlue.setCycleCount(Animation.INDEFINITE);
        timelineBlue.play();
    }

    public void movePBall() {
        Timeline timelinePurple = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            double deltaPurpleX = 1;
            double deltaPurpleY = 1;


            @Override
            public void handle(ActionEvent actionEvent) {
                purpleBall.setLayoutX(purpleBall.getLayoutX() + deltaPurpleX);
                purpleBall.setLayoutY(purpleBall.getLayoutY() + deltaPurpleY);
                Bounds bounds = anchorPane.getBoundsInLocal();

                boolean rightBorder = purpleBall.getLayoutX() >= (bounds.getMaxX() - purpleBall.getRadius());
                boolean leftBorder = purpleBall.getLayoutX() <= (bounds.getMinX() + purpleBall.getRadius());
                boolean bottomBorder = purpleBall.getLayoutY() >= (bounds.getMaxY() - purpleBall.getRadius());
                boolean upperBorder = purpleBall.getLayoutY() <= (bounds.getMinY() + purpleBall.getRadius());

                if (rightBorder || leftBorder) {
                    deltaPurpleX *= -1;
                }
                if (bottomBorder || upperBorder) {
                    deltaPurpleY *= -1;
                }

                double dx = blueBall.getLayoutX() - purpleBall.getLayoutX();
                double dy = blueBall.getLayoutY() - purpleBall.getLayoutY();
                double distance = Math.sqrt(dx * dx + dy * dy);

                if (distance < blueBall.getRadius() + purpleBall.getRadius()){
                    deltaPurpleX *= -1;
                    deltaPurpleY *= -1;
                }
            }

        }));
        timelinePurple.setCycleCount(Animation.INDEFINITE);
        timelinePurple.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        moveBBall();
        movePBall();

    }


}