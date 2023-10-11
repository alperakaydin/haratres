package org.haratres;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CloseNumberTest {
    private final CloseNumber closeNumber = new CloseNumber(); // NEden final kullanılıyor bak

    @Test
    public void testFindCloseNumber1() {
        int[] arr = {3, 1, 5, 23, 2, 4, 9, 10, 15, 31};
        String[] expectedResult = {"1 2", "2 3", "3 4", "4 5", "9 10"};
        List<String> result = closeNumber.findCloseNumber(arr);
        assertArrayEquals(expectedResult, result.toArray());

    }

    @Test
    public void testFindCloseNumber2() {
        int[] arr = {32, 41, 12, 15, 21, 32, 48, 35};
        String[] expectedResult = {"12 15", "32 35"};
        List<String> result = closeNumber.findCloseNumber(arr);
        assertArrayEquals(expectedResult, result.toArray());

    }

    @Test
    public void testFindCloseNumberWithInvalidArrayLength() {
        int[] arr = {32};
        assertThrows(IllegalArgumentException.class, () -> closeNumber.findCloseNumber(arr));
    }

    @Test
    public void testFindCloseNumberWithInvalidArrayElement() {
        int[] arr = {20222, -20222};
        assertThrows(IllegalArgumentException.class, () -> closeNumber.findCloseNumber(arr));
    }
}