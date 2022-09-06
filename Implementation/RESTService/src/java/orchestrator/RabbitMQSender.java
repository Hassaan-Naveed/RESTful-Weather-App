/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orchestrator;

import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hassa
 */
public class RabbitMQSender {
    
    private static enum EXCHANGE_TYPE {DIRECT, FANOUT, TOPIC, HEADERS};
    
    private static final String TRAVEL_EXCHANGE = "TRAVEL_OFFERS";
    private static final String INTENT_EXCHANGE = "TRAVEL_INTENTS";
    
    private static final String TOPIC_KEY_NAME_OFFERS = "n0898071-offers";
    private static final String TOPIC_KEY_NAME_INTENTS = "n0898071-intents";
    
    private static final ConnectionFactory factory = new ConnectionFactory();
    private static final Gson gson = new Gson();
    
    
    public static void sendTravelExchange(TravelDetails travelDetail){
        factory.setHost("152.71.155.95");
        factory.setUsername("student");
        factory.setPassword("COMP30231");
        
        try (Connection connection = factory.newConnection();
        Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(TRAVEL_EXCHANGE, EXCHANGE_TYPE.TOPIC.toString().toLowerCase());        
            String message = gson.toJson(travelDetail);
            
            channel.basicPublish(TRAVEL_EXCHANGE, 
                    TOPIC_KEY_NAME_OFFERS,
                    new AMQP.BasicProperties.Builder()
                        .contentType("text/json")
                        .deliveryMode(2)
                        .priority(1)
                        .userId("student")
                        .expiration("60000")
                        .build(),
                        message.getBytes(StandardCharsets.UTF_8));
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(RabbitMQSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void sendTravelIntent(IntentDetails intentDetail){
        factory.setHost("152.71.155.95");
        factory.setUsername("student");
        factory.setPassword("COMP30231");
        
        try (Connection connection = factory.newConnection();
        Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(INTENT_EXCHANGE, EXCHANGE_TYPE.TOPIC.toString().toLowerCase());
            
            String message = gson.toJson(intentDetail);
            
            channel.basicPublish(INTENT_EXCHANGE, 
                    TOPIC_KEY_NAME_INTENTS,
                    new AMQP.BasicProperties.Builder()
                        .contentType("text/json")
                        .deliveryMode(2)
                        .priority(1)
                        .userId("student")
                        .expiration("60000")
                        .build(),
                        message.getBytes(StandardCharsets.UTF_8));
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(RabbitMQSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
