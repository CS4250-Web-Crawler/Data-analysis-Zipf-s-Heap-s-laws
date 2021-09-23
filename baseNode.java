package wordStructure;

class baseNode<T>{

		private int uniqueWords = 0;
	   	private char baseLetter;
	   	private Node<T> next;
	   
	   	public baseNode(char letter)
	    {
	        this(letter, null);
	    }

	    public baseNode(char letter, Node<T> nextNode)
	    {
	        baseLetter = letter;
	        next = nextNode;
	    }

	    public Node<T> getNextNode()
	    {
	        return next;
	    }

	    public char getLetter()
	    {
	        return baseLetter;
	    }

	    public void setNextNode(Node<T> next)
	    {
	        this.next = next;
	    }

	    public void setLetter(char letter)
	    {
	        this.baseLetter = letter;
	    }
	    
	    public int getUniqueCount() {
	    	return uniqueWords;
	    }
	}
