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
		 long start, end;
		start = System.nanoTime();
        generateAndCalulatePostfix();
        end = System.nanoTime();
        System.out.println("Execution Time (generateAndCalculatePostfix Test 1): " + (end - start) / 1_000_000.0 + " milliseconds");

        start = System.nanoTime();
        generateAndCalulatePostfix();
        end = System.nanoTime();
        System.out.println("Execution Time (generateAndCalculatePostfix Test 2): " + (end - start) / 1_000_000.0 + " milliseconds");

        // Test cases for largestNumber
        int[] nums1 = {4, 5, 1, 3};
        start = System.nanoTime();
        System.out.println("Largest Number (Test 1): " + largestNumber(nums1));
        end = System.nanoTime();
        System.out.println("Execution Time (largestNumber Test 1): " + (end - start) / 1_000_000.0 + " milliseconds");

        int[] nums2 = {9, 93, 24, 6};
        start = System.nanoTime();
        System.out.println("Largest Number (Test 2): " + largestNumber(nums2));
        end = System.nanoTime();
        System.out.println("Execution Time (largestNumber Test 2): " + (end - start) / 1_000_000.0 + " milliseconds");

        // Test cases for permutation
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1); list1.add(2); list1.add(3);
        start = System.nanoTime();
        System.out.println("Permutations (Test 1): " + permutation(list1));
        end = System.nanoTime();
        System.out.println("Execution Time (permutation Test 1): " + (end - start) / 1_000_000.0 + " milliseconds");

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4); list2.add(5);
        start = System.nanoTime();
        System.out.println("Permutations (Test 2): " + permutation(list2));
        end = System.nanoTime();
        System.out.println("Execution Time (permutation Test 2): " + (end - start) / 1_000_000.0 + " milliseconds");
    }
		
	/**
	  * This method generates and evaluates a random postfix expression using a stack-based approach.
	  * This means once the randomly generated expression is created, operands are pushed into 
	  * stack and operators cause operands to be popped out, maitaining recentness of order. 
	  * Precondition: No input is needed. 
	  * Postcondition: Outputs the total result of the generated and evaluated postfix expression.
	 */
	public static void generateAndCalulatePostfix() {
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
	                    char operator = "+-*/".charAt(r.nextInt(4));
	                    pw.print(operator + " ");
	                    operatorsCount++;
	                } else {
	                    int operand = r.nextInt(10) + 1;
	                    pw.print(operand + " ");
	                    operandsCount++;
	                }
	            }
	            pw.close();
	            //Reading the generated postfix expression 
	            Scanner scanner = new Scanner(file);
	            Stack<Integer> stack = new Stack<>();
	            while (scanner.hasNext()) {
	                String token = scanner.next();
	                if (token.matches("\\d+")) {
	                    stack.push(Integer.parseInt(token));
	                } else {
	                    int val1 = stack.pop();
	                    int val2 = stack.pop();
	                    //determining which artithmetic operation to execute 
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
		/*
		 * Modfications 
		 * There should be more controlled randomness which can be done so by 
		 * setting constants tos some of the parameters. This would vastly reduce the
		 * amount of conditional loops before proceeding to the reading of the file
		 * An interesting modifcation could be turning a regular expression into postfix
		 * notation which may involve reversing what is currently had with this code. 
		 */
	/**
	  * Generates the largest number possible by rearranging the numbers in an array. This works by having
	  * comparing the prior and current element to the current and prior as strings to lexicographically
	  * determine which is bigger. 
	  * Precondition: The input array should not be null and must contain non-negative integers.
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
	    /* using different sort algorithm. perhaps merge sort where a list is recursively divides
	     * into sublists such that the sublists are sorted and thus merged. This may be important
	     * when scaling with bigger arrays as bubble sort for some iterations does nothing. 
	     * maybe accepting an array of strings because if the integer component doesnt matter, then 
	     * this would prevent the convoluted casting. 
	     */
	    
	}
	
	/**
	 * Generates all possible permutations of a given list of integers. This works by constantly removing 
	 * the left-most element of the list by which the list is reconstructed by placing it in every 
	 * position possible. 
	 * Precondition: The input should not be null or be made up of only unique numbers and list will not remain in same state
	 * Postcondition: Returns a list of lists, representing all possible permutations. 
 	*/
	public static ArrayList<ArrayList<Integer>> permutation(ArrayList<Integer> list) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    //base case 
	    if (list.isEmpty()) {
	        result.add(new ArrayList<>());
	        return result;
	    }
	    
	    int firstElement = list.remove(0);
	    //establishes reference type to the return statement 
	    ArrayList<ArrayList<Integer>> permutations = permutation(list);
	    
	    //from each recursive call, permutations is built as the call unwinds 
	    for (ArrayList<Integer> sublist : permutations) {
	    	for (int i = 0; i <= sublist.size(); i++) {
	        	//shallow copy of reference but not same container "data structure" 
	        	ArrayList<Integer> temp = new ArrayList<>(sublist);
	            temp.add(i, firstElement);
	            result.add(temp);
	        }
	    }
	    //continues on with new call stack
	    return result;
	}
	/*Modifications
	 * make it so the passed in list remains in the same state by reinserting the removed element
	 * to the list before it is returned
	 * solving iteratively with a stack to emulate what the recursive call stack does 
	 * maybe doing with an array data structure where I would have to calculate the amount of 
	 * permutations to initalize the array. Then the algorithm should be similiar but when removing 
	 * an element, a subarray excluding the element would have to be made, which raises questions
	 * about lack of efficiency?
	 */
}
