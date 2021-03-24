package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


class ExoTest {

	
	@Test
	void testSquare() {
		int carre = MathUtils.Square(2);
		assertEquals(4,carre);
	}
	
	@Test
	@DisplayName("factorielle throws exception")
	void testFactorial() {
		Exception exception = assertThrows(ArithmeticException.class, () -> MathUtils.Factorielle(-1));
		
		assertEquals("exception factorielle negative",exception.getMessage());
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources={"/Classeur.csv"},delimiter=',',numLinesToSkip=16)
	void testIsPrime(Integer number) {
		if (number != null) {
			Boolean premier = MathUtils.isPrime(number);
			assertTrue(premier);
		}
	}

}
