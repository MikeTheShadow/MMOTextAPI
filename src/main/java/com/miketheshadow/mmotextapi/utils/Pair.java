package com.miketheshadow.mmotextapi.utils;

import org.jetbrains.annotations.NotNull;

public record Pair<T>(T key, Integer value) implements Comparable {

    public T getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        if(o instanceof Pair pair) {
            return pair.getValue().compareTo(getValue());
        }
        return 0;
    }
}
