package wordStructure;

class wordStructure {
	public static void main(String[] args) {
		//creates an array of nodes which have values from 'a' to 'z'
		//they serve as the starting point nodes for the linked list
		letterNode[] alphabet = new letterNode[26];
		char alpha = 'a';
		//populating the array with 26 letterNodes with contained values 'a' to 'z'
		for (int index = 0; index <=25; index++) {
			alphabet[index] = new letterNode(alpha);
			alpha++;
		}
		//example
		System.out.println("Array value [0] contains letterNode with char 'a'");
		System.out.println(alphabet[0].getLetter());
	}
}