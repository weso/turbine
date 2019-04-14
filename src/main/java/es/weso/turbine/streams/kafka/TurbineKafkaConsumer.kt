package es.weso.turbine.streams.kafka

import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.ConsumerRecords
import es.weso.turbine.streams.StreamConsumer

/**
 * Defines a consumer top-level interface for consumers to communicate with the configuration.
 *
 * @author Guillermo Facundo Colunga
 * @version 20190414
 */
interface TurbineKafkaConsumer: StreamConsumer {

    /**
     * Gets the object kafka consumer.
     *
     * @returns a kafka consumer object.
     */
    fun createConsumer(): Consumer<Long, String>

    /**
     * Polls the given number of records from the consumer, if possible.
     *
     * @param numberOfRecords is the number of records to poll from the consumer.
     */
    fun poll(timeToPoll: Long): ConsumerRecords<Long, String>
}