package wordStructure;

class Node<T>
{
    private String word;
    private Node<T> next;
    private int frequency;

    public Node(String dataPortion)
    {
        this(dataPortion, null);
    }

    public Node(String dataPortion, Node<T> nextNode)
    {
        word = dataPortion;
        next = nextNode;
    }

    public Node<T> getNextNode()
    {
        return next;
    }

    public String getData()
    {
        return word;
    }

    public void setNextNode(Node<T> next)
    {
        this.next = next;
    }

    public void setdata(String word)
    {
        this.word = word;
    }
    
    public int getFrequencyOf() {
    	return frequency;
    }
}
