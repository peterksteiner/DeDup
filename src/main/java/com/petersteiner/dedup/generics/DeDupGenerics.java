package com.petersteiner.dedup.generics;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.petersteiner.dedup.PrintService;
import com.petersteiner.dedup.impl.SystemOutPrintServiceImpl;

/**
 * This code <b>prototype</b> is for the question, "Can you implement it another way so as to avoid
 * the negatives?". See README.md
 * Demonstrates the simplifications possible when the Array to be deduplicated is an Object[]
 * instead of an array of primitives. Can easily deduplicate Object[] of any type.
 * Code could be added to have insertion order respected (LinkedHashSet) or sort order (TreeSet).
 */
public class DeDupGenerics<T> {
    public Integer[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1,
            10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1,
            2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20,
            7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11};
    public Long[] randomLongs = {1L, 2L, 34L, 34L, 25L, 1L, 45L, 3L, 26L, 85L, 4L, 34L, 86L, 25L,
            43L, 2L, 1L, 10000L, 11L, 16L, 19L, 1L, 18L, 4L, 9L, 3L, 20L, 17L, 8L, 15L, 6L, 2L, 5L,
            10L, 14L, 12L, 13L, 7L, 8L, 9L, 1L, 2L, 15L, 12L, 18L, 10L, 14L, 20L, 17L, 16L, 3L, 6L,
            19L, 13L, 5L, 11L, 4L, 7L, 19L, 16L, 5L, 9L, 12L, 3L, 20L, 7L, 15L, 17L, 10L, 6L, 1L,
            8L, 18L, 4L, 14L, 13L, 2L, 11L};
    public String[] randomStrings = {"1", "2", "34", "34", "25", "1", "45", "3", "26", "85", "4",
            "34", "86", "25", "43", "2", "1", "10000", "11", "16", "19", "1", "18", "4", "9", "3",
            "20", "17", "8", "15", "6", "2", "5", "10", "14", "12", "13", "7", "8", "9", "1", "2",
            "15", "12", "18", "10", "14", "20", "17", "16", "3", "6", "19", "13", "5", "11", "4",
            "7", "19", "16", "5", "9", "12", "3", "20", "7", "15", "17", "10", "6", "1", "8", "18",
            "4", "14", "13", "2", "11"};
    private PrintService printService;

    public DeDupGenerics(PrintService printService) {
        this.printService = printService;
    }

    public void printDeduplicatedArray(T[] array) {
        Set<T> set = new HashSet<>();
        Collections.addAll(set, array);
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE);
        builder.append(set);
        String value = builder.toString();
        printService.print("deduplicated []: ", value);
    }

    public static void main(String[] args) {
        PrintService printService = new SystemOutPrintServiceImpl();
        DeDupGenerics<Object> deDupGenerics = new DeDupGenerics<>(printService);
        deDupGenerics.printDeduplicatedArray(deDupGenerics.randomIntegers);
        deDupGenerics.printDeduplicatedArray(deDupGenerics.randomLongs);
        deDupGenerics.printDeduplicatedArray(deDupGenerics.randomStrings);
    }
}
