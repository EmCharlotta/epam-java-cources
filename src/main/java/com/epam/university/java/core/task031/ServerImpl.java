package com.epam.university.java.core.task031;

import java.util.ArrayList;

public class ServerImpl implements Server {
    private ArrayList<String> messages;
    private boolean online;

    public ServerImpl() {
        this.messages = new ArrayList<>();
        this.online = false;
    }

    @Override
    public String readMessage() {
        if (messages.size() > 0) {
            String current = messages.get(messages.size() - 1);
            messages.remove(messages.size() - 1);
            return current;
        } else {
            return "";
        }
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    @Override
    public void start() {
        this.online = true;
    }

    @Override
    public void stop() {
        online = false;
    }
}
