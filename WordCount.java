package wordStructure;

import java.util.*;
import java.io.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        // open the file
        Scanner console = new Scanner(System.in);
        File file = new File("C:\\Users\\arbit\\Desktop\\testFile1.txt");
        Scanner input = new Scanner(file);

        //**NEW** parameter for the total number of words in the document as it increases
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
                //map that word with value 1 to start counting its occurrences
                wordCounts.put(next, 1);
                //**NEW** incrementing word count each time a new word is added
                totalWords++;
              //**NEW** create a node for a graph with the total word count at the time the vocabulary increased
                Analysis.addGraphNode(wordCounts.size(), totalWords);
            } else {
                // else if the word already has a mapping, then get the current value associated with that word (key) and increase value by 1
                wordCounts.put(next, wordCounts.get(next) + 1);
                totalWords++;
                
                
   
            }
        }

        //Use Comparator.reverseOrder() for reverse ordering
        wordCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> wordCounts.put(x.getKey(), x.getValue()));

        //System.out.println("Reverse Sorted Map   : " + wordCounts);
        Analysis.setInitials(wordCounts.size(), totalWords);
        Analysis.Heaps(wordCounts);
    }
}