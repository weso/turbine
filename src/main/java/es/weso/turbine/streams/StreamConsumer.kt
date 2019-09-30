package es.weso.turbine.streams

/**
 * Defines a common interface for any implementation of different streaming systems.
 *
 * @author Guillermo Facundo Colunga.
 * @version 20180414
 */
interface StreamConsumer {

    /**
     * Whenever an stream arrives to a consumer it must be processed to obtain the RDF stream associted to it.
     *
     * @return the rdf stream object contained in the stream event.
     */
    fun consume(): Collection<RDFStream>
}