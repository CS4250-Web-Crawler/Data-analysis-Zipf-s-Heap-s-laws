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
		
	public static void Heaps(LinkedHashMap wordMap)	{
		
		//add nodes from nodeArray to graphing solution
		//example output
		for (int tempGraphIndex = 0; nodeArray[tempGraphIndex] != null; tempGraphIndex++) {
			System.out.println("Current vocabulary count: " + nodeArray[tempGraphIndex].getVocabSize());
		}
		
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

}
