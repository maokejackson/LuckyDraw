package com.dtxmaker.luckydraw;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @Test
    public void testGenerateRandomNumberSeries() throws Exception {
        assertFalse(Arrays.equals(new int[]{1, 2, 3, 4, 5}, Utilities.generateRandomNumberSeries(1, 5)));
        assertFalse(Arrays.equals(new int[]{1, 2, 3, 4, 5}, Utilities.generateRandomNumberSeries(1, 5)));
        assertFalse(Arrays.equals(new int[]{1, 2, 3, 4, 5}, Utilities.generateRandomNumberSeries(1, 5)));
        assertFalse(Arrays.equals(new int[]{1, 2, 3, 4, 5}, Utilities.generateRandomNumberSeries(1, 5)));
        assertFalse(Arrays.equals(new int[]{1, 2, 3, 4, 5}, Utilities.generateRandomNumberSeries(1, 5)));

        assertFalse(Arrays.equals(new int[]{5, 4, 3, 2, 1}, Utilities.generateRandomNumberSeries(5, 1)));
        assertFalse(Arrays.equals(new int[]{5, 4, 3, 2, 1}, Utilities.generateRandomNumberSeries(5, 1)));
        assertFalse(Arrays.equals(new int[]{5, 4, 3, 2, 1}, Utilities.generateRandomNumberSeries(5, 1)));
        assertFalse(Arrays.equals(new int[]{5, 4, 3, 2, 1}, Utilities.generateRandomNumberSeries(5, 1)));
        assertFalse(Arrays.equals(new int[]{5, 4, 3, 2, 1}, Utilities.generateRandomNumberSeries(5, 1)));
    }

    @Test
    public void testGenerateNumberSeries() throws Exception {
        assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7}, Utilities.generateNumberSeries(2, 7));
        assertArrayEquals(new int[]{0, 1, 2, 3}, Utilities.generateNumberSeries(0, 3));
        assertArrayEquals(new int[]{10, 9, 8}, Utilities.generateNumberSeries(10, 8));
        assertArrayEquals(new int[]{99, 98, 97, 96, 95}, Utilities.generateNumberSeries(99, 95));
    }

    @Test
    public void testRandomSwap() throws Exception {
        assertFalse(Arrays.equals(new int[]{0, 1, 2, 3, 4}, Utilities.randomSwap(new int[]{0, 1, 2, 3, 4})));
        assertFalse(Arrays.equals(new int[]{0, 1, 2, 3, 4}, Utilities.randomSwap(new int[]{0, 1, 2, 3, 4})));
        assertFalse(Arrays.equals(new int[]{0, 1, 2, 3, 4}, Utilities.randomSwap(new int[]{0, 1, 2, 3, 4})));
        assertFalse(Arrays.equals(new int[]{0, 1, 2, 3, 4}, Utilities.randomSwap(new int[]{0, 1, 2, 3, 4})));
        assertFalse(Arrays.equals(new int[]{0, 1, 2, 3, 4}, Utilities.randomSwap(new int[]{0, 1, 2, 3, 4})));
    }

    @Test
    public void testRandomInt() throws Exception {
        assertTrue(Utilities.randomInt(2, 3) >= 2);
        assertTrue(Utilities.randomInt(2, 3) >= 2);
        assertTrue(Utilities.randomInt(2, 3) >= 2);
        assertTrue(Utilities.randomInt(2, 3) <= 3);
        assertTrue(Utilities.randomInt(2, 3) <= 3);
        assertTrue(Utilities.randomInt(2, 3) <= 3);

        assertTrue(Utilities.randomInt(5, 100) >= 5);
        assertTrue(Utilities.randomInt(5, 100) >= 5);
        assertTrue(Utilities.randomInt(5, 100) >= 5);
        assertTrue(Utilities.randomInt(5, 100) >= 5);
        assertTrue(Utilities.randomInt(5, 100) >= 5);
        assertTrue(Utilities.randomInt(5, 100) >= 5);
        assertTrue(Utilities.randomInt(5, 100) <= 100);
        assertTrue(Utilities.randomInt(5, 100) <= 100);
        assertTrue(Utilities.randomInt(5, 100) <= 100);
        assertTrue(Utilities.randomInt(5, 100) <= 100);
        assertTrue(Utilities.randomInt(5, 100) <= 100);
        assertTrue(Utilities.randomInt(5, 100) <= 100);

        assertTrue(Utilities.randomInt(3, 2) >= 2);
        assertTrue(Utilities.randomInt(3, 2) >= 2);
        assertTrue(Utilities.randomInt(3, 2) >= 2);
        assertTrue(Utilities.randomInt(3, 2) <= 3);
        assertTrue(Utilities.randomInt(3, 2) <= 3);
        assertTrue(Utilities.randomInt(3, 2) <= 3);
    }

    @Test
    public void testConvertToObject() throws Exception {
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, Utilities.convertToObject(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new Integer[]{7, 7, 7}, Utilities.convertToObject(new int[]{7, 7, 7}));
        assertArrayEquals(new Integer[]{-8, 0, 1}, Utilities.convertToObject(new int[]{-8, 0, 1}));
        assertArrayEquals(new Integer[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, Utilities.convertToObject(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}));
    }

    @Test
    public void testConvertToPrimitive() throws Exception {
        assertArrayEquals(new int[]{0, 4, 5}, Utilities.convertToPrimitive(new Integer[]{null, 4, 5}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Utilities.convertToPrimitive(new Integer[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{7, 7, 7}, Utilities.convertToPrimitive(new Integer[]{7, 7, 7}));
        assertArrayEquals(new int[]{-8, 0, 1}, Utilities.convertToPrimitive(new Integer[]{-8, 0, 1}));
        assertArrayEquals(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, Utilities.convertToPrimitive(new Integer[]{Integer.MAX_VALUE, Integer.MIN_VALUE}));
    }

    @Test
    public void testRemoveElement() throws Exception {
        assertArrayEquals(new int[]{0, 2}, Utilities.removeElement(new int[]{0, 1, 2}, 1));
        assertArrayEquals(new int[]{13, 20, 2}, Utilities.removeElement(new int[]{13, 20, 2}, 11));
        assertArrayEquals(new int[]{13, 20}, Utilities.removeElement(new int[]{13, 20, 11}, 11));
        assertArrayEquals(new int[]{13, 20}, Utilities.removeElement(new int[]{13, 11, 20}, 11));
        assertArrayEquals(new int[]{13, 20}, Utilities.removeElement(new int[]{11, 13, 20}, 11));
    }
}
