package main;

import java.math.BigInteger;
import java.util.Scanner;

public class PascalsTriangle {
		
	public static int size = 25; 

	public static void main(String[] args) {
		System.out.println("Please Enter Integer Value: ");
		Scanner input = new Scanner(System.in);
		
		size = input.nextInt();
	
		input.close();
		
		triangle();
	}

	
	private static void triangle() {
		for(int i = 1; i <= size; i++) {
			
		    for(int k = 1; k <= size - i; k++) {
				System.out.print(" ".repeat(k + i - 1));
			}
			
			System.out.print(calculate(i,i) + " ".repeat(i - 1));
			
			for(int j = 1; j <= i; j++) {
				System.out.print(calculate(i,j) + " ".repeat(i - 1));
			}

			System.out.println();
		}
	}
	
	private static BigInteger calculate(long row, long pos) {
		return nchoosek(row,pos);	
	}
	
	private static BigInteger factorial(long number) {	
		BigInteger factorial = BigInteger.ONE;
		
		for(int i = 1; i <= number; i++) {		
			factorial = factorial.multiply(BigInteger.valueOf(i));
		} 
		
		return factorial;    
	}
	
	private static BigInteger nchoosek(long n, long k) {	
		if(k == 0 || n == 0) {
			return BigInteger.ONE;	
		}
		
		BigInteger factorialN = factorial(n);
		BigInteger factorialK = factorial(k);
		BigInteger divide = factorialK.multiply(factorial((n - k))); 
	
		BigInteger result = factorialN.divide(divide);
		
		return result;
	}

}