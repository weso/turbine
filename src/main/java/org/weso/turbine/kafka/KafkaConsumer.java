package org.weso.turbine.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.time.Duration;

public class KafkaConsumer implements Runnable {

    private KafkaConfiguration configuration;

    public KafkaConsumer(KafkaConsumerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void run() {
        int count = 0;
        while(true) {
            ConsumerRecords<String,String> records = configuration.getConsumer().poll(Duration.ofMillis(200));

            if (records.count() == 0) {
                // timeout/nothing to read
            } else {
                // Yes, loop over records
                for(ConsumerRecord<String, String> record: records) {
                    // Display record and count
                    count += 1;
                    System.out.println( count + ": " + record.value());
                }
            }
        }
    }
}
