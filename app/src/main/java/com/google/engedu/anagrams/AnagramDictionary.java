package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class AnagramDictionary {

    HashSet<String> wordSet = new HashSet<String>();
    ArrayList<String> arrayList = new ArrayList<String>();
    HashMap<String,ArrayList<String>> lettersToWord = new HashMap<String, ArrayList<String>>();

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();

    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordSet.add(word);
            arrayList.add(word);

            String sortedWord = sortWord(word);
            ArrayList<String> temp = new ArrayList<>();

            if(lettersToWord.containsKey(sortedWord)){
                temp = lettersToWord.get(sortedWord);
                temp.add(word);
                lettersToWord.put(sortedWord, temp);
            }
            else{
                temp.add(word);
                lettersToWord.put(sortedWord, temp);
            }
            //temp.clear();
        }
    }

    public boolean isGoodWord(String word, String base) {
       return (wordSet.contains(word) && !word.contains(base));
    }

    public ArrayList<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        String temp = null;
        for(char i='a'; i<='z'; i++){
            temp = word+i;
            temp = sortWord(temp);

            if(lettersToWord.containsKey(temp)){
                ArrayList<String> intermediateResult = new ArrayList<>();
                intermediateResult = lettersToWord.get(temp);

                for (int j = 0; j<intermediateResult.size(); j++) {
                    if (isGoodWord(intermediateResult.get(j), word)) {
                        result.add(intermediateResult.get(j));
                    }
                }
            }
        }
        return result;
    }

    public String pickGoodStarterWord() {
        return "stop";
    }

    public String sortWord(String word) {

        char wordArr[] = word.toCharArray();
        //sorting the words using bubble sort
        for (int i = 0; i < wordArr.length; i++) {
            for (int j = 0; j < wordArr.length - 1; j++) {
                if (wordArr[j] > wordArr[j + 1]) {
                    char temp = wordArr[j];
                    wordArr[j] = wordArr[j + 1];
                    wordArr[j + 1] = temp;
                }
            }
         }
        return new String(wordArr);
    }
}
