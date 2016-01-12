package com.petersteiner.dedup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.petersteiner.dedup.impl.IntSetFactoryImpl;

public class IntSetTest {
    private final int[] testIntArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
            18, 19, 20, 25, 26, 34, 43, 45, 85, 86, 10000};

    private IntSetFactory factory = new IntSetFactoryImpl();

    @Test
    public void deduplicatedIntArray() {
        int[] randomIntegers = buildRandomIntArray(testIntArray);
        Set<Integer> set = new HashSet<>();
        IntSet intSet = factory.create(set, randomIntegers);
        int[] deduplicatedIntArray = intSet.toIntArray();
        assertNoDuplicates(testIntArray, deduplicatedIntArray);
    }

    @Test
    public void toStringMethod() {
        int[] randomIntegers = buildRandomIntArray(testIntArray);
        Set<Integer> set = new HashSet<>();
        IntSet intSet = factory.create(set, randomIntegers);
        String value = intSet.toString();
        for (int i : testIntArray) {
            String intAsString = String.valueOf(i);
            assertThat(value.contains(intAsString), is(true));
        }
    }

    protected void assertNoDuplicates(int[] originalArray, int[] deduplicatedArray) {
        assertThat(deduplicatedArray.length, is(equalTo(originalArray.length)));
        ArrayList<Integer> deduplicatedIntArrayAsList = new ArrayList<>();
        for (Integer value : deduplicatedArray) {
            deduplicatedIntArrayAsList.add(value);
        }
        for (Integer value : originalArray) {
            boolean wasFound = deduplicatedIntArrayAsList.remove(value);
            assertThat(wasFound, is(true));
        }
        assertThat(deduplicatedIntArrayAsList.isEmpty(), is(true));
    }

    /**
     * Given an int [], duplicate each value up to 5 times to build a new int [], then shuffle
     * the array
     * @return int [] with random number of duplicate values
     */
    protected int[] buildRandomIntArray(final int [] ints) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Random random = new Random();
        for (int value : ints) {
            int duplicates = random.nextInt(4) + 1;
            for (int duplicate = 0; duplicate < duplicates; duplicate++) {
                integerArrayList.add(value);
            }
        }
        Collections.shuffle(integerArrayList);
        int[] randomIntegers = integerArrayList.stream().mapToInt(i -> i).toArray();
        return randomIntegers;
    }
}
