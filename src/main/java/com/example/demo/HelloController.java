package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label questionsBar;
    @FXML
    private Button buttonA;
    @FXML
    private Button buttonB;
    @FXML
    private Button buttonC;
    @FXML
    private Button buttonD;

    @FXML
    protected void onHelloButtonClick() {
        questionsBar.setText("Welcome to JavaFX Application!");
    }
    public void initialize(){
        Vocab.generateVocab();
        resetcolor();
        String [] wordChoices =Gamelogic.generateWordChoices(Vocab.vocabList, Gamelogic.getVocab().word);
        buttonA.setText(wordChoices[0]);
        buttonB.setText(wordChoices[1]);
        buttonC.setText(wordChoices[2]);
        buttonD.setText(wordChoices[3]);
    }

    public void buttonclicked(ActionEvent itemClicked){
        Button buttonclicked = (Button)itemClicked.getSource() ;
        resetcolor();
        buttonclicked.setStyle("-fx-background-color: #FFFF00;-fx-text-fill: black;-fx-font-size: 14px;");
    }

    public void submitClicked(ActionEvent itemClicked){
        String [] wordChoices =Gamelogic.generateWordChoices(Vocab.vocabList, Gamelogic.getVocab().word);
        buttonA.setText(wordChoices[0]);
        buttonB.setText(wordChoices[1]);
        buttonC.setText(wordChoices[2]);
        buttonD.setText(wordChoices[3]);

    }
    public void resetcolor(){
        buttonA.setStyle("-fx-background-color: #d3d3d3;-fx-text-fill: white;-fx-font-size: 14px;");
        buttonB.setStyle("-fx-background-color: #d3d3d3;-fx-text-fill: white;-fx-font-size: 14px;");
        buttonC.setStyle("-fx-background-color: #d3d3d3;-fx-text-fill: white;-fx-font-size: 14px;");
        buttonD.setStyle("-fx-background-color: #d3d3d3;-fx-text-fill: white;-fx-font-size: 14px;");
    }


}