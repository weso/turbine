package org.weso.turbine.streams;

import java.util.Collection;

/**
 * Defines a common interface for any implementation of different streaming systems.
 *
 * @author Guillermo Facundo Colunga.
 * @version 20180414
 */
public interface StreamConsumer {

    /**
     * Whenever an stream arrives to a consumer it must be processed to obtain the RDF stream associted to it.
     *
     * @return the rdf stream object contained in the stream event.
     */
    Collection<RDFStream> consume();
}