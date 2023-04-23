package com.example.bmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;



public class BMIController {

    public Label weightLabel;
    public Label heightLabel;
    public Label BMILabel;
    public Label statusLabel;
    @FXML
    private TextField bmiTextField;

    @FXML
    private Button calculateButton;

    @FXML
    private TextField heightTextField;

    @FXML
    private RadioButton rButton1;

    @FXML
    private RadioButton rButton2;

    @FXML
    private TextField statusTextField;

    @FXML
    private ToggleGroup units;

    @FXML
    private TextField weightTextField;
    String unit;
    String status;
    double bmi;
    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try{
            double weight = Double.parseDouble(weightTextField.getText());
            double height = Double.parseDouble(heightTextField.getText());

            if(unit == "Metric"){
                bmi = weight / Math.pow(height, 2);
            }
            else{
                bmi = 703 * (weight / Math.pow(height, 2));
            }

            if(bmi < 18.5){
                status = "Underweight";
                statusTextField.setText(status);
            } else if (18.5 <= bmi && bmi <= 24.9) {
                status = "Normal";
                statusTextField.setText(status);
            } else if (25 <= bmi && bmi <= 29.9) {
                status = "Overweight";
                statusTextField.setText(status);
            } else{
                status = "Obese";
                statusTextField.setText(status);
            }

            bmiTextField.setText(String.valueOf(bmi));
        }

        catch (Exception ex){
            weightTextField.setText("Enter amount");
            weightTextField.selectAll();
            weightTextField.requestFocus();

            heightTextField.setText("Enter amount");
            heightTextField.selectAll();
            heightTextField.requestFocus();
        }
    }

    @FXML
    void getUnits(ActionEvent event) {
        if(rButton1.isSelected()){
            unit = "Metric";
        }
        else{
            unit = "English";
        }
    }
}
