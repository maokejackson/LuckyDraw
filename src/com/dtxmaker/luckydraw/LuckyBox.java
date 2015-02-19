package com.dtxmaker.luckydraw;

/**
 * Created by Maoke Jackson on 19/2/2015.
 */
public class LuckyBox {
    private int[] numbers;

    public LuckyBox(int min, int max) {
        numbers = Utilities.generateNumberSeries(min, max);
    }

    public Integer randomNumber() {
        if (isEmpty()) {
            return null;
        }
        int index = Utilities.randomInt(0, getSize() - 1);
        return numbers[index];
    }

    public boolean isEmpty() {
        return numbers.length == 0;
    }

    public int getSize() {
        return numbers.length;
    }

    public void removeNumber(int number) {
        numbers = Utilities.removeElement(numbers, number);
    }
}
