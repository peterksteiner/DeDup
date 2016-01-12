package com.petersteiner.dedup.impl;

import com.petersteiner.dedup.PrintService;

public class SystemOutPrintServiceImpl implements PrintService {
    @Override
    public void print(String label, String value) {
        System.out.print(label);
        System.out.println(value);
    }

    @Override
    public void print(String label, Object value) {
        print(label, value.toString());
    }
}
