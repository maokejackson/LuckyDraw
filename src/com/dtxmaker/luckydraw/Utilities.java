package com.dtxmaker.luckydraw;

import javax.lang.model.element.Element;
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

    public static int[] generateRandomNumberSeries(int min, int max) {
        return randomSwap(generateNumberSeries(min, max));
    }

    public static int[] generateNumberSeries(int first, int last) {
        boolean forward = last > first;
        int increment = forward ? 1 : -1;
        int size = Math.abs(last - first) + 1;
        int[] array = new int[size];

        for (int index = 0, num = first; index < size; index++, num += increment) {
            array[index] = num;
        }

        return array;
    }

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

    public static Integer[] convertToObject(int[] array) {
        Integer[] out = new Integer[array.length];
        int index = 0;
        for (int element : array) {
            out[index++] = element;
        }
        return out;
    }

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

    public static int[] removeElement(int[] array, int element) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(convertToObject(array)));
        list.removeAll(Arrays.asList(element));
        Integer[] buffer = new Integer[list.size()];
        buffer = list.toArray(buffer);
        return convertToPrimitive(buffer);
    }
}
