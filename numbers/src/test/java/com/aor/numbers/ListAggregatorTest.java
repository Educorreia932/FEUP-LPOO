package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
        int distinct = aggregator.distinct(new ListDeduplicator(list));

        assertEquals(4, distinct);
    }

    @Test
    public void bug_1() {
        list = new ArrayList<>();

        list.add(-1);
        list.add(-4);
        list.add(-5);

        aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(-1, max);
    }

    @Test
    public void bug_2() {
//        list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(4);
//        list.add(2);
//
//        aggregator = new ListAggregator(list);

        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);

        List<Integer> deduplicated = new ArrayList<>();

        deduplicated.add(1);
        deduplicated.add(2);
        deduplicated.add(4);

        Mockito.when(deduplicator.deduplicate()).thenReturn(deduplicated);

        int distinct = aggregator.distinct(deduplicator);

        assertEquals(3, distinct);
    }
}