package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloController {
    public List<Vocab> vocabList = new ArrayList<>();
    public List<Vocab> wordChoice = new ArrayList<>();
    private int currentQuestionIndex = 0;

    private int correctCount = 0;
    private int totalCount = 0;
    @FXML
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

    private String selectedButton;

    @FXML
    public void initialize(){
        vocabList = Vocab.generateVocab();
        wordChoice = new ArrayList<>(vocabList);
        submitButton.setDisable(true);
        resetcolor();

        if (!vocabList.isEmpty()) {
            loadDefinitionAndChoices(currentQuestionIndex);
        } else {
            // If there are no words, end the game immediately
            endGame();
        }
    }


    public void buttonclicked(ActionEvent itemClicked){
        Button buttonclicked = (Button)itemClicked.getSource() ;
        resetcolor();
        selectedButton=buttonclicked.getText();
        buttonclicked.setStyle("-fx-background-color: #d3d3f3;-fx-text-fill: black;-fx-font-size: 14px;");

    }

    public void submitClicked(){
        checkAnswer(selectedButton);
    }
    public void resetcolor(){
        buttonA.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: black;-fx-font-size: 14px;");
        buttonB.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: black;-fx-font-size: 14px;");
        buttonC.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: black;-fx-font-size: 14px;");
        buttonD.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: black;-fx-font-size: 14px;");
    }

    private void loadDefinitionAndChoices(int questionIndex) {
        if (questionIndex < wordChoice.size()) {
            Vocab vocab = wordChoice.get(questionIndex);
            String definition = vocab.definition;
            String correctWord = vocab.word;

            questionsLabel.setText(definition);
            questionsLabel.setStyle("-fx-font-size: 16px;");

            List<String> termChoices = generateRandomTermChoices(wordChoice, correctWord);

            buttonA.setText(termChoices.get(0));
            buttonB.setText(termChoices.get(1));
            buttonC.setText(termChoices.get(2));
            buttonD.setText(termChoices.get(3));

            submitButton.setDisable(false);

        }else {
            endGame();
        }
    }


    private List<String> generateRandomTermChoices(List<Vocab> vocabList, String correctWord) {
        List<String> termChoices = new ArrayList<>();

        termChoices.add(correctWord);

        List<String> availableIncorrectWords = new ArrayList<>();

        for (Vocab vocab : vocabList) {
            if (!vocab.word.equals(correctWord)) {
                availableIncorrectWords.add(vocab.word);
            }
        }

        Collections.shuffle(availableIncorrectWords);

        for (int i = 0; i < 3; i++) {
            termChoices.add(availableIncorrectWords.get(i));
        }

        return termChoices;
    }


    private void checkAnswer(String selectedButton) {
        if (currentQuestionIndex < wordChoice.size() && selectedButton != null) {

            if (selectedButton.equals(vocabList.get(currentQuestionIndex).word)) {
                correctCount++;
            }
            totalCount++;

            accuracyLabel.setText("Accuracy: " + getAccuracyString(correctCount, totalCount));
            accuracyLabel.setStyle("-fx-text-fill: " + getAccuracyColor(correctCount, totalCount) + "; -fx-font-weight: bold;");

            currentQuestionIndex++;
            loadDefinitionAndChoices(currentQuestionIndex);


        }
    }

    private String getAccuracyString(int correctCount, int totalCount) {
        double accuracy = (double) correctCount / totalCount * 100;
        return String.format("%.2f%%", accuracy);
    }


    private String getAccuracyColor(int correctCount, int totalCount) {
        double accuracy = (double) correctCount / totalCount * 100;

        if (accuracy < 70) {
            return "red";
        } else if (accuracy < 80) {
            return "orange";
        } else if (accuracy < 90) {
            return "blue";
        } else {
            return "green";
        }
    }

    private void endGame() {
        questionsLabel.setText("Game Over! Thank you for playing.");
        questionsLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

        buttonA.setDisable(true);
        buttonB.setDisable(true);
        buttonC.setDisable(true);
        buttonD.setDisable(true);
        submitButton.setDisable(true);
    }

}