package sample;

public class SeaHorse {
    private int position = 0;

    public void move(int diceNumber){
        position += diceNumber;
    }

    public int setPosition(){
        return position;
    }
}
