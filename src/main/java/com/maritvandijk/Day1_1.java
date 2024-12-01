package com.maritvandijk;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Day1_1 {
    public static void main(String[] args) throws IOException {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("day1.txt"))) {
            reader.lines().map(line -> line.split("   ")).forEach(ids -> {
                left.add(Integer.valueOf(ids[0]));
                right.add(Integer.valueOf(ids[1]));
            });
        }

        left.sort(Integer::compareTo);
        right.sort(Integer::compareTo);

        int total = IntStream.range(0, left.size()).map(i -> Math.abs(left.get(i) - right.get(i))).sum();
        System.out.println(total);
    }
}