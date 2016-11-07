package com.dtxmaker.luckydraw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Maoke Jackson on 18/2/2015.
 */
public final class Utilities {
    private static final Random rand = new Random();

    private Utilities() {
        throw new Error(getClass() + " contains static methods only");
    }

    /**
     * Generate a random number series that are between <code>min</code> and <code>max</code>.
     *
     * @param min the minimum number of the series (inclusive)
     * @param max the maximum number of the series (inclusive)
     * @return a number series that are between <code>min</code> and <code>max</code>.
     */
    public static int[] generateRandomNumberSeries(int min, int max) {
        return randomSwap(generateNumberSeries(min, max));
    }

    /**
     * Generate a sequence number series that are between <code>first</code> and <code>last</code>.
     *
     * @param first the first number of the series (inclusive)
     * @param last  the last number of the series (inclusive)
     * @return a sequence number series that are between <code>first</code> and <code>last</code>.
     */
    public static int[] generateNumberSeries(int first, int last) {
        return generateNumberSeries(first, last, 1);
    }

    /**
     * Generate a sequence number series that are between <code>first</code> and <code>last</code>.
     *
     * @param first the first number of the series (inclusive)
     * @param last  the last number of the series (inclusive)
     * @param jump  the increment/decrement of next number in the series. Increment/Decrement is auto determined by checking <code>first</code> > <code>last</code> or <code>last</code> > <code>first</code>
     * @return a sequence number series that are between <code>first</code> and <code>last</code>.
     */
    public static int[] generateNumberSeries(int first, int last, int jump) {
        boolean forward = last > first;
        int diff = Math.abs(jump);
        int increment = forward ? diff : -diff;
        int size = Math.abs(last - first) / diff + 1;
        int[] array = new int[size];

        for (int index = 0, num = first; index < size; index++, num += increment) {
            array[index] = num;
        }

        return array;
    }

    /**
     * Randomly swap the elements in an array.
     *
     * @param array the array to be randomized
     * @return a randomized swapped array.
     */
    public static int[] randomSwap(int[] array) {
        int size = array.length;
        int[] out = Arrays.copyOf(array, size);

        for (int i = 0; i < size; i++) {
            int index = randomInt(0, size - 1);
            int old = out[i];
            out[i] = out[index];
            out[index] = old;
        }

        if (size > 4 && Arrays.equals(array, out)) {
            return randomSwap(array);
        }

        return out;
    }

    /**
     * Generate a random integer.
     *
     * @param min the minimum possible value
     * @param max the maximum possible value
     * @return a random integer.
     */
    public static int randomInt(int min, int max) {
        int small = min;
        int big = max;

        if (min > max) {
            small = max;
            big = min;
        }

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return rand.nextInt((big - small) + 1) + small;
    }

    /**
     * Convert an <code>int</code> array to <code>Integer</code> array.
     *
     * @param array the array to be converted
     * @return an <code>Integer</code> array
     */
    public static Integer[] convertToObject(int[] array) {
        Integer[] out = new Integer[array.length];
        int index = 0;
        for (int element : array) {
            out[index++] = element;
        }
        return out;
    }

    /**
     * Convert an <code>Integer</code> array to <code>int</code> array.
     *
     * @param array the array to be converted
     * @return an <code>int</code> array
     */
    public static int[] convertToPrimitive(Integer[] array) {
        int[] out = new int[array.length];
        int index = 0;
        for (Integer element : array) {
            if (element == null) {
                out[index++] = 0;
            } else {
                out[index++] = element;
            }
        }
        return out;
    }

    /**
     * Remove an element from an array.
     *
     * @param array   an array
     * @param element item to be removed
     * @return an array with <code>element</code> removed.
     */
    public static int[] removeElement(int[] array, int element) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(convertToObject(array)));
        list.removeAll(Arrays.asList(element));
        Integer[] buffer = new Integer[list.size()];
        buffer = list.toArray(buffer);
        return convertToPrimitive(buffer);
    }
}
