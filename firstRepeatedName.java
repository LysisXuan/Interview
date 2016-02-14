import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

//Question #4

public class firstRepeatedName {
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }
        
        res = firstRepeated(_s);
        bw.write(res);
        bw.newLine();
        
        bw.close();
    }
	
    static String firstRepeated(String s) {  //assume input doesn't contain other characters besides name characters and ","
        String empryString = "";
        if(s == null) return empryString;
        String[] names = s.split(",");
        if(names.length < 2) return empryString;
        
        HashSet<String> nameSet = new HashSet<String>();
        for(String name : names) {
            if(name.isEmpty()) {continue;} //if name is empty:"nameA,,nameB" entered,skip
            if(!nameSet.add(name)) {
                return name;
            }
        }
        return empryString;


    }


}
	
	

