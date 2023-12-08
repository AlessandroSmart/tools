import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class CoreTools {
	public static void main(String[] args) {
		long start = System.nanoTime();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);	
		arr.add(2);	
		arr.add(3);	
		
		System.out.println(permutation(arr));
		long end = System.nanoTime();
		System.out.println(end - start);
		
	}
	/**
	  * This method generates and evaluates a random postfix expression using a stack-based approach.
	  * Precondition: No input is needed. 
	  * Postcondition: Outputs the total result of the generated and evaluated postfix expression.
	 */
	public static void generateAndCalulatePostfixe() {
		   try {
	            File file = new File("./temp.txt");
	            PrintWriter pw = new PrintWriter(file);
	            Random r = new Random();
	            //randomized length
	            int expressionLength = 100 + r.nextInt(101); 
	            int operandsCount = 0, operatorsCount = 0;
	            //ensures more operands than operators to avoid calculation errors 
	            while (operandsCount + operatorsCount < expressionLength) {
	                if (operandsCount > operatorsCount + 1 && r.nextBoolean()) {
	                    char operator = "+-*(/".charAt(r.nextInt(4));
	                    pw.print(operator + " ");
	                    operatorsCount++;
	                } else {
	                    int operand = r.nextInt(10) + 1;
	                    pw.print(operand + " ");
	                    operandsCount++;
	                }
	            }
	            pw.close();
	            //Reading the generated 
	            Scanner scanner = new Scanner(file);
	            Stack<Integer> stack = new Stack<>();
	            /**
	             * 
	             */
	            while (scanner.hasNext()) {
	                String token = scanner.next();
	                if (token.matches("\\d+")) {
	                    stack.push(Integer.parseInt(token));
	                } else {
	                    int val1 = stack.pop();
	                    int val2 = stack.pop();
	                    switch (token.charAt(0)) {
	                        case '+':
	                            stack.push(val2 + val1);
	                            break;
	                        case '-':
	                            stack.push(val2 - val1);
	                            break;
	                        case '*':
	                            stack.push(val2 * val1);
	                            break;
	                        case '/':
	                            stack.push(val1 == 0 ? 0 : val2 / val1); //Zero division edge case
	                            break;
	                    }
	                }
	            }
	            scanner.close();
	            int result = stack.isEmpty() ? 0 : stack.pop();
	            System.out.println("Result = " + result);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	/**
	  * Generates the largest number possible by rearranging the numbers in an array.
	  * Precondition: The input array should not be null and must contain integers.
 	  * Postcondition: Returns largest number string formed from integer array
	 */
	public static String largestNumber(int[] nums) {
	    //implement bubble sorting algorithm by repeatedly comparing adjacent elements 
		for (int i = 0; i < nums.length; i++) {
	        for (int j = 1; j < nums.length - i; j++) {
	            //use string concatenation for lexicograpihcal ordering. 
	        	if ((String.valueOf(nums[j - 1]) + nums[j]).compareTo(String.valueOf(nums[j]) + nums[j - 1]) < 0) {
	                //swap the elements 
	        		int temp = nums[j - 1];
	                nums[j - 1] = nums[j];
	                nums[j] = temp;         
	            }
	        }
	    }
		//edge case if largest number is 0, then all other numbers must be 0
	    if (nums[0] == 0) return "0";
	    //reconstructs the string based on new order
	    String largestNumberStr = "";
	    for (int num : nums) {
	        largestNumberStr += num;
	    }
	    return largestNumberStr;
	}
	/**
	 * Generates all possible permutations of a given list of integers.
	 * Precondition: The input should not be null.
	 * Postcondition: Returns a list of lists, representing all possible permutations. 
 	*/
	public static ArrayList<ArrayList<Integer>> permutation(ArrayList<Integer> list) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    if (list.isEmpty()) {
	    	System.out.println(result);
	        result.add(new ArrayList<>());
	        return result;
	    }
	    System.out.println(list);
	    int firstElement = list.remove(0);
	    ArrayList<ArrayList<Integer>> permutations = permutation(list);

	    for (ArrayList<Integer> sublist : permutations) {
	        for (int i = 0; i <= sublist.size(); i++) {
	        	ArrayList<Integer> temp = new ArrayList<>(sublist);
	        	System.out.println(temp);
	            temp.add(i, firstElement);
	            System.out.println(temp);
	            result.add(temp);
	            System.out.println(result);
	        }
	    }o

	    list.add(0, firstElement); 
	    return result;
	}
}
