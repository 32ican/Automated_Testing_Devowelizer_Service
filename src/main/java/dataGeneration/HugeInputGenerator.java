package dataGeneration;

public class HugeInputGenerator {

	
	
	public static String getHugeInput() {
		String hugeInput = "";
		int repetition = 1000; // Number of repetitions for each letter
		for (char c = 'a'; c <= 'z'; c++) {
		    for (int i = 0; i < repetition; i++) {
		        hugeInput += c;
		    }
		}
		
		return hugeInput;
	}
}
