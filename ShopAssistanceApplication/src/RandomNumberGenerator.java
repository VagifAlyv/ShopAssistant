import java.util.Random;

public class RandomNumberGenerator {
    private Random random = new Random();

    // Generate a random integer between m(inclusive) and n(exclusive)
    public int chooseRandomIntBetweenMandN(int m, int n) {
        return random.nextInt(m, n);
    }

    // Generate an array of N unique random integers between m(inclusive) and n(exclusive)
    public int[] chooseRandomNIntegers(int m, int n, int N) {
        int[] randomIntegers = new int[N];
        int randomIntegersIndex = 0;
        
        while (randomIntegersIndex < N) {
            int randomNumber = chooseRandomIntBetweenMandN(m, n);
            
            if (isUnique(randomIntegers, randomIntegersIndex, randomNumber)) {
                randomIntegers[randomIntegersIndex] = randomNumber;
                randomIntegersIndex++;
            }
        }

        return randomIntegers;
    }

    //Checks whether the integer is unique in the array.
    private boolean isUnique(int[] array, int endIndex, int value) {
        for (int i = 0; i < endIndex; i++) {
            if (array[i] == value) {
                return false;
            }
        }
        return true;
    }
}
