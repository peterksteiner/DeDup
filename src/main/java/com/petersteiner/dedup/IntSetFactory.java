package com.petersteiner.dedup;

import java.util.Set;

public interface IntSetFactory {
    IntSet create(Set<Integer> set, int[] ints);
}
