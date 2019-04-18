package es.weso.turbine.streams.kafka

import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import es.weso.turbine.streams.RDFStream

import java.time.Duration
import java.util.*

/**
 * Defeault implementation for a kafka consumer.
 *
 * @author Guillermo Facundo Colunga
 * @version 20190415
 */
class DefaultTurbineKafkaConsumer(private val kafkaConfiguration: TurbineKafkaConfiguration, private val timeToPollMs: Long) : TurbineKafkaConsumer {

    private var consumer: KafkaConsumer<Long, String>? = null

    override fun createConsumer(): Consumer<Long, String> {
        if (this.consumer != null) {
            throw IllegalStateException("Consumer already exists, cannot be created again.")
        }
        this.consumer = KafkaConsumer(this.kafkaConfiguration.configuration)

        //this.consumer.subscribe(topicName)

        return this.consumer!!
    }

    override fun poll(timeToPoll: Long): ConsumerRecords<Long, String> {
        return this.consumer!!.poll(Duration.ofMillis(timeToPoll))
    }

    override fun consume(): MutableCollection<RDFStream> {

        this.poll(this.timeToPollMs) // This obtains the collection of results found on kafka.

        // Somewhere in here they must be parsed and serialized to and RDFStream object.

        // Finally we return the mutable collection.
        return mutableListOf()
    }
}
