package com.maritvandijk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        HashMap<Integer, Long> frequency =
                right.stream().collect(Collectors.groupingBy(
                        Function.identity(), HashMap::new,
                        Collectors.counting()
                ));


        int similarityScore = 0;
        for (Integer integer : left) {
            if (frequency.containsKey(integer)) {
                int similarity = (int) (integer * frequency.get(integer));
                similarityScore += similarity;
            }
        }

        System.out.println(similarityScore);
    }
}
