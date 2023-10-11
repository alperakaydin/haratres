package org.haratres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloseNumber {

    public List<String> findCloseNumber(int[] numberArray) {
        validateArray(numberArray);

        List<String> closeNumbers = new ArrayList<>();

        int[] copyArray = Arrays.copyOf(numberArray, numberArray.length);
        int copyArrayLen = copyArray.length;
        int minDistance = Integer.MAX_VALUE;

        Arrays.sort(copyArray);

        for (int i = 1; i < copyArrayLen; i++) {
            int diff = copyArray[i] - copyArray[i - 1];
            minDistance = (minDistance > diff && diff > 0) ? diff : minDistance;
        }

        for (int i = 1; i < copyArrayLen; i++) {
            if (minDistance == copyArray[i] - copyArray[i - 1]) {
                closeNumbers.add(copyArray[i - 1] + " " + copyArray[i]);
            }
        }

        return closeNumbers;
    }

    private void validateArray(int[] arr) {
        if (arr.length < 2 | arr.length > 1000) {
            throw new IllegalArgumentException("Array length must between 2 and 1000 ");
        }
        for (int number :
                arr) {
            if (number > 20000 | number < -20000) {
                throw new IllegalArgumentException("Array members must between -20000 and 20000 ");
            }
        }
    }
}
