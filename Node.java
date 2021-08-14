public class Node
{
    private String wordName;
    private int wordCount;
    private Node left;
    private Node right;
    private Node root;

    public void insertLeft(Node left)
    {
        this.left=left;
    }
    public void insertRight(Node right)
    {
        this.right=right;
    }
    public Node Left()
    {
        return left;
    }
    public Node Right()
    {
        return right;
    }
    public boolean hasLeft()
    {
       if(Left()!=null)
       return true;
       else
       return false;
    }
    public boolean hasRight()
    {
       if(Right()!=null)
       return true;
       else
       return false;
    }
    public boolean isInternal()
    {
        if(hasLeft()||hasRight())
        return true;

        return false;
    }
    public boolean isExternal()
    {
        if(isInternal())
        return false;

        return true;
    }
    public void addRoot(Node root)
    {
        this.root=root;
    }
    public Node getRoot()
    {
        return root;
    }

    public String getWordName() {
        return wordName;
    }
    public void setWordName(String wordName) {
        this.wordName = wordName;
    }
    public int getWordCount() {
        return wordCount;
    }
    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public boolean isRoot()
    {
        if(getRoot()!=null)
        return true;

        return false;
    }



    public void hasleftRight(Node node)
    {
        if(node!=null)
        {
          if(node.hasLeft())
          {
          System.out.println("The node "+node.getWordName()+" has a left child ");
          hasleftRight(node.Left());
          }
          if(node.hasRight())
          {
          System.out.println("The node "+node.getWordName()+" has a right child ");
          hasleftRight(node.Right());
          }

        }
    }

    public void checkRoot(Node node)
    {
        if(node!=null)
        {
          if(node.isRoot())
            System.out.println("The node "+(node.getWordName())+" is a root node ");
         else
            System.out.println("The node "+(node.getWordName())+" is not a root  node ");
 
              checkRoot(node.Left());
              checkRoot(node.Right());
        }
    }

    public void isInternalExternal(Node node)
    {
       if(node!=null)
       {
           if(node.isInternal())
            System.out.println("The node "+(node.getWordName())+" is an internal node ");
           if(node.isExternal())
            System.out.println("The node "+(node.getWordName())+" is an external node ");
            
            isInternalExternal(node.Left());
            isInternalExternal(node.Right());
           
       }
    }

   
   
    

}
