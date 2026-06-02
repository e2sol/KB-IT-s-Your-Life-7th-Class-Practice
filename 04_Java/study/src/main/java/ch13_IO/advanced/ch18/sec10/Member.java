package main.java.ch13_IO.advanced.ch18.sec10;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor @Getter @Setter @ToString
public class Member implements Serializable {
    private String id;
    private String name;
}
