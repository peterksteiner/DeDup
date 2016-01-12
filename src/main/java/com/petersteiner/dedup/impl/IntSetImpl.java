package com.petersteiner.dedup.impl;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.petersteiner.dedup.IntSet;

public class IntSetImpl implements IntSet {
    Set<Integer> set;

    IntSetImpl(Set<Integer> integers) {
        this.set = integers;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE);
        int[] ints = this.toIntArray();
        builder.append(ints);
        String value = builder.build();
        return value;
    }

    @Override
    public int[] toIntArray() {
        int[] ints = set.stream().mapToInt(i -> i).toArray();
        return ints;
    }
}
