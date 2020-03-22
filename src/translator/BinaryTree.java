
package translator;
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructura de datos
 * 
 * General Description:
 * A program which main purpose is to store a wide brand of English words
 * with their Spanish meaning. Implementing Association, Node and BinaryTree 
 * classes.
 * 
 * Class Description:
 * BinaryTree allows to store nodes in the in-order way, storing in a
 * recursive analysis and using comparison to execute the designated order.
 * 
 * Retrieved from: https://www.baeldung.com/java-binary-tree
 * Retrieved from: https://www.geeksforgeeks.org/print-left-view-binary-tree/
 * Retrieved from: Java Structure. "Data Structure in Java for the Principled 
 * Programmer". Cap. 12... http://dept.cs.williams.edu/~bailey/JavaStructures/Book_files/JavaStructures.pdf
 * @author olivverde
 * @param <E>
 */
public class BinaryTree<E>
{
	
	//Attributes
	//Parent node
    Node root;
    
    /**
     * pre:
     * post: A BTS is generated
     * Call the addNode method, execute the binary tree search
     * using the in-order way.
     * @param value
     */
    public void addWord(Node value) 
    {
         root = addNode(root, value);
         
    }
    
   /**
    * pre: root node start empty
    * post: A in-order binary tree is created
    * In-Order the node entries 
    * @param current
    * @param entryVal
    * @return
    */
   private Node addNode(Node current, Node entryVal) 
   {
	   //If root-node doesn't exist, the first entry is the new root
        if (current == null) 
        {
            Node<E> newRoot = new Node<E>();
            newRoot = entryVal;
            return newRoot;
        }
        
        //If the value entry is bigger than the root...
        if ((entryVal.getKey()).compareTo(current.getKey()) > 0)
        {	
        	//Recursive action: The new entry node, look in the 
        	//left node side a position, if it's no more left nodes, 
        	//creates a new left root.
            current.left = addNode(current.left, entryVal);
        } 
        else if ((entryVal.getKey()).compareTo(current.getKey()) < 0) 
        {
        	//Recursive action: The new entry node, look in the 
        	//right node side a position, if it's no more right nodes, 
        	//creates a new right root.
            current.right = addNode(current.right, entryVal);
        }
        
        //The entry value is already in
        else {
        
            return current;
        }
        return current;
        
    }
   /**
    *Checks if the key already exists in the Binary Tree, execute the 
    *translation if the key is within the dictionary.
    * @param word
    * @return
    */
   public boolean containsKey(String word){
       Node n = containsKeyRecursive(root, word);
       //If null, the node doesn't exist
       if (n == null)
           return false;
       //If it's not null, the node does exist
       else
           return true;
   }
   
   /**
    * Checks where the node is located if it exists
    * @param current
    * @param word
    * @return
    */
   public Node containsKeyRecursive(Node current, String word){
	   //The node doesn't exist
       if (current == null) 
        {
            return null;
        }
       //If it's bigger than the root
       if (word.compareTo(current.getKey()) > 0) 
       {
            return translateRecursive(current.left, word);
        } 
       //If it's smaller than the root
       else if (word.compareTo(current.getKey()) < 0) 
       {
            return translateRecursive(current.right, word);
        } 
       else
       {
            // value already exists
            return current;
        }
   }
   
   /**
    * Check where the node is located, allows its translation
    * @param current
    * @param word
    * @return
    */
   public Node translateRecursive(Node current, String word){
	   //Node doesn't exist
       if (current == null) 
        {
            return null;
        }
       //If it's bigger than the root
       if (word.compareTo(current.getKey()) > 0) 
       {
    	   //Look for the node in the left path
            return translateRecursive(current.left, word);
        } 
       //If it's smaller than the root
       else if (word.compareTo(current.getKey()) < 0) 
        {
    	   //Look for the node in the right path
            return translateRecursive(current.right, word);
        } 
       else 
        {
            // value already exists
            return current;
        }       
   }
   
   /**
    * Translate the entry word
    * @param word
    * @return
    */
   public String translate(String word){
	   //Verify the existence of the node
       Node n = translateRecursive(root,word);
       //The node doesn't exist
       if (n == null)
       {
           return null;
       }
       //Gets the saved value 
       else
       {
           return n.getValue();
       }
   } 
   public String showLeftNode(String word){
	   //Verify the existence of the node
       Node n = showNodeLeftRecursive(root, word);
       //The node doesn't exist
       if (n == null)
       {
           return null;
       }
       //Gets the saved value 
       else
       {
           return n.getKey();
       }
   } 
   
   public Node showNodeLeftRecursive(Node current, String word){
	   //Node doesn't exist
       if (current == null) 
        {
            return null;
        }
       //If it's bigger than the root
       if (word.compareTo(current.getKey()) > 0) 
       {
    	   //Look for the node in the left path
            return showNodeLeftRecursive(current.left, word);
        } 
       else 
        {
            // value already exists
            return current;
        }       
   }
   public String showRightNode(String word){
	   //Verify the existence of the node
       Node n = showNodeRightRecursive(root, word);
       //The node doesn't exist
       if (n == null)
       {
           return null;
       }
       //Gets the saved value 
       else
       {
           return n.getKey();
       }
   } 
   
   public Node showNodeRightRecursive(Node current, String word){
	   //Node doesn't exist
       if (current == null) 
        {
            return null;
        }
       //If it's bigger than the root
       if (word.compareTo(current.getKey()) > 0) 
       {
    	   //Look for the node in the left path
            return showNodeRightRecursive(current.left, word);
        } 
       else 
        {
            // value already exists
            return current;
        }       
   }
}

