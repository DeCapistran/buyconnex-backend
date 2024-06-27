package com.buyconnex.buyconnex.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListUtils {

    public static <T> List<T> distinct(List<T> liste) {
        return liste.stream().distinct().collect(Collectors.toList());
    }

    public static <T> List<T> toList(Set<T> set) {
        if (set == null)
            return new ArrayList<>();
        return set.stream().collect(Collectors.toList());
    }

    public static <T> Set<T> toSet(List<T> list) {
        if (list == null)
            return new HashSet<>();
        return list.stream().collect(Collectors.toSet());
    }

    public static <T> List<T> orderCollection(Collection<T> collection) {
        if (collection == null) {
            return new ArrayList<>();
        } else {
            return collection.stream().sorted().collect(Collectors.toList());
        }
    }
}
