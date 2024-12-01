package com.maritvandijk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1_2 {
    public static void main(String[] args) throws IOException {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("day1.txt"))) {
            reader.lines().map(line -> line.split("   ")).forEach(ids -> {
                left.add(Integer.valueOf(ids[0]));
                right.add(Integer.valueOf(ids[1]));
            });
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int value : right) {
            if (frequency.containsKey(value)) {
                frequency.compute(value, (key, count) -> count + 1);
            } else {
                frequency.put(value, 1);
            }
        }

        int similarityScore = 0;
        for (Integer integer : left) {
            if (frequency.containsKey(integer)) {
                int similarity = integer * frequency.get(integer);
                similarityScore += similarity;
            }
        }

        System.out.println(similarityScore);
    }
}
