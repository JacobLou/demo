package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamelogic {
    public static Vocab getVocab() {
        Vocab vocab= Vocab.vocabList.get(0);
        return vocab;
    }

    public static String[] generateWordChoices(List<Vocab> vocabList, String correctWord) {
        String[] wordChoices = new String[4];
        List<String> availableWords = new ArrayList<>();

        for (Vocab vocab : vocabList) {
            if (!vocab.word.equals(correctWord)) {
                availableWords.add(vocab.word);
            }
        }

        wordChoices[0] = correctWord;

        for (int i = 1; i < wordChoices.length; i++) {
            int randomIndex = new Random().nextInt(availableWords.size());
            wordChoices[i] = availableWords.get(randomIndex);
            availableWords.remove(randomIndex);
        }
        return wordChoices;
    }
    public void getAnswerA(){

    }
}
