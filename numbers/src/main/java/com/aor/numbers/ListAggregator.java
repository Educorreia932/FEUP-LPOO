package com.aor.numbers;

import java.util.List;

/**
 * A utility class that aggregates list of numbers
 * into a single integer using various functions.
 */
public class ListAggregator {
    private final List<Integer> list;

    public ListAggregator(List<Integer> list) {
        this.list = list;
    }

    /**
     * Sums all numbers in a list.
     * @return The sum of all the values in the list.
     */
    public Integer sum() {
        int sum = 0;

        for (Integer number : list)
            sum += number;

        return sum;
    }

    /**
     * Calculates the maximum value in a list.
     * @return The maximum value in the list.
     */
    public Integer max() {
        int max = 0;

        for (Integer number : list)
            if (number > max)
                max = number;

        return max;
    }

    /**
     * Calculates the minimum value in a list.
     * @return The minimum value in the list.
     */
    public Integer min() {
        int min = Integer.MAX_VALUE;

        for (Integer number : list)
            if (number < min)
                min = number;

        return min;
    }

    /**
     * Counts the number of distinct numbers in a list.
     * @return The number of distinct numbers.
     */
    public int distinct() {
        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate();

        return distinct.size();
    }
}