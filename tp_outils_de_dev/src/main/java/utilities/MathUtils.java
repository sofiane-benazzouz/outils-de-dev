package utilities;

public final class MathUtils {

	private MathUtils() {}
	
	public static Integer square(int number) {
		return number * number;
	}

	public static Long factorial(Long number) throws Exception {
		if(number < 0) throw new ArithmeticException("No negative number for factorial()");
		if(number == 0 || number == 1)
			return (long) 1;
		return factorial(number-1)*number;
	}

	public static Boolean isPrime(int number) {
		if (number <= 1) {
				return false;
			}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
