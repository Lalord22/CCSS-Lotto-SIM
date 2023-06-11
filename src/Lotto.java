
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
	
	
		
		
		
int generateNumber() {   //Generates random number between 00 and 40
	
	Random random = new Random();
	int randomNumber = random.nextInt(41);
	return randomNumber;
	
}

private static List<int[]> generateCombinations(int n, int r) {   //Generates all 749,398 posible combinations
    List<int[]> combinations = new ArrayList<>();
    generateCombinationsHelper(n, r, 0, new int[r], combinations);
    return combinations;
}

private static void generateCombinationsHelper(int n, int r, int index, int[] combination, List<int[]> combinations) {
    if (index == r) {
        combinations.add(combination.clone());
        return;
    }
    
    for (int i = 0; i < n; i++) {
        if (!contains(combination, index, i)) {
            combination[index] = i;
            generateCombinationsHelper(n, r, index + 1, combination, combinations);
        }
    }
}

private static boolean contains(int[] arr, int length, int value) {
    for (int i = 0; i < length; i++) {
        if (arr[i] == value) {
            return true;
        }
    }
    return false;
}

private static int[] generateRandomArray(int n, int r) {  //generates 1 random array 
    int[] randomArray = new int[r];
    Random random = new Random();
    
    for (int i = 0; i < r; i++) {
        randomArray[i] = random.nextInt(n);
    }
    
    return randomArray;
}

private static int[] generateRandomArray(int n, int r, Set<String> generatedArrays) {
    int[] randomArray = new int[r];
    Random random = new Random();
    
    for (int i = 0; i < r; i++) {
        randomArray[i] = random.nextInt(n);
    }
    
    // Convert the array to a string for tracking uniqueness
    String arrayString = arrayToString(randomArray);
    
    // Check if the array has been generated before
    while (generatedArrays.contains(arrayString)) {
        for (int i = 0; i < r; i++) {
            randomArray[i] = random.nextInt(n);
        }
        arrayString = arrayToString(randomArray);
    }
    
    return randomArray;
}

private static String arrayToString(int[] array) {
    StringBuilder sb = new StringBuilder();
    for (int num : array) {
        sb.append(num).append(" ");
    }
    return sb.toString();
}

private static void generateRandomArrays(int totalArraysToGenerate ) {
	
	
	
	int n = 41; // Total number of values
    int r = 5; // Number of values to be generated
     
    
    Set<String> generatedArrays = new HashSet<>();
    
    for (int i = 0; i < totalArraysToGenerate; i++) {
        int[] randomArray = generateRandomArray(n, r, generatedArrays);
        
        // Convert the array to a string for tracking uniqueness
        String arrayString = arrayToString(randomArray);
        
        // Check if the array has been generated before
        if (generatedArrays.contains(arrayString)) {
            System.out.println("Duplicate array generated. Regenerating...");
            i--; // Decrement i to regenerate a new array in the next iteration
        } else {
            generatedArrays.add(arrayString);
            
            // Print the generated array
            for (int num : randomArray) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

		
		
	public static void main(String[] args) {
		
		 int costo = 0;
		 int premio = 0;
		 int jackpot = 110300000;
		 
		 int totalArraysToGenerate = 10;
		 
		
		 
		 int n = 41; // Total number of values
	     int r = 5; // Number of values selected in each combination
	     
	     
	     generateRandomArrays(totalArraysToGenerate);
	     
	    /* List<int[]> combinations = generateCombinations(n, r);
	     
	     for (int[] combination : combinations) {
	            for (int num : combination) {
	                System.out.print(num + " ");
	            }
	            System.out.println();
	        }
		*/
	     
	     

	}

}
