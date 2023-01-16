import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort currentInstance = new BubbleSort();

        // Using bubble sorting for with small numbers
        int[] smallNumbers = {1,3,6,7,5,9,2,4,8,11};
        int[] sortedSmallNumbers = currentInstance.bubbleSorting(smallNumbers);
        System.out.println(Arrays.toString(sortedSmallNumbers));

        // Using bubble sorting for with big numbers
        int[] bigNumbers = new int[100];
		Random random = new Random();
		for (int indexBigNumbers= 0 ; indexBigNumbers < bigNumbers.length; indexBigNumbers++) {
			bigNumbers[indexBigNumbers] = random.nextInt();
		}
        int[] sortedBigNumbers = currentInstance.bubbleSorting(bigNumbers);
        System.out.println(Arrays.toString(sortedBigNumbers));
    }

    public int[] bubbleSorting(int[] numbers) {
        for (int indexSort = 1; indexSort < numbers.length; indexSort++) {
            for (int indexNumbers = 0; indexNumbers < numbers.length - indexSort; indexNumbers++) {
                if (numbers[indexNumbers] > numbers[indexNumbers + 1]) {
                    int tempNumber = numbers[indexNumbers];
                    numbers[indexNumbers] = numbers[indexNumbers + 1];
                    numbers[indexNumbers + 1] = tempNumber;
                }
            }
        }
        return numbers;
    }
}