public class Main {

	public static void main(String[] args) {
		queryString("0110",4);
	}

	  public static boolean queryString(String s, int n) {
	        for(int i = 1 ; i < n+1 ; i++){
	            String str = Integer.toBinaryString(i);
	            System.out.println(str);
	            if(!s.contains(str))
	                return false;
	        }
	        return true;
	    }
	  
	private static void iterateChar(char[] charArray, int i) {
		if (i == charArray.length)
			return;
		System.out.println(charArray);
		swap(charArray, i);
		System.out.println(charArray);
		shiftforward(charArray);
	}

	private static void shiftforward(char[] charArray) {
		char ch = charArray[0];
		for (int i = 1; i < charArray.length; i++) {
			charArray[i - 1] = charArray[i];
		}
		charArray[charArray.length - 1] = ch;
	}

	private static void swap(char[] charArray, int i) {
		int j = i+1;
		if( j == charArray.length) j = 0; 
		char c = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = c;
	}

}
