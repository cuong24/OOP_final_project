package sample;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private ArrayList<Node> pathModel;

    public void importPath(List<Circle> path){
        for (int i = 0; i < 48; i++){
            pathModel.get(i).importCoordinate(path.get(i-1).localToScene(0, 0).getX() - 20, path.get(i-1).localToScene(0, 0).getY() - 695);
        }
    }
}
