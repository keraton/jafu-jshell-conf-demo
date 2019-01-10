package com.sample;

import java.util.*;

public class MessageRepository {

    public Map<Integer, String> message = new HashMap<>();
    private Random random = new Random();

    public MessageRepository() {
        message.put(1, "Hello !!");
        message.put(2, "Bonjour !!");
        message.put(3, "Selamat Pagi !!");
    }

    public String getMessage() {
        return message.get(random.nextInt(4 - 1) + 1);
    }
}
