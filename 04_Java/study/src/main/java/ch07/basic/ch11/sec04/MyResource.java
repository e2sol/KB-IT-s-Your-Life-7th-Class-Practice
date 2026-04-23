package main.java.ch07.basic.ch11.sec04;

public class MyResource implements AutoCloseable{
    private String name;

    public MyResource(String name) {
        this.name = name;
        System.out.printf("[MyResource(%s) 열기]\n", name);
    }

    public String read1() {
        System.out.printf("[MyResource(%s) 열기]\n", name);
        return "100";
    }

    public String read2() {
        System.out.printf("[MyResource(%s) 열기]\n", name);
        return "abc";
    }

    @Override
    public void close() throws Exception {
        System.out.printf("[MyResource(%s) 닫기]\n", name);
    }
}
