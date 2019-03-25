/**
 * @Author Filipe Malachias Resendee
 */


package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculator extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/TipCalculator.fxml"));
        primaryStage.setTitle("Tip Calculator");
        root.getStylesheets().add("sample/View/css/style.css");
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
