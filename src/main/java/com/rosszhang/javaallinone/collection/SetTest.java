package com.rosszhang.javaallinone.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetTest {


    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(1511);
        set.add(1412);
        set.add(1315);
        set.add(1125);
//        List<Object> collect = set.stream().sorted().collect(Collectors.toList());
        set.forEach(System.out::println);
        System.out.println("-------");
        Set<Object> collect1 = set.stream().collect(Collectors.toSet());
        LinkedHashSet<Object> collect2 = set.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Object> collect3 = set.stream().sorted().collect(Collectors.toCollection(TreeSet::new));

        collect1.forEach(System.out::println);
        System.out.println("-------");
        collect2.forEach(System.out::println);
        System.out.println("-------");
        collect3.forEach(System.out::println);
        System.out.println("-------");
    }
}
