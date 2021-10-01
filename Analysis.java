package wordStructure;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Analysis {
	private static int totalWords;
	private static int uniqueWords;
	public static graphNode[] nodeArray = new graphNode[1000];
	private static int graphIndex = 0;
	
	public static void setInitials(int wordTotal, int vocabTotal) {
		totalWords = wordTotal;
		uniqueWords = vocabTotal;
	}
	
	public static void Zipfs(LinkedHashMap wordMap) {
		//find amount of unique words in the hashMap
		uniqueWords =wordMap.size();
		
		/*zipf's law
		wordRank*(wordFrequency/totalWords);
		*/
	}
	
	//add nodes from nodeArray to graphing solution
	public static void Heaps(LinkedHashMap wordMap)	throws IOException {
		
		//add nodes from nodeArray to graphing solution
		//OutputGraph.toXML(nodeArray);
		FileWriter output
	    = new FileWriter("TestCSVFile.txt");
		output.write("Vocabulary Size, Total Word Count" + '\n');
		for (int index = 0; index < Analysis.arraySize(); index++) {
			output.write(nodeArray[index].getVocabSize() + "," + nodeArray[index].getWordCount() + "," + '\n');
		}
		output.close();
	}	
	
	public static int getTotalWords() {
		return totalWords;
	}
	
	public static void addGraphNode(int vocabSize, int wordCount) {
		graphNode newNode = new graphNode(vocabSize, wordCount);
		nodeArray[graphIndex] = newNode;
		graphIndex++;
		if (graphIndex >= nodeArray.length) {
			nodeArray = Arrays.copyOf(nodeArray, nodeArray.length*2);
		}
	}
	public static graphNode[] getGraphArray() {
		return nodeArray;
	}
	public static int arraySize() {
		return graphIndex;
	}
}
