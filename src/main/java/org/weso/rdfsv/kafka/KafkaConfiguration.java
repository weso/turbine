package org.weso.rdfsv.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;

public interface KafkaConfiguration {

    KafkaConsumer<String, String> getConsumer();

}
