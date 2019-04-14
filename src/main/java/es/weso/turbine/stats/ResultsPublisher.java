package es.weso.turbine.stats;

import es.weso.turbine.validators.RDFValidatorResult;

/**
 * Interface to all posible implementations of aany results publishers.
 *
 * @author Guillermo Facundo Colunga.
 * @version 20190414
 */
@FunctionalInterface
public interface ResultsPublisher {

    /**
     * Publishes a given result.
     *
     * @param result to publish.
     */
    void publish(RDFValidatorResult result);
}
