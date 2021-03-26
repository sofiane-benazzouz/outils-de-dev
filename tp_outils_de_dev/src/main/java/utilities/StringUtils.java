package utilities;


public final class StringUtils {

	private StringUtils() {}
	
	static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String alphabet2 = alphabet.toLowerCase();
	public static Boolean isPalindrome(String s) {
		int n = s.length();
		for (int i = 0; i < (n / 2); ++i) {
			if (s.charAt(i) != s.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}


	public static String encodeCesar(String s, int delta) {
		String result = "";

        // bring delta to positive value
        while (delta < 0) {
            delta += 26;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            
                char startLetter =  'A';    
                result += (char) ((c - startLetter + delta) % 26 + startLetter);
            
        }

        return result;
	}

	public static String decodeCesar(String s, int delta) {
		return encodeCesar(s, -delta);
	}
	
	public static String capitalize(String name) {
		return name.substring(0,1).toUpperCase() + name.substring(1);
	}

}
