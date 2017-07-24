package sample;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class helloWorld extends Application {

    Stage window;
    public static void main(String... args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Setting Title
        window = primaryStage;
        window.setTitle("Hello World");
        //Content in the window
        Label label = new Label();
        label.setText("Hello World!");
        // Layout Vertical Box
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label);
        layout.setAlignment(Pos.CENTER);
        //Customization and Showing the window
        Scene scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.show();
    }
}
