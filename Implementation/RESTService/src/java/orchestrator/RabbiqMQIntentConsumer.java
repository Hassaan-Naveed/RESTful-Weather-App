/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orchestrator;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hassa
 */
public class RabbiqMQIntentConsumer {
    
    private static enum EXCHANGE_TYPE {DIRECT, FANOUT, TOPIC, HEADERS};
    
    private static final String INTENT_EXCHANGE = "TRAVEL_INTENTS";
    private static final String QUEUE_NAME = "";
    private static final String TOPIC_KEY_NAME = "n0898071-intents";
    
    public void run(){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            
            factory.setHost("152.71.155.95");
            factory.setUsername("student");
            factory.setPassword("COMP30231");
            
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            
            channel.exchangeDeclare(INTENT_EXCHANGE, EXCHANGE_TYPE.TOPIC.toString().toLowerCase());
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            
            channel.queueBind(QUEUE_NAME, INTENT_EXCHANGE, TOPIC_KEY_NAME);
            
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                
                if (!Intents.allIntents.contains(message)) {
                    Intents.allIntents.add(message);
                }
            };
            
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(RabbiqMQIntentConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
