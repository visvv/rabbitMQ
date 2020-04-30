package com.vv.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;

public class ConnectionManager {
    public static ConnectionFactory createConnectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("user");
        connectionFactory.setPassword("password");
        return connectionFactory;
    }
}
