package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Croatia Currency List");
        window.setScene(new Scene(root, 586, 400));
        window.setResizable(false);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
