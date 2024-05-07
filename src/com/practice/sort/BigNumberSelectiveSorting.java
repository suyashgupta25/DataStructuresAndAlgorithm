package com.practice.sort;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BigNumberSelectiveSorting {

    public static void main(String[] args) throws IOException {
        File file = new File("file_inputs/big_number_sorting2.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = bigSorting(unsorted);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    static int CHARACTER_THRESHOLD = 2000;

    public static List<String> bigSorting(List<String> unsorted) {
        List<String> insaneNumbers = unsorted
                .stream()
                .filter(n -> n.length() > CHARACTER_THRESHOLD)
                .collect(toList());
        Comparator<String> comp = Comparator.comparingInt(String::length);
        insaneNumbers.sort(comp);

        List<String> sort = unsorted
                .stream()
                .filter(n -> n.length() <= CHARACTER_THRESHOLD)
                .map(BigInteger::new)
                .sorted()
                .map(BigInteger::toString)
                .collect(toList());

        List<String> merge = new ArrayList<>();
        merge.addAll(sort);
        merge.addAll(insaneNumbers);
        return merge;
    }
}
