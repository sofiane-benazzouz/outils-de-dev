package utilities;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTests {

	@Nested
	@DisplayName("StringUtils.PalindromeMethod")
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class PalindromeMethod {
		
		@ParameterizedTest(name="{0} is a palindrome")
		@ValueSource(strings = {"coloc", "lol", "elle", "kayak", "rotor"})
		void isPalindrome(String s) {
			assertTrue(StringUtils.isPalindrome(s));
		}
		
		@ParameterizedTest(name="{0} is not a palindrome")
		@ValueSource(strings = {"colocs", "lozl", "elazle", "kaqyak", "roftor"})
		void isNotPalindrome(String s) {
			assertFalse(StringUtils.isPalindrome(s));
		}
	}
	
	
	@Nested
	@DisplayName("StringUtils.CesarMethod")
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class CesarMethod {
		
		@ParameterizedTest(name="{0} has been encoded into {1}; {2}")
		@CsvFileSource(resources = "/cesar_alphabet.csv")
		void encodeCesar(String s, String expected, int step) {
			assertEquals(expected, StringUtils.encodeCesar(s, step));
		}
		
		@ParameterizedTest(name="{1} has been encoded into {0}; {2}")
		@CsvFileSource(resources = "/cesar_alphabet.csv")
		void decodeCesar(String expected, String s, int step) {
			assertEquals(expected, StringUtils.decodeCesar(s, step));
		}
	}
	

}
