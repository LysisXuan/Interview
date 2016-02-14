import java.util.ArrayList;
//Question #3

public class WrapText {
	
	/*
	* chunk the word according to specific length
	*/
	public static ArrayList<String> chunkWord(String word, int chunkSize) {
		ArrayList<String> chunkedWord = new ArrayList<String>();
	    for (int i = 0; i < word.length(); i += chunkSize) {
	    	if(i + chunkSize > word.length()) chunkedWord.add(word.substring(i));
	    	else chunkedWord.add(word.substring(i, i + chunkSize));
	    }
	    return chunkedWord;
	}

	public static String wrapText(String text, int maxCharsPerLine) {	
		if(maxCharsPerLine <= 0) throw new IllegalArgumentException("maxCharsPerLine > 0");
		String NEW_LINE = "\n";
		String SPACE = " ";
		String[] setences = text.split(NEW_LINE);
		StringBuilder res = new StringBuilder();
		int currentLen = 0;
		
		for(String setence: setences) {
			String[] words = setence.split(SPACE);
			for(int i =0; i<words.length; i++){
				String word= words[i];
				if(word.length()==0) continue; //if two consective space
				
				int potentialLen = currentLen==0 ? word.length():currentLen+1+word.length(); //if not empty,add one space
				if(potentialLen == maxCharsPerLine || potentialLen+1 == maxCharsPerLine)	{ //the same length as maxCharsPerLine or just be able to put one space after
					if(currentLen > 0) res.append(SPACE);
					res.append(word);
					res.append(NEW_LINE);
					currentLen = 0;
				}
				else if(potentialLen+1 < maxCharsPerLine) { //will be able to add another word after the current word.stay at current linev
					if(currentLen > 0)res.append(SPACE);
					res.append(word);	
					currentLen=potentialLen;
				}
				else { //can not append next word
					if(word.length() <= maxCharsPerLine) { //No need to break word
						res.append(NEW_LINE);
						currentLen = 0;
						i--;//revisit current word
					}
					else { //Need to break word
						if(currentLen > 0) {
							res.append(SPACE);
							currentLen++;
						}
						res.append(word.substring(0, maxCharsPerLine-currentLen)); //append part of the word
						res.append(NEW_LINE);
						String restWord = word.substring(maxCharsPerLine-currentLen);
						ArrayList<String> chuckedWord = chunkWord(restWord,maxCharsPerLine); // a list of chunked word got from the restWord
						for(int j = 0;j<chuckedWord.size();j++) {
							String currentChunk = chuckedWord.get(j);
							res.append(currentChunk);
							if(j==chuckedWord.size()-1 && currentChunk.length() < maxCharsPerLine-1){ //last chunk and have space to put more characters					
								currentLen=currentChunk.length();
							}
							else{
								res.append(NEW_LINE);
								currentLen=0;
							}
					   }
				   }
			   }
			}
		}		
		return res.toString();		
	}
}
