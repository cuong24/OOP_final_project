package sample;

import javafx.scene.shape.Circle;

import java.util.List;

public class Model {
    Dice dice1 = new Dice(), dice2 = new Dice();
    Path pathM = new Path();
    private int[] diceNum = new int[2];

    public int[] roll(){
        diceNum[0] = dice1.roll();
        diceNum[1] = dice2.roll();
        return diceNum;
    }

    public void importPath(List<Circle> path){
        pathM.importPath(path);
    }

}
