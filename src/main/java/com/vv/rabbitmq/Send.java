package com.vv.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Send {
    public static final String QUEUE_NAME = "MY_QUEUE";

    public static void main(String[] args) throws Exception {
        try(Connection connection = ConnectionManager.createConnectionFactory().newConnection();
            Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello rabbitMQ";
            channel.basicPublish("", QUEUE_NAME, null,
                    message.getBytes(StandardCharsets.UTF_8));
            System.out.println("Message sent...");
        }
    }
}
