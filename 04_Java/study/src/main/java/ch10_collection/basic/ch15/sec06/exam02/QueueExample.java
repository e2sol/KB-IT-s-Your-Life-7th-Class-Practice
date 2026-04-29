package main.java.ch10_collection.basic.ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> queue = new LinkedList<>();

        queue.add(new Message("sendMail", "홍길동"));
        queue.add(new Message("sendSMS", "신용권"));
        queue.add(new Message("sendKakaotalk", "김자바"));

        while (!queue.isEmpty()) {
            String command = queue.peek().command;
            String to = queue.remove().to;
            switch (command) {
                case "sendMail" :
                    System.out.printf("%s님에게 메일을 보냅니다.\n", to);
                    break;
                case "sendSMS" :
                    System.out.printf("%s님에게 SMS를 보냅니다.\n", to);
                    break;
                case "sendKakaotalk":
                    System.out.printf("%s님에게 카카오톡을 보냅니다.\n", to);
                    break;
            }
        }
    }
}
