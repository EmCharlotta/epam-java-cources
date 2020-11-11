package com.epam.university.java.core.task031;

public class ClientImpl implements Client {
    private boolean online;
    private ServerImpl server;

    public ClientImpl(ServerImpl server) {
        this.server = server;
        this.online = false;
    }

    @Override
    public void sendMessage(String message) {

        if (online) {
            server.getMessages().add(message);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void start() {
        online = true;
    }

    @Override
    public void stop() {
        online = false;
    }
}
