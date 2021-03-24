package utilities;

public class StringUtils {
	
	
	
	/*
	public static boolean isPalindrome(String msg) {
		if((msg.length()) == 1) {
			return true;
		}
		else if(msg.charAt(0) == msg.charAt(msg.length()-1)) {
			System.out.println("****** " + msg.length());
			System.out.println(msg.charAt(0));
			System.out.println(msg.charAt((msg.length()-1)));
			System.out.println(msg.substring(1,msg.length()-1));
			isPalindrome(msg.substring(1,msg.length()-1));
		}
		
		return false;
	}
	*/
	public static boolean isPalindrome(String str) {
	int i = 0, j = str.length() - 1;
	 
    // While there are characters to compare
    while (i < j) {

        // If there is a mismatch
        if (str.charAt(i) != str.charAt(j))
            return false;

        // Increment first pointer and
        // decrement the other
        i++;
        j--;
    }

    // Given string is a palindrome
    return true;
}

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
    public static String crypt(String plainText)  {
    	 plainText = plainText.toLowerCase();
         String cipherText = "";
         for (int i = 0; i < plainText.length(); i++)
         {
        	if(plainText.charAt(i) != ' ') {
	             int charPosition = ALPHABET.indexOf(plainText.charAt(i));
	             int keyVal = (1 + charPosition) % 26;
	             char replaceVal = ALPHABET.charAt(keyVal);
	             cipherText += replaceVal;
        	 }else {
        		 cipherText += ' ';
        	 }
         }
         return cipherText.toUpperCase();

    }
	
    public static String decrypt(String plainText)  {
   	 plainText = plainText.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++)
        {
       	if(plainText.charAt(i) != ' ') {
	             int charPosition = ALPHABET.indexOf(plainText.charAt(i));
	             int keyVal = (charPosition - 1) % 26;
	             if (keyVal < 0)
	             {
	                 keyVal = ALPHABET.length() + keyVal;
	             }
	             char replaceVal = ALPHABET.charAt(keyVal);
	             cipherText += replaceVal;
       	 }else {
       		 cipherText += ' ';
       	 }
        }
        return cipherText.toUpperCase();

   }
	
	public static String capitalize(String name) {
		return name.substring(0,1).toUpperCase() + name.substring(1);
	}
	

}
