package cs4250.project1.v1;

import java.util.*;
import java.io.*;

public class WordFrequency {

    public static void getWordFrequency() throws IOException {
        // open the file
        Scanner console = new Scanner(System.in);
        File file = new File("output_v2.txt");
        Scanner input = new Scanner(file);

        //**NEW** parameter for the total number of words in the document as it increases - Added by Gabe
        int totalWords = 0;

        // count word frequencies
        // Using treeMap that takes in String as the key and Integer as the value
        // using LinkedHashMap which stores data as it enters. We could use HasMap or TreeMap too if needed
        LinkedHashMap<String, Integer> wordCounts = new LinkedHashMap<String, Integer>();

        //loop through the file until it reaches the end
        while (input.hasNext()) {
            //converts everything into lower case
            String next = input.next().toLowerCase();
            //if the next word on the file does not already have a mapping (meaning first time seeing word)
            if (!wordCounts.containsKey(next)) {
                //map that word with value 1 to start counting its occurences
                wordCounts.put(next, 1);
                //**NEW** incrementing word count each time a new word is added - Added by Gabe
                totalWords++;
                //**NEW** create a node for a graph with the total word count at the time the vocabulary increased
                Analysis.addGraphNode(wordCounts.size(), totalWords);
            } else {
                // else if the word already has a mapping, then get the current value associated with that word (key) and increase value by 1
                wordCounts.put(next, wordCounts.get(next) + 1);
                totalWords++;
            }
        }

        LinkedHashMap<String, Integer> sortedWordList = new LinkedHashMap<>();

        //Use Comparator.reverseOrder() for reverse ordering
        wordCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedWordList.put(x.getKey(), x.getValue()));

//        Print out the sorted word list with frequency
        System.out.println("Word List Sorted by Frequency in Descending Order");
        for (Map.Entry<String, Integer> entry : sortedWordList.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        Analysis.setInitials(wordCounts.size(), totalWords);
        Analysis.Heaps(wordCounts);
        Analysis.Zipfs(sortedWordList);
        Analysis.MostCommon(sortedWordList);    //**NEW** added for 100 most common words method
    }
}
