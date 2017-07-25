package sample;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class dataBox extends Application {
    Stage window;
    String input1, input2, input3, input4, input5;

    public static void main(String...args){
        launch(args);
    }
    public void data(String speedInput, String batteryInput, RadioButton on, RadioButton off){

        //GUIForSpeedBatteryBrakes.sendData(input1, input2, input3.toString(), input4.toString(), input5.toString());

        input1 = speedInput;
        input2 = batteryInput;
        input3 = on.toString();
        input4 = off.toString();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        window = primaryStage;
        //window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Details:");
        window.setMinWidth(250);

        Label label = new Label(input1);
        Label label1 = new Label("two");
        //label.setText(batteryInput);

        Label label2 = new Label("three");
        //label.setText(on);

        Label label3 = new Label("four");
        //label.setText(off);

        Label label4 = new Label("five");
        //label.setText(exp);

        Button okButton  = new Button("Ok!");
        okButton.setOnAction(e -> {
            window.close();
        });


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, label1, label2, label3, label4);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
}
