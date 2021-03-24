package utilities;

public class MathUtils {
	
	
	public static Integer Square(Integer num) {
		return num * num;
	}
	
	public static Integer Factorielle(Integer num) throws  ArithmeticException{
			if(num < 0) {
				throw new ArithmeticException("exception factorielle negative");
			}
			else if(num == 0) {
				return 1;
			}
			return num * Factorielle(num - 1);
	}
	
	
	public static boolean isPrime(Integer num) {
		boolean isPremier = true;
		if(num < 0) {
			isPremier = false;
		}
		else if((num != 0) && (num != 1)) {
			for(int i = 2 ; i <= num/2 ; i++) {
				if((num != i) && ((num % i) == 0)) {
					isPremier = false;
					break;
				}
			}
		}
		return isPremier;
	}
	

	
}
