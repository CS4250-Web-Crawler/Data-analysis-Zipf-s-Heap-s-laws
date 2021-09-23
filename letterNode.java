package wordStructure;

class letterNode<T>{

	   	private char baseLetter;
	   	private Node<T> next;
	   
	   	public letterNode(char letter)
	    {
	        this(letter, null);
	    }

	    public letterNode(char letter, Node<T> nextNode)
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
	}
