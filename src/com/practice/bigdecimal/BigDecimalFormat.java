package com.practice.bigdecimal;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.*;

public class BigDecimalFormat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        List<CustomDecimal> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String string = scanner.nextLine();
            BigDecimal bigDecimal = new BigDecimal(string);
            numbers.add(new CustomDecimal(bigDecimal, string));
        }
//        List<CustomDecimal> sorted = numbers.stream().sorted().toList();
        ValueCompare valueCompare = new ValueCompare();
        Collections.sort(numbers, valueCompare);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i).getStrRep());
        }

    }

    static class ValueCompare implements Comparator<CustomDecimal> {

        public int compare(CustomDecimal m1, CustomDecimal m2) {
                return m2.getBigDecimal().compareTo(m1.getBigDecimal());
        }
    }

    private static class CustomDecimal implements Comparable<CustomDecimal> {
        private BigDecimal bigDecimal;
        private String strRep;

        public CustomDecimal(BigDecimal bigDecimal, String strRep) {
            this.bigDecimal = bigDecimal;
            this.strRep = strRep;
        }

        @Override
        public int compareTo(@NotNull CustomDecimal customDecimal2) {
            return this.bigDecimal.compareTo(customDecimal2.bigDecimal);
        }

        public String getStrRep() {
            return strRep;
        }

        public BigDecimal getBigDecimal() {
            return bigDecimal;
        }
    }
}
