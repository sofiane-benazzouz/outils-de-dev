package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class StringUtilsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@ParameterizedTest
	@CsvFileSource(resources={"/Classeur.csv"},delimiter=',',numLinesToSkip=116)
	void testIsPalindrome(String str) {
		if(str != null) {
			assertTrue(StringUtils.isPalindrome(str));
		}
	}
	
	@Test
	void cryptTest() {
		String test = "BONJOUR ZOE";
		assertEquals("CPOKPVS APF",StringUtils.crypt(test));
	}
	
	@Test
	void decryptTest() {
		String test = "CPOKPVS APF";
		assertEquals("BONJOUR ZOE",StringUtils.decrypt(test));
	}

}
