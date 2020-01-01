package sample;

import java.lang.reflect.Array;

public class Node {

    private double[] node = new double[2];

    public void importCoordinate(double coordinateX, double coordinateY){
        node[1] = coordinateX;
        node[2] = coordinateY;
    }

    public double[] getNode() {
        return node;
    }
}
