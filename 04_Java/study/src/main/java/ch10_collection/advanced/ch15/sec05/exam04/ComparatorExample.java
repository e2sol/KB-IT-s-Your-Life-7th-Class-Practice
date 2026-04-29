package main.java.ch10_collection.advanced.ch15.sec05.exam04;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ComparatorExample {
    public static void main(String[] args) {
        TreeSet<Fruit> treeSet = new TreeSet<>(new FruitComparator());

        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));

        for (Fruit f : treeSet) {
            System.out.println(f.name + ", " + f.price);
        }

        System.out.println("-----------------------------");

        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit("포도", 3000));
        list.add(new Fruit("수박", 10000));
        list.add(new Fruit("딸기", 6000));

        list.sort(new FruitComparator());

        for (Fruit f : list){
            System.out.println(f.name + ", " + f.price);
        }
    }
}
