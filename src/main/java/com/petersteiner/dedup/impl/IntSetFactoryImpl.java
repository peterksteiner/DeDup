package com.petersteiner.dedup.impl;

import java.util.Set;

import com.petersteiner.dedup.IntSet;
import com.petersteiner.dedup.IntSetFactory;

public class IntSetFactoryImpl implements IntSetFactory {
    @Override
    public IntSet create(Set<Integer> set, int[] intArray) {
        for (Integer integer : intArray) {
            set.add(integer);
        }
        IntSet intSet = new IntSetImpl(set);
        return intSet;
    }
}
