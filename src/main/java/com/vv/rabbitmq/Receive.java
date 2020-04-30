package com.vv.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

public class Receive {
    public static final String MY_QUEUE = "MY_QUEUE";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionManager.createConnectionFactory().newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(MY_QUEUE, false, false, false, null);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            System.out.println(new String(delivery.getBody(), "UTF-8"));
        };
        channel.basicConsume(MY_QUEUE, true, deliverCallback, (cancel)->{});
    }
}
