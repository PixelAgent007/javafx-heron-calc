package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader mainView = new FXMLLoader(Main.class.getResource("main_view.fxml"));
        Scene mainScene = new Scene(mainView.load(), 640, 480);

        stage.setTitle("Rechner fürs Heron-Verfahren");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}