package telran.interviews;

import java.util.*;

public class AutoCompletion {
	//TODO
	TreeSet<String> words = new TreeSet<>(String::compareToIgnoreCase);
	
	public boolean addWord(String word) {
		//TODO adds new word into auto-completion variants
		//returns true if added, false otherwise (if a given word already exists)
		return words.add(word);
	}

	public String[] getVariants(String prefix) {
		//TODO
		//returns all words beginning with a given prefix
		//Complexity of finding the variants is 0[logN]	 
	   
	    return words.subSet(prefix, prefix + Character.MAX_VALUE).toArray(String[]::new);
	}
	
}
//toArray(new String[0])