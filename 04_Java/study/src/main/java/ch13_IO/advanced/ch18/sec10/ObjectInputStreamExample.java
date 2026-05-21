package main.java.ch13_IO.advanced.ch18.sec10;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ObjectInputStreamExample {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("C:/Temp/object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Member m2 = (Member) ois.readObject();
        Product p2 = (Product) ois.readObject();
        int[] arr2 = (int[]) ois.readObject();

        System.out.println("m2:\t" + m2.toString());
        System.out.println("p2:\t" + p2.toString());
        System.out.println("arr2:\t" + Arrays.toString(arr2));

        ois.close();
        fis.close();
    }
}
