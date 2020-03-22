
package translator;

import java.util.Map;
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
 * Association class, store the association implementation, allows the 
 * storage of key-value words. Being in this case English-Spanish translation
 * 
 * @author olivverde
 * Retrieved from: Java Structure. "Data Structure in Java for the Principled 
 * Programmer". Cap. 12... http://dept.cs.williams.edu/~bailey/JavaStructures/Book_files/JavaStructures.pdf
 * */
public class Association<K, V> implements Map.Entry<K,V> 
{
	//Attributes
	protected K key;
	protected V value;

	//Constructor
	public Association(K key, V value) 
        {
            this.key = key;
            this.value = value;
	}
	/**
	 * Gets the key
	 */
    @Override
    public K getKey() 
    {
        return key;
        
    }
    /**
     * Gets the value
     */
    @Override
    public V getValue() 
    {
        return value;
    }
    /**
     * Sets a value
     */
    @Override
    public V setValue(V v) 
    {
        return value=v;
    }

	
}
