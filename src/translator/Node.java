/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translator;

import java.util.Comparator;

public class Node<E>
{
    private Association<String, String> value;
    protected  Node<E> left;
    protected  Node<E> right;        
    
    public Node()
    {
        value=null;
        left=null;
        right=null;
        
                
    }

    public Node (Association<String, String> value) {
        this.value = value;
        left = null;
        right = null;
    }
    
    public String getKey()
    {
        return value.key;
    } 
    
    public String getValue()
    {
        return value.value;
    }
}
