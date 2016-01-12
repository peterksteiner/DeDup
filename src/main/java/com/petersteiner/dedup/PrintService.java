package com.petersteiner.dedup;

public interface PrintService {
    void print(String label, String value);

    void print(String label, Object value);
}
