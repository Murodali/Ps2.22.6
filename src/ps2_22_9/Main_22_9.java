package ps2_22_9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main_22_9 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample_22_9.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("ps2_22_9");
        stage.setScene(scene);
        stage.show();
    }
}
