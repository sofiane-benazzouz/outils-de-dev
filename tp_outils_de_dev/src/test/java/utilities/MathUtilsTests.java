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

class MathUtilsTests {
	
	@DisplayName("Calcul.square")
	@ParameterizedTest(name="{0}^2 = {1}")
	@CsvSource(value = { "2, 4", "-2, 4", "0, 0", "10, 100" })
	void square(int number, int squaredNumber) {
		assertEquals(squaredNumber, MathUtils.square(number));
	}

	@Nested
	@DisplayName("Calcul.factorial")
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class factorialMethod {
		
		@ParameterizedTest(name="{0}! = {1}") 
		@CsvFileSource(resources = "/factorial_numbers.csv")
		void factorial(Long number, Long factoNumber) throws Exception {
			assertEquals(factoNumber, MathUtils.factorial(number));
		}
		
		@Test
		void factorial_negative_numbers() throws ArithmeticException {
			Exception exception = assertThrows(ArithmeticException.class, () -> MathUtils.factorial((long) -5));
			assertEquals("No negative number for factorial()", exception.getMessage());
		}
	}
	
	@Nested
	@DisplayName("Calcul.isPrime")
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class isPrimeMethod {
		
		@ParameterizedTest(name="{0} is a prime number")
		@ValueSource(ints = {2,3,5,7,11,13,17,19})
		void isPrime(int number) {
			assertTrue(MathUtils.isPrime(number));
		}
		
		@ParameterizedTest(name="{0} is not a prime number")
		@ValueSource(ints = {-10000, 1, -1,4,6,8,9,10,12,14})
		void isNotPrime(int number) {
			assertFalse(MathUtils.isPrime(number));
		}	
	}
	
	
}
