//Question #2

/*
 * Enum for all the states
 * This is better, since the States for U.S. probably won't change for a long time. 
 * This is highly reusable and make the code more orgnized 
 * 
 */
public enum StateEnum {
	
    ALABAMA("Alabama", "AL"),
    ALASKA("Alaska", "AK"),
    ARIZONA("Arizona", "AZ"),
    ARKANSAS("Arkansas", "AR"),
    CALIFORNIA("California", "CA");
    // more states here
    
    private final String fullName;
    private final String abbrev;
    
    private StateEnum(String fullName, String abbrev){
    	this.fullName = fullName;
    	this.abbrev = abbrev;
    }
    
    public String getFullName() {
    	return fullName;
    }
    
    public String getAbbrev() {
    	return abbrev;
    }
}
