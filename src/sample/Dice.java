package sample;

public class Dice {
    private int number = 1;

    public int roll(){
        number = (int)(Math.random()*6) + 1;
        return number;
    }
}
