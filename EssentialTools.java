import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class EssentialTools {
	public static void main(String[] args) throws FileNotFoundException {
		Random r = new Random();
		long start, end; 
		System.out.println("base10tobase2A");
		start = System.currentTimeMillis(); 
		System.out.println(base10tobase2A(r.nextInt(10000)));
		end = System.currentTimeMillis(); 
		System.out.println(end - start);
		System.out.println("base10tobase2B");
		start = System.currentTimeMillis(); 
		System.out.println(base10tobase2B(r.nextInt(10000)));
		end = System.currentTimeMillis(); 
		System.out.println(end - start);
		System.out.println("base10tobase2C");
		start = System.currentTimeMillis();
		System.out.println(Arrays.toString(base10tobase2C(generateRandomArray())));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("base2tobase10A");
		start = System.currentTimeMillis();
		System.out.println(base2tobase10A(generateBinary()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("base2tobase10B");
		start = System.currentTimeMillis();
		//fix this
		System.out.println(base2tobase10B(generateRandomStack()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("base2tobaseHexA");
		start = System.currentTimeMillis();
		System.out.println(base2tobaseHexA(generateBinary()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("base2tobaseHexB");
		start = System.currentTimeMillis();
		System.out.println(base2TobaseHexB(generateBinary()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("baseHextobase2A");
		start = System.currentTimeMillis();
		System.out.println(baseHexToBase2A(generateHex()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("baseHextobase2B");
		start = System.currentTimeMillis();
		System.out.println(baseHexToBase2A(generateHex()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("arrayListSumOfUniqueElements");
		start = System.currentTimeMillis();
		System.out.println(arrayListSumOfUniqueElements(generateRandomArrayList()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("arrayListTwoSum");
		start = System.currentTimeMillis();
		System.out.println(arrayListTwoSum(generateRandomArrayList(), r.nextInt(50)+1));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("calculateSumDigitFromFile");
		start = System.currentTimeMillis();
		System.out.println(calculateSumsFromFile(generateRandomNumberFile()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("lessThanSum");
		start = System.currentTimeMillis();
		System.out.println(lessThanSum(generateRandomArray(), r.nextInt(50)));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("isPrime");
		start = System.currentTimeMillis();
		System.out.println(isPrime(r.nextInt(100000)));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("sumOfDigits");
		start = System.currentTimeMillis();
		System.out.println(sumOfDigitsA(r.nextInt(10000)));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("reverseWordA");
		start = System.currentTimeMillis();
		System.out.println(reverseWordA(generateRandomWord()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("reverseWordB");
		start = System.currentTimeMillis();
		System.out.println(Arrays.toString(reverseWordB(generateRandomWordArray())));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("validParantheses");
		start = System.currentTimeMillis();
		System.out.println(validParenthesesA(generateRandomParentheses()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("calculateNumberOfPermutations");
		start = System.currentTimeMillis();
		System.out.println(calculateNumberOfPermutations(r.nextInt(15)+1));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("canBalance");
		start = System.currentTimeMillis();
		System.out.println(canBalance(generateRandomArray()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("performAllOperations");
		start = System.currentTimeMillis();
		System.out.println(Arrays.toString(performAllOperations(r.nextInt(100), r.nextInt(100))));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}
	/**
	 * This method iteratively converts n from base 10 to base 2 
	 * Precondition - n is a non-negative integer and not null
	 * Postcondition - returns n as a base 2 string 
	 */
	public static String base10tobase2A (int n) {
		System.out.println("base10: " + n);
		String binaryStr = "";
		//conditional loop given unknown int n 
		while (n > 0) {
			//concatenates least significant bit after implicit casting to string
			binaryStr = (n % 2) + binaryStr;
			//shifts to next bit 
			n /=2;
		}
		return binaryStr; 
	}
	/** This method recursively converts n from base 10 to base 2
	 * Precondition - n is a non-negative integer and not null  
	 * Postcondition - returns n as a base 2 string
	 */
	public static String base10tobase2B(int n) {
		//base case to prevent infinite loop and implicit casting to string
		if (n == 0) return "";
		//unwinding process from most significant bit to least
		return base10tobase2B(n/2) + n%2;
	}
	/**
	 * This method iteratively converts n array from base 10 to base 2
	 * Precondition - n is an array of non-negative integers 
	 * Postcondition - new string array containing the binary representations
	 */
	public static String[] base10tobase2C(int[] n) {
		System.out.println("base10: " + Arrays.toString(n));
		//needed for string manipulation 
	    String[] stringArr = new String[n.length];
	    //counting loop for static data structure (array)
	    for (int i = 0; i < n.length; i++) {
	        int cur = n[i];
	        //implicit casting so concatenating established
	        String binaryStr = "";
	        //conditional loop given unknown int n 
	        while (cur > 0) {
	        	//adds bit from least significant to greatest
	            binaryStr = (cur % 2) + binaryStr; 
	            cur /= 2;
	        }
	        stringArr[i] = binaryStr;
	    }
	    return stringArr;
	}
	/**
	 * This method iteratively converts n from base 2 to base 10 
	 * Precondition - n is a base 2 integer and not null 
	 * Postcondition - n is a base 10 integer 
	 */
	public static int base2tobase10A(int n) {
		System.out.println("base2: " + n);
		String binaryStr = Integer.toString(n);
		int base10 = 0;
		int length = binaryStr.length(); 
		for(int i =0; i< length; i++) {
			//uses char-int lenient casting 
			int binaryDigit = binaryStr.charAt(i) - '0';
			//reverse order to loop to map the exponents 
			base10 += binaryDigit * Math.pow(2, length-i-1);
		}
		return base10;
	}
	/**
	 * This method takes in a stack of base 2 integers by popping and individually converting the integer 
	 * element from base 2 to base 10 
	 * Precondition - n is a stack of non negative and base 2 integers 
	 * Postcondition - n stack will be empty and new stack s will have base 10 integers in reverse order
	 */
	public static Stack<Integer> base2tobase10B(Stack<Integer> n) {
		System.out.println("base2: " + n);
		//dynamic data structure - LIFO 
		Stack<Integer> s = new Stack<Integer>();
		int base10 = 0; 
		while(!(n.isEmpty())) {
			//placeholder to prevent from stack being popped more than once in a single iteration. 
			String binaryCur = Integer.toString(n.pop());
			for(int i =0; i< binaryCur.length(); i++) {
				int binaryDigit = binaryCur.charAt(i) - '0';
				//reverse order of exponents per iteration. 
				base10 += binaryDigit * Math.pow(2,binaryCur.length()-i-1);
				s.push(base10);
			}
		}
		return s;
	}
	/**
	 * This method iteratively converts base 2 integer to base hex String. This is done by adding padding 
	 * to the binary integer inputs that aren't a multiple of 4. Then this is transformed into base 10 result 
	 * where it is converted into hex using character manipulating. 
	 * Precondition - binaryInt is a non-negative integer and in base 2
	 * Postcondition - Uppercase base hex of binaryInt as string. 
	 */
	public static String base2tobaseHexA(int binaryInt) {
	    System.out.println("binary: " + binaryInt);
		String binaryStr = Integer.toString(binaryInt);
	    //adding padding to be able group binary into groups of 4
		while (binaryStr.length() % 4 != 0) {
	        binaryStr = "0" + binaryStr;
	    }
	    String hexResult = "";
	    //groups of 4 as that's how 
	    for (int i = 0; i < binaryStr.length(); i += 4) {
	        int base10Value = 0;
	        for (int j = 0; j < 4; j++) {
	            base10Value += (binaryStr.charAt(i + j) - '0') * Math.pow(2, 3 - j);
	        }
	        //char manipulation (int) based on the based calculated value 
	        if (base10Value < 10) {
	            hexResult += (char) ('0' + base10Value);
	        } else {
	            hexResult += (char) ('A' + base10Value - 10);
	        }
	    }
	    return hexResult;
	}
	/**
	 * This method converts base 2 integer to base hex string. This is done by having a predefined two double
	 * dimensional array of arrays mapping each base 2 to hex value. 
	 * Precondition - binNum is a non-negative, not null base 2 integer  
	 * Postcondition - Uppercase base hex of binNum as string 
	 */
	public static String base2TobaseHexB(int binNum) {
		System.out.println("binary: " + binNum);
	    String binaryStr = Integer.toString(binNum);
	    String[][] map = {
	        {"0000", "0"}, {"0001", "1"}, {"0010", "2"}, {"0011", "3"},
	        {"0100", "4"}, {"0101", "5"}, {"0110", "6"}, {"0111", "7"},
	        {"1000", "8"}, {"1001", "9"}, {"1010", "A"}, {"1011", "B"},
	        {"1100", "C"}, {"1101", "D"}, {"1110", "E"}, {"1111", "F"}
	    };

	    while (binaryStr.length() % 4 != 0) {
	        binaryStr = "0" + binaryStr;
	    }

	    String hexResult = "";
	    for (int i = 0; i < binaryStr.length(); i += 4) {
	        String binSegment = binaryStr.substring(i, i + 4);
	        for (int j = 0; j < map.length; j++) {
	            if (binSegment.equals(map[j][0])) {
	                hexResult += map[j][1];
	                break;
	            }
	        }
	    }

	    return hexResult;
	}
	/**
	 * This method converts a baseHex string to base 2. This is done by converting the hex string into base 10 
	 * where it loops through groups of 4 to find the combination such that it is equal in base 2.
	 * Precondition - String must contain base hex digits and not be null
	 * Postcondition - returns a base 2 string of hexStr 
	 */
	public static String baseHexToBase2A(String hexStr) {
		System.out.println("hex: " + hexStr);
	    String binaryResult = "";
	    //calculates base10
	    for (int i = 0; i < hexStr.length(); i++) {
	        char hexChar = hexStr.charAt(i);
	        int base10value;
	        if (hexChar >= '0' && hexChar <= '9') {
	            base10value = hexChar - '0';
	        } else {
	            base10value = 10 + hexChar - 'A';
	        }
	        //from base 10 to base hex 	
	        String binarySegment = "";
	        for (int j = 3; j >= 0; j--) {
	            int power = (int) Math.pow(2, j);
	            if (base10value >= power) {
	                binarySegment += "1";
	                base10value -= power;
	            } else {
	                binarySegment += "0";
	            }
	        }
	        binaryResult += binarySegment;
	    }

	    return binaryResult;
	}
	/**
	 * This method converts a string from base hex to base. 2. This is done by having a predefined two 
	 * dimensional array that corresponds hex value to binary value which found with a nestedloop. 
	 * Precondition - hexStr must be non-null string and contain hex digits, 
	 * Postcondition - hexStr as base 2 string 
	 */
	public static String baseHexToBase2B(String hexStr) {
		System.out.println("hex: " + hexStr); 
	    //casting + concetenation start 
		String binaryResult = "";
	    String[][] map = {
	        {"0", "0000"}, {"1", "0001"}, {"2", "0010"}, {"3", "0011"},
	        {"4", "0100"}, {"5", "0101"}, {"6", "0110"}, {"7", "0111"},
	        {"8", "1000"}, {"9", "1001"}, {"A", "1010"}, {"B", "1011"},
	        {"C", "1100"}, {"D", "1101"}, {"E", "1110"}, {"F", "1111"}
	    };
	    //check each element 
	    for (int i = 0; i < hexStr.length(); i++) {
	        //check in map array 
	    	for (int j = 0; j < map.length; j++) {
	            if (hexStr.charAt(i) == map[j][0].charAt(0)) {
	                binaryResult += map[j][1];
	                //ending premutarely once found to avoid unnecessary comparisons 
	                break;
	            }
	        }
	    }

	    return binaryResult;
	}
	/**
	 * This method calculates the sum of unique elements in an arrayList. This is done by iterating
	 * through every element in the list and checking every elemnt prior to check for duplicates
	 * Precondition - arrayList must be an arrayList not with null
	 * Postcondition - an integer that has sum of all unique elements 
	 */
	public static int arrayListSumOfUniqueElements(ArrayList<Integer> arrayList) {
	    System.out.println("arrayList " + arrayList);
		int sum = 0;
	    for (int i = 0; i < arrayList.size(); i++) {
	        boolean isUnique = true;
	        //checking all prior elements to find 
	        for (int j = 0; j < i; j++) {
	            if (arrayList.get(i).equals(arrayList.get(j))) {
	                isUnique = false;
	                //break to avoid unnecesary comparison if it is already a duplicate
	                break;
	            }
	        }
	        if (isUnique) {
	            sum += arrayList.get(i);
	        }
	    }
	    return sum;
	}
	/**
	 * This method finds two elements that add up to the passed integer target value. Through a nested loop, 
	 * it iterates until it finds the two elements and creates a subarraylist and if not, it returns a [0,0] arraylist
	 * Precondition - an arraylist with non-negative, null integers and a non negative integer target
	 * Postcondition - a subarraylist contaning the elmenets 
	 */
	public static ArrayList<Integer> arrayListTwoSum(ArrayList<Integer> arrayList, int target) {
	    System.out.println("arrayList " + arrayList + "target " + target);
		ArrayList<Integer> result = new ArrayList<>(2);
	    for (int i = 0; i < arrayList.size(); i++) {
	        for (int j = i + 1; j < arrayList.size(); j++) {
	            if (arrayList.get(i) + arrayList.get(j) == target) {
	                result.add(arrayList.get(i));
	                result.add(arrayList.get(j));
	                return result;
	            }
	        }
	    }
	    result.add(0);
	    result.add(0);
	    return result; 
	}
	/**
	 * This method calculates the sum of digits of a file. It uses a scanner object with a passed file 
	 * to read the written file where as scanner checks if there is an integer remaining in the file, this 
	 * borrows the logic from sumOfDigits (repeatedly shifting and modulus) 
	 * Precondition - File containing integers
	 * Postcondition - Arraylist of the sum of the digits of the integers in the file 
	 */
	public static ArrayList<Integer> calculateSumsFromFile(File file) throws FileNotFoundException {
        ArrayList<Integer> sumsOfDigits = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextInt()) {
            sumsOfDigits.add(sumOfDigitsA(scanner.nextInt()));
        }
        scanner.close();
        return sumsOfDigits;
	}
	/**
	 * This method takes an array of integers and target. 
	 * Precondition
	 * Postcondition
	 */
	public static int lessThanSum(int [] ints, int target) {
		System.out.println("ints: " + Arrays.toString(ints) + " target " + target);
		int len = ints.length;
		int sum =0;
		for(int i =0 ; i< len ;i++) {
			if(ints[i] < target) {
				sum += ints[i];
			}
		}
		return sum;
	}
	/**
	 * This method determines whether an integer is a prime number. By using the modulus operator, if one of the 
	 * factors produces a non-zero remainder, then it can't be a prime number. 
	 * Precondition - number is a non-negative, not null integer
	 * Postcondition - boolean indicating if number is a prime or not 
	 */
	public static boolean isPrime(int number) {
		System.out.println("number " + number);
        //exception case for 2
		if (number < 2) {
            return false;
        }
		//optimization up to square root because factors below the square of the number will not exist 
        for (int i = 2; i <= Math.sqrt(number); i++) {
            //whenever there is a factor, the number cannot be prime
        	if (number % i == 0) {
                return false;
            }
        }
        return true;
	
	}
	/**
	 * This method adds up the digits of a given integer. It does repeatedly modolus and division so
	 * right most digit is extracted and shifted until integer is 0. 
	 * Precondition - number must be a non negative, non null integer
	 * Postcondition - an integer of sumofdigits 
	 */
	public static int sumOfDigitsA(int number) {
		System.out.println("number " + number);
        int sum = 0;
        //conditional loop given the amount of digits is not known. 
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
	/**
	 * This method reverses a String s by setting two points (left, right) that move in opposite directions 
	 * such that the elements swap until it reaches the centre where the string would have to be fully 
	 * reversed
	 * Precondition - String s must not be null and not empty
	 * Postcondition - String s will be reversed 
	 */
	public static String reverseWordA(String s) {
		System.out.println("word " + s);
		//breaks up the string an array of character
		char[] chararr = s.toCharArray();
		int left = 0, right = chararr.length-1;
		//increasing and decreasing pointers until a middle is reached
		while (left <right) {
			//direct type which raises the need for temp variable 
			char temp = chararr[left];
			chararr[left++] = chararr[right];
			chararr[right--]  = temp;
		}
		return new String(chararr);
		
	}
	/**
	 * This method reverses an array of strings by individually reversing the element by looping backwards and
	 * reconstructing with new String by which replaces the non-reversed element in the array 
	 * Precondition - Array s is an array of non-null strings, array does not have to remain in same state 
	 * Postcondition - every element in array is reverse its original
	 */
	public static String[] reverseWordB(String[] s) {
	    System.out.println("word " + Arrays.toString(s));
	    // Iterate through each string in the array
	    for (int i = 0; i < s.length; i++) {
	        String result = ""; 
	        // Reverse the individual elements of the s array
	        for (int j = s[i].length() - 1; j >= 0; j--) {
	            //replace the element 
	        	result += s[i].charAt(j);
	        }
	        s[i] = result;
	    }
	    return s;
	}
	/**
	 * This method checks whether a string is arranged such that every bracket is closed. This works by pushing 
	 * the open bracket and popping the closing bracket which means if every bracket is closed, no elements 
	 * should remain in the stack
	 * Precondition - String s must be not null and be made up only of parenthesis characters
	 * Postcondition - a boolean (true, false) indicating whether they are fully closed 
	 */
	public static boolean validParenthesesA(String s)  {
		System.out.println("parentehses: " + s);
		Stack<Character> stack = new Stack<>();
	    for (char cur : s.toCharArray()) {
	        if (cur == '{' || cur == '[' || cur == '(') {
	            stack.push(cur);
	        } 
	        //shortcircuiting - prevents from conditional statement being called if unnecesary
	        else if (!stack.isEmpty() && 
	                  ((cur == '}' && stack.peek() == '{') || 
	                   (cur == ']' && stack.peek() == '[') || 
	                   (cur == ')' && stack.peek() == '('))) {
	            stack.pop();
	        } else {
	            return false;
	        }
	    }
	    return true;
	}
	/**
	 * This method essentially simulates a factorial by multiplying all the numbers below the size of it 
	 * Precondition - size is a non-negative integer
	 * Postcondition - factorial of the size, indicating the amount of permutations 
	 */
	public static int calculateNumberOfPermutations(int size) {
		System.out.println("size " + size);
	    int result = 1;
	    //loop simulates a factorial
	    for (int i = 1; i <= size; i++) {
	        result *= i;
	    }
	    return result;
	}
	/**
	 * This method determines whether the array of integers can be split into two parts with equal sums. 
	 * Precondition - nums is a non empty array of integers
	 * Postcondition - boolean whether the array can be split 
	 */
	public static boolean canBalance(int[] nums) {
	    System.out.println("nums " + Arrays.toString(nums));
		int first = 0;
	    int second = 0;
	      
	    for(int i = 0; i < nums.length; i++)
	        second += nums[i];
	              
	    for(int i = 0; i <= nums.length - 2; i++) {
	        //accumulate and decreement sums from placeholders 
	    	first += nums[i];
	        second -= nums[i];
	                            
	        if(first == second)
	            return true;
	    }
	                                          
	    return false;
	}
	/**
	 * This method takes two parameters, num1 and num2 that perform basic arithmetic operation. 
	 * operations. 
	 * Precondition - num1 has higher precedence than num2 
	 * Postcondition - returns an array of doubles of arithmetic operation results, 
	 */
	public static double[] performAllOperations(int num1, int num2) {
	    System.out.println("num1 " + num1);
	    System.out.println("num2 " + num2);
		double sum = num1 + num2;
	    double difference = num1 - num2;
	    double product = num1 * num2;
	    //default 0 to prevent dividing by 0 arithmetic errors
	    double division = 0;
	    if (num2 != 0) {
	        division = (double) num1 / num2;
	    }
	    return new double[]{sum, difference, product, division};
	}
	/**
	 * This method converts base 10 integer to a specified base. This works by dividing 
	 * n by base until base case such that bits are appended from left to right
	 * Precondition - n base is between 2 and 10
	 * Postcondition - returns string in specified base
	 */
	public static String base10tobaseN(int n, int base) {
		//base case + concatenation/implicit casting 
		if(n == 0)return "";
		//unwinding from most significant bit to least
		return base10tobaseN(n/base, base) + (n%base);
	}
	/*
	 * Helper Methods for test inputs involving data structures (array, arraylist, stacks), words, files and specific problems
	 */
	public static Stack<Integer> generateRandomStack() {
        Random random = new Random();
        int size = random.nextInt(20) + 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            stack.push(random.nextInt(100));
        }
        return stack;
    }
	 public static int generateBinary() {
		   Random random = new Random();
		   int size = random.nextInt(9) +1;
		   String binary = "";
		   for(int i =0; i< size; i++) {
			   binary+= random.nextInt(2); 
		   }
		   return Integer.parseInt(binary);
	}
	 public static String generateHex() {
		Random random = new Random();
		int size = random.nextInt(9) + 1; 
		String hex = "";
		for (int i = 0; i < size; i++) {
		   int digit = random.nextInt(16); 
		   if (digit < 10) {
		     hex += digit;
		   } else {
		    hex += (char)('A' + (digit - 10));
		     }
		   }
		  return hex;
		}
    public static ArrayList<Integer> generateRandomArrayList() {
        Random random = new Random();
        int size = random.nextInt(20) + 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(100));
        }
        return arrayList;
    }

    public static int[] generateRandomArray() {
        Random random = new Random();
        int size = random.nextInt(20) + 1;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
    public static File generateRandomNumberFile() {
        File file = new File("./temp1.txt");

        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            Random random = new Random();
            for (int i = 0; i < random.nextInt(100) + 1; i++) {
                pw.println(random.nextInt(1000));
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return file;
    }
    public static String generateRandomWord() {
        Random random = new Random();
        int wordLength = random.nextInt(10) + 1; 
        char[] word = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            word[i] = (char) ('a' + random.nextInt(26));
        }
        return new String(word);
    }
    public static String[] generateRandomWordArray() {
    	Random random = new Random(); 
    	int length = random.nextInt(50);  
    	String[] words = new String[length];
    	for(int i =0; i<length; i++) {
    		words[i] = generateRandomWord();
    	}
    	return words;
    }
    public static String generateRandomParentheses() {
        Random random = new Random();
        int pairCount = random.nextInt(5) + 1; 
        int totalLength = pairCount * 6;
        char[] parentheses = new char[totalLength];

        for (int i = 0; i < pairCount; i++) {
            parentheses[i * 6] = '(';
            parentheses[i * 6 + 1] = '[';
            parentheses[i * 6 + 2] = '{';
            parentheses[i * 6 + 3] = ')';
            parentheses[i * 6 + 4] = ']';
            parentheses[i * 6 + 5] = '}';
        }
        for (int i = 0; i < totalLength; i++) {
            int swapIndex = random.nextInt(totalLength);
            char temp = parentheses[i];
            parentheses[i] = parentheses[swapIndex];
            parentheses[swapIndex] = temp;
        }

        return new String(parentheses);
    }
 }
