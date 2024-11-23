// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.



public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
		System.out.println(times(-3,-4));
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		while (x2 != 0){
			if (x2 > 0) {
				x1 ++;
				x2 --;
			}

			else {
				x1 --;
				x2 ++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		return plus (x1, -x2);
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0){
			return 0;
		}

		boolean isNegative = false; 
		if (x1 < 0) {
			x1 = -x1;
			isNegative = !isNegative;
		}
		if (x2 < 0) {
			x2 = -x2;
			isNegative = !isNegative;
		}

		int result = 0 ;
        for (int i = 0; i < x2; i++){
			result = plus(result, x1);
		}

		if (isNegative) {
			result = -result;
		}

		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0){
			return 1;
		}
		int result = 1;
		for (int i = 0; i < n; i ++){
			result = times(result, x);
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
        if (x1 == 0){
			return 0;
		}

		boolean isNegative = false; 
		if (x1 < 0) {
			x1 = -x1;
			isNegative = !isNegative;
		}
		if (x2 < 0) {
			x2 = -x2;
			isNegative = !isNegative;
		}

		int result = x1 ;
		int count = 0; 

        while (result >= x2){
			result = minus(result, x2);
			count ++;
		}

		if (isNegative) {
			count = -count;
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x1 == 0){
			return 0;
		}

		boolean isNegative = false; 
		if (x1 < 0) {
			x1 = -x1;
			isNegative = !isNegative;
		}
		if (x2 < 0) {
			x2 = -x2;
			isNegative = !isNegative;
		}

		int result = x1 ;

		while (result >= x2){
			result = minus(result, x2);
		}

		if (isNegative){
			result = minus(x2, result);
		}

		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
        if (x == 0 || x == 1){
			return x;
		}
		int numToMultiply = 1;
		int result = 0; 
		while (times(numToMultiply, numToMultiply) <= x){
			result = numToMultiply;
			numToMultiply = plus(numToMultiply, 1);
		}
		return result;
	}	  	   
}