public class graphNode {
	private int vocab;
	private int words;
	
	public graphNode(int vocabSize, int wordCount) {
		vocab = vocabSize;
		words = wordCount;
	}
	public int getVocabSize() {
		return vocab;
	}
	
	public int getWordCount() {
		return words;
	}
}
