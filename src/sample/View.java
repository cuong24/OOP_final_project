package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

public class View {
    @FXML
    public Pane map;
    @FXML
    public List<ImageView> player1, player2, player3, player4;
    @FXML
    Button button1;
    int dice1, dice2;
    int i = 41;
    Canvas canvas = new Canvas(100,100);

    public View() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("GameScene.fxml"));
            loader.setController(this);
            map = loader.load();
            map.getChildren().add(canvas);
        } catch (IOException e) {
            System.out.println("Error in GameScene");
        }
    }

    @FXML
    public void rollDice(ActionEvent e){
        Controller.getInstance().rollDice();
    }

    private int frameNumber;

    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            draw((int)(Math.random()*6) + 1,(int)(Math.random()*6) + 1);
            frameNumber++;
            if (frameNumber == 60) {
                draw(dice1, dice2);
                timer.stop();
            }
        }
    };

    public void startRolling(int[] diceNum) {
        dice1 = diceNum[0];
        dice2 = diceNum[1];
        canvas.setLayoutX(100);
        canvas.setLayoutY(100);
        draw(3,4);  // Draw the original dice.
        roll();
    }

    private void roll() {
        frameNumber = 0;
        timer.start(); // start an animation
    }

    private void drawDie(GraphicsContext g, int val, int x, int y) {
        g.setFill(Color.WHITE);
        g.fillRect(x, y, 35, 35);
        g.setStroke(Color.BLACK);
        g.strokeRect(x+0.5, y+0.5, 34, 34);
        g.setFill(Color.BLACK);
        if (val > 1)  // upper left dot
            g.fillOval(x+3, y+3, 9, 9);
        if (val > 3)  // upper right dot
            g.fillOval(x+23, y+3, 9, 9);
        if (val == 6) // middle left dot
            g.fillOval(x+3, y+13, 9, 9);
        if (val % 2 == 1) // middle dot (for odd-numbered val's)
            g.fillOval(x+13, y+13, 9, 9);
        if (val == 6) // middle right dot
            g.fillOval(x+23, y+13, 9, 9);
        if (val > 3)  // bottom left dot
            g.fillOval(x+3, y+23, 9, 9);
        if (val > 1)  // bottom right dot
            g.fillOval(x+23, y+23, 9,9);
    }

    private void draw(int dice1, int dice2) {
        GraphicsContext g = canvas.getGraphicsContext2D();
        drawDie(g, dice1 , 10, 10);
        drawDie(g, dice2, 55, 55);
    }
}
