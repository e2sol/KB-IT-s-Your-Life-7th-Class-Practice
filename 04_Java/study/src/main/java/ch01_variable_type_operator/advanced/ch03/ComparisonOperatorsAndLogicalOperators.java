package main.java.ch01_variable_type_operator.advanced.ch03;

public class ComparisonOperatorsAndLogicalOperators {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;
        System.out.println((x > 7) && (y <= 5)); // true && true => true
        System.out.println((x % 3 == 2) || (y % 2 != 1)); // false || false => false
    }
}
