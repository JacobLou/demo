package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HelloController {
    public List<Vocab> vocabList = new ArrayList<>();
    private int correctCount = 0;
    private int totalCount = 0;
    private Label accuracyLabel;
    @FXML
    private Label questionsLabel;
    @FXML
    private Button buttonA;
    @FXML
    private Button buttonB;
    @FXML
    private Button buttonC;
    @FXML
    private Button buttonD;
    @FXML
    private Button submitButton;


    @FXML
    public void initialize(){
        vocabList = Vocab.generateVocab();
        Collections.shuffle(vocabList);
        resetcolor();
        loadDefinitionAndChoices();
        submitButton.setDisable(true);
    }

    public void buttonclicked(ActionEvent itemClicked){
        Button buttonclicked = (Button)itemClicked.getSource() ;
        resetcolor();
        buttonclicked.setStyle("-fx-background-color: #d3d3f3;-fx-text-fill: black;-fx-font-size: 14px;");
    }

    public void submitClicked(ActionEvent itemClicked){

    }
    public void resetcolor(){
        buttonA.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: black;-fx-font-size: 14px;");
        buttonB.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: black;-fx-font-size: 14px;");
        buttonC.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: black;-fx-font-size: 14px;");
        buttonD.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: black;-fx-font-size: 14px;");
    }

    private void loadDefinitionAndChoices() {
        if (!vocabList.isEmpty()) {
            Vocab vocab = vocabList.remove(0);
            String definition = vocab.definition;
            String correctWord = vocab.word;


            questionsLabel.setText(definition);

            List<String> termChoices = generateRandomTermChoices(vocabList, correctWord);
            Collections.shuffle(termChoices);

            buttonA.setText(termChoices.get(0));
            buttonB.setText(termChoices.get(1));
            buttonC.setText(termChoices.get(2));
            buttonD.setText(termChoices.get(3));
            submitButton.setDisable(false);

        } else {
            // Game over, no more definitions left
            questionsLabel.setText("Game Over! Thank you for playing.");
        }
    }

    private List<String> generateRandomTermChoices(List<Vocab> vocabList, String correctWord) {
        List<String> termChoices = new ArrayList<>();
        Random random = new Random();

        termChoices.add(correctWord);

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(vocabList.size());
            String incorrectWord = vocabList.get(index).word;
            termChoices.add(incorrectWord);
        }

        return termChoices;
    }


    private void checkAnswer() {
        Button selectedButton = (Button) ((VBox) ((BorderPane) accuracyLabel.getParent()).getCenter()).getChildren().stream()
                .filter(button -> button.getStyle().contains("lightblue"))
                .findFirst()
                .orElse(null);

        if (selectedButton != null) {
            String selectedTermText = selectedButton.getText();

            if (selectedTermText.equals(vocabList.get(0).word)) {
                correctCount++;
                accuracyLabel.setText("Accuracy: " + getAccuracyString(correctCount, totalCount));
                accuracyLabel.setStyle("-fx-text-fill: " + getAccuracyColor(correctCount, totalCount) + "; -fx-font-weight: bold;");
            }

            totalCount++;
            loadDefinitionAndChoices();
        }
    }

}