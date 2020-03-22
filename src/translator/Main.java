
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
 * Main class execute the whole program. A brief dictionary is submitted,
 * A BTS (Binary Search Tree) is executed and a short text is translated.
 * 
 * @author olivverde
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        String line, english,spanish,lastKey = null;
        ArrayList<String> dictionary = new ArrayList<String>();
        
        
        //Look for a file
        File file = new File ("dictionary.txt");
        FileReader reader = new FileReader (file);
        BufferedReader buffered = new BufferedReader(reader);
        
        //Classes's ambassadors
        Scanner sc = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        
        //While there's sometime to read, it will keep running...
        while( (line = buffered.readLine())!=null)
        {
        	//English key is stored
            english = line.substring(0,line.indexOf(","));
            //keys are stored
        	dictionary.add(english);
            //Spanish value is stored
            spanish = line.substring(line.indexOf(",")+1,line.length());
            //A new word is added. (New node created, new association created)
            bt.addWord(new Node(new Association(english,spanish)));
             
        
        }
        System.out.println("BTS DEMOSTRATION:");
        for (int i = 0 ; i < dictionary.size() ; i++)
        {
        	
        	String currentKey = bt.showLeftNode(dictionary.get(i));
        	
        	if(lastKey == null) {
        		System.out.println("\n"+"root node: "+currentKey);
        	}
        	else if (currentKey.contentEquals(dictionary.get(i))) {
        		System.out.println("\n"+dictionary.get(i)+" is referenced to left node of: "+lastKey);
        	}
        	else if(currentKey.compareTo(dictionary.get(i)) > 0)
        	{
            	System.out.println("\n"+dictionary.get(i)+" is referenced to right node of: "+currentKey);
        	}
        	
        	else if(currentKey.compareTo(lastKey) > 0)
        	{
            	System.out.println("\n"+dictionary.get(i)+" is referenced to left node of: "+currentKey);
        	}
        	lastKey = currentKey;
        }
        
        System.out.println("\nSubmit the entry you wanna translate: ");
        String entry = sc.nextLine();
        
        //Entry is divided by using blank spaces
        String[] translation = entry.split(" ");
        //Look word by word, following the BTS pattern
        for (int i = 0; i < translation.length; i++){
        	//If the word is within the tree...
            if (bt.containsKey(translation[i].toLowerCase())){
            	//Translation is completed
                translation[i]=bt.translate(translation[i].toLowerCase());
            }
        }
        for (int i=0; i<translation.length;i++){
            System.out.print(translation[i]+" ");
        }
    } 
}
