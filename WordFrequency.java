package cs4250.project1.v1;

import java.util.*;
import java.io.*;

public class WordFrequency {

    public static void main(String[] args) throws IOException {
        // open the file
        Scanner console = new Scanner(System.in);
        File file = new File("C:\\Users\\thaol\\Desktop\\CS 4250\\Project1\\testFile1.txt");
        Scanner input = new Scanner(file);

        // count word frequencies
        // Using treeMap that takes in String as the key and Integer as the value
        // Using LinkedHashMap to map keys (words) and values (word frequency)
        LinkedHashMap<String, Integer> wordFrequency = new LinkedHashMap<String, Integer>();

        //loop through the file until it reaches the end
        while (input.hasNext()) {
            //converts everything into lower case
            String next = input.next().toLowerCase();
            //if the next word on the file does not already have a mapping (meaning first time seeing word)
            if (!wordFrequency.containsKey(next)) {
                //map that word with value 1 to start counting its occurences
                wordFrequency.put(next, 1);
            } else {
                // else if the word already has a mapping, then get the current value associated with that word (key) and increase value by 1
                wordFrequency.put(next, wordFrequency.get(next) + 1);
            }

            //New linkedHashMap that will store the sorted list base on frequency
            LinkedHashMap<String, Integer> sortedWordList = new LinkedHashMap<>();

            //Use Comparator.reverseOrder() for reverse ordering
            wordFrequency.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> sortedWordList.put(x.getKey(), x.getValue()));

            //Print out the sorted word list with frequency
            System.out.println("Word List Sorted by Frequency in Descending Order");
            for (Map.Entry<String, Integer> entry : sortedWordList.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}
