import java.util.Arrays;
import java.util.HashSet;

//Question # 1

public class IdenticalSets {
	
    public static boolean allStringSetsIdentical(String[ ][ ] sets) {
    	if(sets.length < 2) return true; //if no set or only one set, return true;
        HashSet<String> setOne = new HashSet<String>(); //the base set we will later on compare all other sets to 
        addAllString(sets[0], setOne); //call the helper function below to fill the set
        
        HashSet<String> setTwo = null;      
        for(int i = 1;i < sets.length;i++) {
            setTwo = new HashSet<String>(); //instantiate a new set.It's faster than use setTwo.clear()
            addAllString(sets[i],setTwo);
            if(!setOne.equals(setTwo)) return false;
        }
        return true;
    }
    
    /*
     * Add all strings in String[] to a HashSet.
     * 
     * Faster than the following code:
     * SetOne = new HashSet<String>(Arrays.asList(sets[0]))
     */
    private static void addAllString(String[] strings, HashSet<String> set) {
    	for(String s : strings) {
    		set.add(s);
    	}
    }
    
}
