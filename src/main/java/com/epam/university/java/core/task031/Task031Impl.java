package com.epam.university.java.core.task031;

public class Task031Impl implements Task031 {

    private ServerImpl server;

    @Override
    public Client createClient() {
        return new ClientImpl(server);
    }

    @Override
    public Server createServer() {
        server = new ServerImpl();
        return server;
    }
}
