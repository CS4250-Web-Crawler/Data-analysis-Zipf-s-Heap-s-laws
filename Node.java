class Node<T>
{
    private T word;
    private Node<T> next;

    public Node(T dataPortion)
    {
        this(dataPortion, null);
    }

    public Node(T dataPortion, Node<T> nextNode)
    {
        word = dataPortion;
        next = nextNode;
    }

    public Node<T> getNextNode()
    {
        return next;
    }

    public T getData()
    {
        return word;
    }

    public void setNextNode(Node<T> next)
    {
        this.next = next;
    }

    public void setdata(T data)
    {
        this.word = data;
    }
}