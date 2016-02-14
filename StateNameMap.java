import java.util.HashMap;

//Question #2


/*
 * two way map for state full name and abbrev
 * Only need to create two map once for all the method calls for convertion between fullname and abbrev
 *
 */
 
 
public class StateNameMap {
	
	 private static HashMap<String,String> abbrevToFullNameMap;
	 private static HashMap<String,String> fullNameToAbbrevMap;
	 private static StateEnum[] states = StateEnum.values();
	 
	 //constructor
	 public StateNameMap(){
		 abbrevToFullNameMap = new HashMap<String,String>();
		 fullNameToAbbrevMap = new HashMap<String,String>();
		 for(StateEnum state : states){
			 abbrevToFullNameMap.put(state.getAbbrev(), state.getFullName());
			 fullNameToAbbrevMap.put(state.getFullName(), state.getAbbrev());		 
		 }
	 }
	  // return the full name of the state specified by the two-letter code.
	 public String getFullNamefromAbbrev(String abbrev) {
		 return abbrevToFullNameMap.get(abbrev);
	 }
	 
	 //return the abbrev from fullName
	  public String getAbbrevFromFullName(String s) {
	    return fullNameToAbbrevMap.get(s);
	  }
	  
}
