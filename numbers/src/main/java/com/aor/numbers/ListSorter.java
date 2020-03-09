package com.aor.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An utility class to sort list of numbers.
 */
public class ListSorter {
    private final List<Integer> list;

    public ListSorter(List<Integer> list) {
        this.list = list;
    }

    /**
     * Really stupid way to sort a list.
     * @return A sorted version of the list.
     */
    public List<Integer> sort() {
        List<Integer> sorted = new ArrayList();
        for (Integer number : list)
            sorted.add(number);

        for (int i = 0; i < sorted.size() - 1; i++)
            for (int j = i + 1; j < sorted.size() - 1; j++)
                if (sorted.get(i) > sorted.get(j))
                    Collections.swap(sorted, i, j);

        return sorted;
    }
}
