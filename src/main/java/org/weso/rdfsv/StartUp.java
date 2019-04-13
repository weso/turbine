package org.weso.rdfsv;

import org.weso.rdfsv.kafka.KafkaConsumer;
import org.weso.rdfsv.kafka.KafkaConsumerConfiguration;

public class StartUp {

    public static void Main(String... args) {

        // Creating the kafka consumer.
        new KafkaConsumer(new KafkaConsumerConfiguration("","","")).run();
    }
}
