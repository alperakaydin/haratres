package org.haratres;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeStringTest {

    private final MergeString mergeString = new MergeString();

    @Test
    public void testMergeSameLengthString() {
        assertEquals("HaRaTrEs", mergeString.merge("HRTE", "aars"));
    }

    @Test
    public void testMergeDifferentLengthString() {
        assertEquals("aBcDeFGH", mergeString.merge("ace", "BDFGH"));
    }

    @Test
    public void testMergeWithLongerString() {
        assertThrows(IllegalArgumentException.class, () -> mergeString.merge("a".repeat(2501), "b".repeat(2501)));
    }
}