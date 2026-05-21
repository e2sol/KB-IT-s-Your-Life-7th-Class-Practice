package main.java.ch13_IO.advanced.ch18.sec10;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor @Getter @Setter @ToString
public class Product implements Serializable {
    private String name;
    private int price;
}
