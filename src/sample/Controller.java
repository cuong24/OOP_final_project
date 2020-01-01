package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
    View view;
    Model model = new Model();
    Stage stage;

    static Controller instance;

    private Controller(){
        stage = new Stage();
        stage.setTitle("Ca ngua");
        view = new View();
        Scene scene = new Scene(view.map);
        stage.setScene(scene);
        model.importPath(view.);
    }

    public static Controller getInstance(){
        if (instance == null)
            instance = new Controller();
        return instance;
    }

    public void rollDice(){
        view.startRolling(model.roll());
    }

    public void update(){
        stage.show();
    }
}
