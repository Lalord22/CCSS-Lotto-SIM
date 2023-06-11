
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

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

		
		
	public static void main(String[] args) {
		
		 int costo = 0;
		 int premio = 0;
		 int jackpot = 110300000;
		 
		 int n = 41; // Total number of values
	     int r = 5; // Number of values selected in each combination
	     
	     List<int[]> combinations = generateCombinations(n, r);
	     
	     for (int[] combination : combinations) {
	            for (int num : combination) {
	                System.out.print(num + " ");
	            }
	            System.out.println();
	        }
		

	}

}
