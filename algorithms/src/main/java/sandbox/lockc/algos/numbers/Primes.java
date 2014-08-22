package sandbox.lockc.algos.numbers;

import java.math.BigInteger;

public class Primes {

	public static void main(String[] args) {
		
		BigInteger big = new BigInteger("100000000000000000000000000000000000000000000000000");
				
		System.out.println(isPrime(10007L));
	}
	
	
	
	
	public static boolean isPrime(long number) {
		
		if(isEven(number)) {
			return false;
		}
		
		double sqrtOfNumber = Math.sqrt(number);
		
		long rounded = Math.round(sqrtOfNumber);
		
		for(int x = 3; x < rounded; x++) {
			if((number % x) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] primeFactors() {
		// TODO
		return new int[0];
	}
	
	
	public static boolean isEven(long number) {
		return (number % 2) == 0;
	}

}
