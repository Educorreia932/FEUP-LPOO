package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
    private List<Integer> list;
    private ListAggregator aggregator;

    @Before
    public void init() {
        list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        aggregator = new ListAggregator(list);
    }

    @Test
    public void sum() {
        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void min() {
        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        int distinct = aggregator.distinct();

        assertEquals(4, distinct);
    }
}