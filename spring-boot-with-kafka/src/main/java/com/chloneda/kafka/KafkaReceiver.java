package com.chloneda.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author chloneda
 * @description: Kafka消息消费者
 */
@Component
public class KafkaReceiver {

    @KafkaListener(topics = {"ckafka"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("record =" + record);
            System.out.println("message =" + message);
        }
    }

}
