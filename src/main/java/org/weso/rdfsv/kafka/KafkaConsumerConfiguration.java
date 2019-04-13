package org.weso.rdfsv.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerConfiguration implements KafkaConfiguration {

    private KafkaConsumer<String, String> consumer;

     public KafkaConsumerConfiguration(String brokers, String groupId, String topicName) {

         // Initializing the properties.
         Properties properties = new Properties();

         // Point it to the brokers.
         properties.setProperty("bootstrap.servers", brokers);

         // Set the consumer group (all consumers must belong to a group).
         properties.setProperty("group.id", groupId);

         // Set how to serialize key/value pairs.
         properties.setProperty("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
         properties.setProperty("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

         // When a group is first created, it has no offset stored to start reading from. This tells it to start
         // with the earliest record in the stream.
         properties.setProperty("auto.offset.reset","earliest");

         // Creating the consumer.
         consumer = new KafkaConsumer<>(properties);

         // Subscribe the consumer to the given topic.
         consumer.subscribe(Arrays.asList(topicName));
     }

     @Override
     public KafkaConsumer<String, String> getConsumer() {
         return this.consumer;
     }
}
