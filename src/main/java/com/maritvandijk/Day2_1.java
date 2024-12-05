package com.maritvandijk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day2_1 {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("day2.txt"));
        List<String> lines = reader.lines().toList();
        List<List<Integer>> reports = new ArrayList<>();

        for (String line : lines) {
            String[] split = line.split(" ");
            List<Integer> list = Arrays.stream(split).map(Integer::valueOf).toList();
            reports.add(list);
        }

        int total = 0;
        for (List<Integer> report : reports) {
            boolean safe = true;
            boolean ascending = true;

            for (int i = 0; i < report.size() - 1; i++) {
                int index = report.get(i);
                int next = report.get(i + 1);

                if (i == 0 && index > next) {
                    ascending = false;
                }

                if (ascending && index > next ||
                        !ascending && index < next ||
                        (Math.abs(index - next) > 3 ||
                        Objects.equals(index, next))) {
                    safe = false;
                }
            }

            if (safe) {
                total++;
            }
        }

        System.out.println(total);
    }
}
