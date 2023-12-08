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
	public static void main(String[] args) {
		Random r = new Random();
		long start, end; 
		System.out.println("base10tobase2A");
		start = System.currentTimeMillis(); 
		System.out.println(base10tobase2A(r.nextInt(10000)));
		end = System.currentTimeMillis(); 
		System.out.println(end - start);
		System.out.println("base10tobase2A");
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
		System.out.println(base2tobase10B(generateRandomStack()));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("base2tobase10A");
		start = System.currentTimeMillis();
		System.out.println(base2tobase10A(1010101));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}
	/**
	 * This method iteratively converts n from base 10 to base 2 
	 * Precondition - n is a non-negative integer and not null
	 * Postcondition - returns n as a base 2 string 
	 */
	public static String base10tobase2A (int n) {
		//string placeholder for concatenation of binary digits
		String binaryStr = "";
		while (n > 0) {
			//front placement allows for binary digit to be from least significant to most
			//implicit casting to string
			binaryStr = (n % 2) + binaryStr;
			//shifts right to binary digit 
			n /=2;
		}
		return binaryStr; 
	}
	/** This method recursively converts n from base 10 to base 2
	 * Precondition - n is a non-negative integer and not null  
	 * Postcondition - returns n as a base 2 string
	 */
	public static String base10tobase2B(int n) {
		//base case prevents infinite loop
		//implicit casting to string
		if (n == 0) return "";
		//unwinding process reverses 
		return base10tobase2B(n/2) + n%2;
	}
	/**
	 * This method iteratively converts n array from base 10 to base 2
	 * Precondition - n is an array of non-negative integers,  
	 * Postcondition - new string array containing the binary representations
	 */
	public static String[] base10tobase2C(int[] n) {
		//string array needed for string manipulation 
	    String[] stringArr = new String[n.length];
	    for (int i = 0; i < n.length; i++) {
	        int cur = n[i];
	        //implicit casting and concatenating established
	        String binaryStr = "";
	        while (cur > 0) {
	        	//added at front
	            binaryStr = (cur % 2) + binaryStr; 
	            //shifts to the right binary digit
	            cur /= 2;
	        }
	        stringArr[i] = binaryStr;
	    }
	    return stringArr;
	}
	/**
	 * This method iteratively converts n from base 2 to base 10 
	 * Precondition - 
	 * Postcondition - 
	 */
	public static int base2tobase10A(int n) {
		String binaryStr = Integer.toString(n);
		int base10 = 0;
		int length = binaryStr.length(); 
		for(int i =0; i< length; i++) {
			int binaryDigit = binaryStr.charAt(i) - '0';
			base10 += binaryDigit * Math.pow(2, length-i-1);
		}
		return base10;
	}
	/*
	 * This method 
	 * Precondition - n is a stack of non negative numbers
	 * Postcondition - n stack will be in reversed order
	 */
	public static Stack<Integer> base2tobase10B(Stack<Integer> n) {
		Stack<Integer> s = new Stack<Integer>();
		int base10 = 0; 
		while(!(n.isEmpty())) {
			String binaryCur = Integer.toString(n.pop());
			for(int i =0; i< binaryCur.length(); i++) {
				int binaryDigit = binaryCur.charAt(i) - '0';
				base10 += binaryDigit * Math.pow(2,binaryCur.length()-i-1);
				s.push(base10);
			}
		}
		return s;
	}
	/*
	 * This method
	 * Precondition 
	 * Postcondition 
	 */
	public static String base2tobaseHexA(int n) {
		String binaryStr = Integer.toString(n);
	    int length = (int) Math.ceil((double) binaryStr.length() / 4.0);
	    while (binaryStr.length() < length * 4) {
	        binaryStr = "0" + binaryStr;
	    }
	    char[] hexResult = new char[length];
	    for (int i = 0; i < length; i++) {
	        int binaryToBase10Sum = 0;
	        for (int j = 0; j < 4; j++) {
	            binaryToBase10Sum += (binaryStr.charAt(i * 4 + j) - '0') * Math.pow(2, 3 - j);
	        }
	        if (binaryToBase10Sum < 10) {
	            hexResult[i] = (char) ('0' + binaryToBase10Sum);
	        } else {
	            hexResult[i] = (char) ('A' + binaryToBase10Sum - 10);
	        }
	    }
	    return new String(hexResult);
	}
	/*/
	 * This method is
	 * Precondition 
	 * Postcondition 
	 */
	public static String base2tobaseHexB(int n) {
		return null;
	}
	public static String baseHexToBase2A(String hexStr) {
	    String binaryStr = "";

	    for (int i = 0; i < hexStr.length(); i++) {
	        char hexChar = hexStr.charAt(i);
	        int base10Value;
	        if (hexChar >= '0' && hexChar <= '9') {
	            base10Value = hexChar - '0';
	        } else if (hexChar >= 'A' && hexChar <= 'F') {
	            base10Value = 10 + hexChar - 'A';
	        } else {
	            base10Value = 10 + hexChar - 'a';
	        }

	        String binaryValue = "";
	        for (int j = 3; j >= 0; j--) {
	            int power = (int) Math.pow(2, j);
	            if (base10Value >= power) {
	                binaryValue += "1";
	                base10Value -= power;
	            } else {
	                binaryValue += "0";
	            }
	        }
	        binaryStr += binaryValue;
	    }

	    return binaryStr;
	}
	public static String baseHexToBase2B(String hexStr) {
		 String hexResult = "";
		    String[] binaryValues = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111" };
		    String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

		    while (binaryInput.length() % 4 != 0) {
		        binaryInput = "0" + binaryInput;
		    }

		    for (int i = 0; i < binaryInput.length(); i += 4) {
		        String chunk = binaryInput.substring(i, i + 4);
		        for (int j = 0; j < binaryValues.length; j++) {
		            if (chunk.equals(binaryValues[j])) {
		                hexResult += hexDigits[j];
		            }
		        }
		    }

		    return hexResult;
	}
	public static int arrayListSumOfUniqueElements(ArrayList<Integer> arrayList) {
	    int sum = 0;
	    for (int i = 0; i < arrayList.size(); i++) {
	        boolean isUnique = true;
	        for (int j = 0; j < i; j++) {
	            if (arrayList.get(i).equals(arrayList.get(j))) {
	                isUnique = false;
	                break;
	            }
	        }
	        if (isUnique) {
	            sum += arrayList.get(i);
	        }
	    }
	    return sum;
	}
	public static ArrayList<Integer> arrayListTwoSum(ArrayList<Integer> arrayList, int target) {
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
	public static ArrayList<Integer> calculateSumsFromFile(File file) throws FileNotFoundException {
        ArrayList<Integer> sumsOfDigits = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextInt()) {
            sumsOfDigits.add(sumOfDigitsA(scanner.nextInt()));
        }
        scanner.close();
        return sumsOfDigits;
	}
	public static int modSum2(int [] ints, int target) {
		int len = ints.length;
		int sum =0;
		for(int i =0 ; i< len ;i++) {
			if(ints[i] < target) {
				sum += ints[i];
			}
		}
		return sum;
	}
	public static boolean isPrime(int number) {
        //exception case for 2
		if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            //whenever there is a factor, the number cannot be prime
        	if (number % i == 0) {
                return false;
            }
        }
        return true;
	
	}
	public static int sumOfDigitsA(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
	public static String reverseWordA(String s) {
		//breaks up the string an array of character
		char[] chararr = s.toCharArray();
		int left = 0, right = chararr.length-1;
		//increasing and decreasing pointers until a middle is reached
		while (left <right) {
			char temp = chararr[left];
			chararr[left++] = chararr[right];
			chararr[right--]  = temp;
		}
		return new String(chararr);
		
	}
	
	public static String[] reverseWordB(String [] s) {
		String result = "";
		//double loop through length of s array
		for(int i = 0; i<s.length; i++) {
			//reverse the individual elements of s array
			for(int j = s[i].length()-1; j>=0; j--) {
				result += s[i].charAt(i);
			}
			//change the string to the reversed string at index i
			s[i] = result;
		}
		return s;
	}
	/**
	 * This method 
	 */
	public static boolean validParenthesesA(String s)  {
		Stack<Character> stack = new Stack<>();
	    for (char cur : s.toCharArray()) {
	        if (cur == '{' || cur == '[' || cur == '(') {
	            stack.push(cur);
	        } else if (!stack.isEmpty() && 
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
	 * This method
	 * Precondition - 
	 * Postcondition - 
	 */
	public static int calculateNumberOfPermutations(int size) {
	    int result = 1;
	    for (int i = 1; i <= size; i++) {
	        result *= i;
	    }
	    return result;
	}
	/**
	 * This method 
	 * Precondition - 
	 * Postcondition - 
	 */
	public boolean canBalance(int[] nums) {
	    int first = 0;
	    int second = 0;
	      
	    for(int i = 0; i < nums.length; i++)
	        second += nums[i];
	              
	    for(int i = 0; i <= nums.length - 2; i++) {
	        first += nums[i];
	        second -= nums[i];
	                            
	        if(first == second)
	            return true;
	    }
	                                          
	    return false;
	}
	/**
	 * This method takes two parameters, num1 and num2, that perform various
	 * Precondition - 
	 * Postcondition - arithmetic operations have num1 with higher precedence 
	 */
	public static double[] performAllOperations(int num1, int num2) {
	    double sum = num1 + num2;
	    double difference = num1 - num2;
	    double product = num1 * num2;
	    double division = 0;
	    //
	    if (num2 != 0) {
	        division = (double) num1 / num2;
	    }

	    return new double[]{sum, difference, product, division};
	}
	
	
	
	
	
	/*
	 * Helper Methods for test inputs involving data structures (array, arraylist, stacks)
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
		   int size = random.nextInt(20) +1;
		   String binary = "";
		   for(int i =0; i< size; i++) {
			   binary+= random.nextInt(2); 
		   }
		   return Integer.parseInt(binary);
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
    public static void generateRandomNumberFile(File file) {
        try {     
        	PrintWriter pw = new PrintWriter(new FileWriter(file));
            Random random = new Random();
            for(int i = 0; i < random.nextInt(100) + 1; i++) {
                pw.println(random.nextInt(1000));
            }
            pw.close();
        } catch(Exception e) {
   }
  
 }
}
