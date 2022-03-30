// Milan Kovacs
// 21308128

import java.io.*;
import java.util.*;

public class Dictionary {

    private ArrayList<String> words ;
    public Dictionary(String filepath, int shortest, int longest) {
        // This method reads words from the specified file
        // and adds them to the ‘words’ list. See details below.
        if(longest < shortest){
            int temp = shortest;
            shortest = longest;
            longest = temp;
        }

        if(shortest < 0) shortest = 0; // Set default value

        try {
            File myFile = new File(filepath);
            Scanner fromMyFile = new Scanner(myFile);

            /**
            StringBuilder data = new StringBuilder();
            String fixedData;

            while(fromMyFile.hasNextLine()){
                data.append(fromMyFile.nextLine()).append(",");
            }

            fixedData = (data.toString()).replace(" ", "").toUpperCase();
            String[] temporaryStorage = (fixedData.split(","));
            this.words = new ArrayList<>(temporaryStorage.length); // Initialize an empty ArrayList

            for(String word : temporaryStorage){
                if(!words.contains(word)){
                    words.add(word);
                }
            }

            Collections.sort(words);

            for(int i = 0; i < words.size(); i++){
                if(!(words.get(i).length() >= shortest && words.get(i).length() <= longest)){
                    words.remove(i);
                    i--;
                }
            }

            //*/
            //**
            String data;
            String[] temporaryWords;
            this.words = new ArrayList<>();

            while(fromMyFile.hasNextLine()){
                data = (fromMyFile.nextLine());
                temporaryWords = data.split(",");
//                for(String thatWord : temporaryWords){
                for(int i = 0; i < temporaryWords.length; i++){
                    String thatWord = temporaryWords[i].toUpperCase();
                    thatWord = thatWord.strip();
                    if(thatWord.length() >= shortest && thatWord.length() <= longest && !words.contains(thatWord)){
                        add(thatWord);
                    }
                }
            }

            Collections.sort(words);
//            System.out.println(words);
//            System.out.println(this);
            //*/
        }catch(IOException e){
            System.out.println("We have a problem, Pablo");
        }
    }

    public ArrayList<String> getWords(){
        return this.words;
    }

    // You will also need to include the other methods specified below.
    public boolean add(String word){
        word = word.toUpperCase().strip();
        TreeSet<String> setOfWords = new TreeSet<>(words);
        boolean result = setOfWords.add(word);
        if(result) {
            words = new ArrayList<>(setOfWords);
        }
        return result;
    }

    public String nextWord(){
        if(words.isEmpty()){
            return "";
        }
        int randomNum = (int) (Math.random() * (words.size()));
        return words.get(randomNum);
    }

    public boolean inDictionary(String word){
        TreeSet<String> listOfWords = new TreeSet<>(words);
        return listOfWords.contains(word.toUpperCase().strip());
    }

public String toString(){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUV";
    String sampleFormat = "";
    int wordNumber = 0;
    for(int letter = 0; letter < alphabet.length(); letter++) {
        int counter = 0;
        while(wordNumber < words.size() && words.get(wordNumber).charAt(0) == alphabet.charAt(letter)) {
            sampleFormat = sampleFormat + words.get(wordNumber) + ", ";
            wordNumber++;
            counter++;
        }
        if(counter > 0){
            sampleFormat = sampleFormat.replaceAll(", $", "\n");
        }
    }
        return sampleFormat;
    }

}