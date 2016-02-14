import java.util.EnumSet;
import java.util.HashMap;

//Question #2

public class StateUtils {
	
	 private static StateEnum[] states = StateEnum.values(); //all state enums
	 private static StateNameMap map = new StateNameMap(); //map for getting abbrev from fullname and fullname from abbrev
	 private static final String OPTION = "<option value=\"%1$s\">%1$s</option>\n";

  // Generates an HTML select list that can be used to select a specific
  // U.S. state.
  public static String createStateSelectList()
  {
	  StringBuilder builder = new StringBuilder(); //String builder is faster for multiple string concatenation than "+"
	  builder.append("<select name=\"state\">\n");
	  for(StateEnum state:states) {
		  builder.append(String.format(OPTION, state.getFullName())); //This makes code clean for 50 states
	  } 
	  builder.append("</select>\n");
	  return builder.toString();
  }

  // Parses the state from an HTML form submission, converting it to
  // the two-letter abbreviation.
  public static String parseSelectedState(String s)
  {
    return map.getAbbrevFromFullName(s);
  }

  //
  // Displays the full name of the state specified by the two-letter code.
  public static String displayStateFullName(String abbr) {
	  return map.getFullNamefromAbbrev(abbr);
  }

}
