package com.petersteiner.dedup;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.petersteiner.dedup.impl.IntSetFactoryImpl;
import com.petersteiner.dedup.impl.SystemOutPrintServiceImpl;

public class DeDup {
    public int[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1,
            10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1,
            2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20,
            7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11};

    private IntSetFactory intSetFactory;
    private PrintService printService;

    public DeDup(IntSetFactory intSetFactory, PrintService printService) {
        this.intSetFactory = intSetFactory;
        this.printService = printService;
    }

    public void printDeduplicatedIntArray(int[] intArray) {
        Set<Integer> set = new HashSet<>();
        IntSet intSet = intSetFactory.create(set, intArray);
        printService.print("deduplicated int []: ", intSet);
    }

    public void printDeduplicatedIntArrayWithInsertionOrder(int[] intArray) {
        Set<Integer> set = new LinkedHashSet<>();
        IntSet intSet = intSetFactory.create(set, intArray);
        printService.print("deduplicated int [], insertion order: ", intSet);
    }

    public void printDeduplicatedIntArrayWithSortedOrder(int[] intArray) {
        Set<Integer> set = new TreeSet<>();
        IntSet intSet = intSetFactory.create(set, intArray);
        printService.print("deduplicated int [], sorted order: ", intSet);
    }

    private void printRandomIntegersArray() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE);
        builder.append(randomIntegers);
        String value = builder.build();
        printService.print("int [] with duplicates: ", value);
    }

    public static void main(String[] args) {
        IntSetFactory factory = new IntSetFactoryImpl();
        PrintService printService = new SystemOutPrintServiceImpl();
        DeDup main = new DeDup(factory, printService);
        main.printRandomIntegersArray();
        main.printDeduplicatedIntArray(main.randomIntegers);
        main.printDeduplicatedIntArrayWithInsertionOrder(main.randomIntegers);
        main.printDeduplicatedIntArrayWithSortedOrder(main.randomIntegers);
    }
}
