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
            }
        }));
        timelineBlue.setCycleCount(Animation.INDEFINITE);
        timelineBlue.play();
    }

    public void movePBall() {

        Ball pBall = new Ball();
        pBall.setX(2);
        pBall.setY(2);
        Timeline timelinePurple = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent actionEvent) {
                purpleBall.setLayoutX(purpleBall.getLayoutX() + pBall.getX());
                purpleBall.setLayoutY(purpleBall.getLayoutY() + pBall.getY());
                Bounds bounds = anchorPane.getBoundsInLocal();

                boolean rightBorder = purpleBall.getLayoutX() >= (bounds.getMaxX() - purpleBall.getRadius());
                boolean leftBorder = purpleBall.getLayoutX() <= (bounds.getMinX() + purpleBall.getRadius());
                boolean bottomBorder = purpleBall.getLayoutY() >= (bounds.getMaxY() - purpleBall.getRadius());
                boolean upperBorder = purpleBall.getLayoutY() <= (bounds.getMinY() + purpleBall.getRadius());


//
//                // checking balls by X
//                boolean axisX = (purpleBall.getLayoutX()+purpleBall.getRadius()) == 100;
//                // checking balls by Y
//                boolean axisY = (purpleBall.getLayoutY()+purpleBall.getRadius()) == 100;



                if (rightBorder || leftBorder) {
                    pBall.setX(pBall.getX()*(-1));
                }
                if (bottomBorder || upperBorder) {
                    pBall.setY(pBall.getY()*(-1));
                }


//                if(axisY)
//                {
//                    deltaPurpleY *=-1;
//                    System.out.println("I do exist");
//                }
            }

        }));
        timelinePurple.setCycleCount(Animation.INDEFINITE);
        timelinePurple.play();
        System.out.println(blueBall.getLayoutX());
        System.out.println(blueBall.getLayoutY());

        // checking balls by X
        boolean axisX1 = (purpleBall.getLayoutX()+purpleBall.getRadius()) == (blueBall.getRadius() + blueBall.getLayoutX());
        boolean axisX2 = (purpleBall.getLayoutX()-purpleBall.getRadius()) == (blueBall.getRadius() + blueBall.getLayoutX());
        boolean axisX3 = (purpleBall.getLayoutX()+purpleBall.getRadius()) == (blueBall.getRadius() - blueBall.getLayoutX());
        boolean axisX4 = (purpleBall.getLayoutX()-purpleBall.getRadius()) == (blueBall.getRadius() - blueBall.getLayoutX());
        // checking balls by Y
        boolean axisY1 = (purpleBall.getLayoutY()+purpleBall.getRadius()) == (blueBall.getRadius() + blueBall.getLayoutY());
        boolean axisY2 = (purpleBall.getLayoutY()-purpleBall.getRadius()) == (blueBall.getRadius() + blueBall.getLayoutY());
        boolean axisY3 = (purpleBall.getLayoutY()+purpleBall.getRadius()) == (blueBall.getRadius() - blueBall.getLayoutY());
        boolean axisY4 = (purpleBall.getLayoutY()-purpleBall.getRadius()) == (blueBall.getRadius() - blueBall.getLayoutY());

        if(axisX1 && axisY1 || axisX1 && axisY2 || axisX1 && axisY3 || axisX1 && axisY4
                || axisX2 && axisY1 || axisX2 && axisY2 || axisX2 && axisY3 || axisX2 && axisY4
                || axisX3 && axisY1 || axisX3 && axisY2 || axisX3 && axisY3 || axisX3 && axisY4
                || axisX4 && axisY1 || axisX4 && axisY2 || axisX4 && axisY3 || axisX4 && axisY4 )
        {
            pBall.setX(pBall.getX()*(-1));
            pBall.setY(pBall.getY()*(-1));
            System.out.println("I do exist");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        while(true)
        {movePBall();}
        //moveBBall();

    }


}