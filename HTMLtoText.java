package cs4250.project1.v1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLtoText {

    public static void convertHTMLtoText() throws IOException {
        //HTML file
        String fileName = "test_v1.txt";

        //Takes HTML and places data into a Document
        Document doc = Jsoup.parse(new File(fileName), "utf-8");
        //Extracts text from titles in the HTML file
        String title = doc.title();
        //Extracts all text from body in HTML file
        String body = doc.body().text();

        //Create a new string with only words
        String textOnly = (title + " " + body);

//        remove remaining punctuations excluding apostrophes
        textOnly = textOnly.replaceAll("[\\p{P}&&[^\u0027]]", " ");

        //Removes all words that are in English
//        textOnly = textOnly.replaceAll("[\\w]", " ");

        //Removes all words that are NOT in English
        textOnly = textOnly.replaceAll("[\\W]", " ");

//        textOnly = textOnly.replaceAll("[\\p{P}]", " ");

        //remove digits
        textOnly = textOnly.replaceAll("\\d", "");

        //Write new text only data to a new file that we can work with for Zip's and heaps law
        try {
            // Creates a FileWriter
            FileWriter output
                    = new FileWriter("output_v3.txt");

            // Writes the string to the file
            output.write(textOnly);

            // Closes the writer
            output.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }
    }

}
