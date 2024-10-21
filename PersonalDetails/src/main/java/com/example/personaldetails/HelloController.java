package com.example.personaldetails;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldAge;
    @FXML
    private TextField textFieldColour;
    @FXML
    private Label labelName;
    @FXML
    private Label labelAge;
    @FXML
    private Label labelColor;
    @FXML
    private Label Display;

    private String name;
    private int age;
    private Color color;
    boolean flag = false;

    @FXML
    protected void onClearButtonClick(){
        labelName.setText("Enter your name");
        labelAge.setText("Enter your age in numbers");
        labelColor.setText("Enter a color or color hex code");
        textFieldName.setText(null);
        textFieldAge.setText(null);
        textFieldColour.setText(null);
    }

    @FXML
    protected void onSubmitButtonClick() {
        flag = false;
        if(textFieldName.getText() == null || textFieldName.getText().trim().isEmpty()) {
            flag = true;
            labelName.setText("Name cannot be empty!");
            textFieldName.clear();
        }
        if(textFieldAge.getText().trim().isEmpty() || textFieldAge.getText() == null) {
            flag = true;
            labelAge.setText("Age cannot be empty!");
            textFieldAge.clear();
        }
        if(textFieldAge.getText().chars().anyMatch(Character::isAlphabetic)){
            flag = true;
            labelAge.setText("Age cannot be expressed with letters!");
            textFieldAge.clear();
        }

        if(flag == false) {

            name = textFieldName.getText();
            age = Integer.parseInt(textFieldAge.getText());
            try {
                color = color.web(textFieldColour.getText());

            } catch (Exception e) {
                labelColor.setText("Please enter a real color");
                textFieldColour.clear();
            }
            Display.setStyle("Display-base-color:" + color.toString());
            Display.setText("Hello " + name + "! " + age + " is very old");
            onClearButtonClick();
        }

    }

}