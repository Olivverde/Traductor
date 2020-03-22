
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
 * Node class, store association and contructors for the class
 * 
 * @author olivverde
 * */
import java.util.Comparator;

public class Node<E>
{
	//Attributes
    private Association<String, String> value;
    protected  Node<E> left;
    protected  Node<E> right;        
    
    public Node()
    {
        value=null;
        left=null;
        right=null;
        
                
    }
    //Constructor based on association implementation
    public Node (Association<String, String> value) {
        this.value = value;
        left = null;
        right = null;
    }
    //Getters 
    public String getKey()
    {
        return value.key;
    } 
    
    public String getValue()
    {
        return value.value;
    }
}
