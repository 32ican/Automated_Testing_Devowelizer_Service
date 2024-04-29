package dataGeneration;

public class HugeInputGenerator {


	private final static int REPETITION = 1000; 
	
	/**
	Generates a huge input string consisting of all lowercase letters of the English alphabet repeated multiple times.
	@return The generated huge input string.
	*/
	public static String getHugeInput() {
		String hugeInput = "";
		
		for (char c = 'a'; c <= 'z'; c++) {
		    for (int i = 0; i < REPETITION; i++) {
		        hugeInput += c;
		    }
		}
		
		return hugeInput;
	}
}
