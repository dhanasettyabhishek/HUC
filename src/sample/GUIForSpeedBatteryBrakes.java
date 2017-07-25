package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class GUIForSpeedBatteryBrakes extends Application {
    Stage window;
    //String speedData, batteryData, brakesDataOn, brakesDataOff, exp;
    //False data dor Speed and Battery percentage
    Random r = new Random();
    int low = 0;
    int high = 100;
    int result1 = r.nextInt(high-low) + low;
    String value1 = Integer.toString(result1);
    int result2 = r.nextInt(high-low) + low;
    String value2 = Integer.toString(result2);

    public static void main(String...args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        //Title
        window.setTitle("Speed, Battery and Brakes performance");
        //USing GridPane Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(10);
        grid.setHgap(10);

        //Setting Label and Input field
        Label speed = new Label("Speed(kmph):");
        GridPane.setConstraints(speed, 0, 0);
        TextField speedInput = new TextField(value1);
        speedInput.setPromptText("Speed in kmph");
        GridPane.setConstraints(speedInput, 1, 0);

        //Setting Label and Input field
        Label battery = new Label("Battery(%):");
        GridPane.setConstraints(battery, 0, 1);
        TextField batteryInput = new TextField(value2);
        batteryInput.setPromptText("Battery Percentage");
        GridPane.setConstraints(batteryInput, 1, 1);

        //Setting RadioButton
        Label brakes = new Label("Brakes(On/Off):");
        GridPane.setConstraints(brakes, 0, 2);
        final ToggleGroup group = new ToggleGroup();
        RadioButton on = new RadioButton("Brakes Applied");
        on.setToggleGroup(group);
        GridPane.setConstraints(on, 1, 2);
        RadioButton off = new RadioButton("Brakes are not Applied");
        off.setToggleGroup(group);
        GridPane.setConstraints(off, 1, 3);
        off.setSelected(true);

        //Validating the input.
        Button buttonValidate = new Button("Validate");
        GridPane.setConstraints(buttonValidate, 0, 4);
        buttonValidate.setOnAction(e -> {
            isInt(speedInput.getText(), batteryInput.getText(), on, off);
            //showData(speedInput.getText(), batteryInput.getText(), on, off);
        });

        //Closing the GUI
        Button buttonExit = new Button("Exit");
        GridPane.setConstraints(buttonExit, 1, 4);
        buttonExit.setOnAction(e -> {
            e.consume();
            closeProgram();
        } );

        grid.getChildren().addAll(speed, speedInput, battery, batteryInput, brakes, on, off, buttonValidate, buttonExit);
        Scene scene = new Scene(grid, 300, 300);
        window.setScene(scene);
        window.show();
    }

    //Validates the input values
    private boolean isInt(String speedInput, String batteryInput, RadioButton on, RadioButton off){
        try{
            float speed = Float.parseFloat(speedInput);
            System.out.println("Speed of the pod is: " + speed + " kmph");
            float battery = Float.parseFloat(batteryInput);
            System.out.println("Battery Percentage is:" + battery + " %");
            if(on.isSelected()){
                System.out.println("Brakes are Applied");
            }
            if(off.isSelected()){
                System.out.println("Brakes are not Applied");
            }
            return true;
        }catch (NumberFormatException e){
            System.out.println("Error exception:" + e);
            return false;
        }
    }
    /*public static void sendData(String speedInput, String batteryInput, RadioButton on, RadioButton off){

        try{
            float speed = Float.parseFloat(speedInput);
            String speedData = "Speed of the pod is: " + speed + " kmph";
            float battery = Float.parseFloat(batteryInput);
            String batteryData = "Battery Percentage is:" + battery + " %";
            if(on.isSelected()){
                String brakesDataOn = "Brakes are Applied";
            }
            if(off.isSelected()){
                String brakesDataOff = "Brakes are not Applied";
            }

        }catch (NumberFormatException e){
            String exp = "Error exception:" + e;
        }
        //dataBox.display(speedData, batteryData, brakesDataOn.toString(), brakesDataOff.toString(), exp.toString());
    }*/

    //Closes the program
    private void closeProgram(){
        Boolean answer = confirmBox.display("Exit Window", "Are you sure?");
        if(answer){
            window.close();
        }
    }
}
