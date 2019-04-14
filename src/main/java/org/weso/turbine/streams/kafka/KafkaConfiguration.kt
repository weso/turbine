package org.weso.turbine.streams.kafka

import java.util.Properties

/**
 * Interface for connection over kafka. Represents the basic configuration for kafka.
 *
 * @author Guillermo Facundo Colunga
 * @version 20180414
 */
interface KafkaConfiguration {

    /**
     * For kafka to be configured it is needed to provide a set of properties,
     * those properties will be encapsulated at the java Properties object.
     *
     * @return the properties object containing all needed properties to connect
     * to kafka.
     */
    val consumer: Properties

}
