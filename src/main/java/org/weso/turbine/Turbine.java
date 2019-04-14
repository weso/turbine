package org.weso.turbine;

/**
 * The Turbine is the class used by the user to initialize the rdf stream validation process.
 *
 *
 * @autor Guillermo Facundo Colunga
 * @version 20180414
 */
public class Turbine {
    
    private StreamConsumer streamConsumer;
    private RDFValidator rdfValidator;
    
    public Turbine(StreamConsumer streamConsumer, RDFValidator rdfValidator) {
        setStreamConsumer(streamConsumer);
        setRDFValidator(rdfValidator);
    }

    private void setStreamConsumer(StreamConsumer streamConsumer) {
        if(streamConsumer == null) {
            throw new IllegalArgumentException("The stream consumer cannot be null.");
        }

        this.streamConsumer = streamConsumer;
    }

    private void setRDFValidator(RDFValidator rdfValidator) {
        if(rdfValidator == null) {
            throw new IllegalArgumentException("The rdf validator cannot be null.");
        }

        this.rdfValidator = rdfValidator;
    }
}
