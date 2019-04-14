package org.weso.turbine;

import org.weso.turbine.stats.ResultsPublisher;
import org.weso.turbine.streams.RDFStream;
import org.weso.turbine.streams.StreamConsumer;
import org.weso.turbine.validatiors.RDFValidator;
import org.weso.turbine.validatiors.RDFValidatorResult;

import java.util.Collection;

/**
 * The Turbine is the class used by the user to initialize the rdf stream validatiors process.
 *
 *
 * @author Guillermo Facundo Colunga
 * @version 20180414
 */
public class Turbine implements Runnable {
    
    private StreamConsumer streamConsumer;
    private RDFValidator rdfValidator;
    private ResultsPublisher resultsPublisher;

    private boolean continueExecuting;

    /**
     * Default constructor for a turbine instance.
     *
     * @param streamConsumer is the consumer system use to get the streams.
     * @param rdfValidator is the validator algorithm that will validate the streams.
     */
    public Turbine(StreamConsumer streamConsumer, RDFValidator rdfValidator) {
        setStreamConsumer(streamConsumer);
        setRDFValidator(rdfValidator);
    }

    public Turbine(StreamConsumer streamConsumer, RDFValidator rdfValidator, ResultsPublisher resultsPublisher) {
        setStreamConsumer(streamConsumer);
        setRDFValidator(rdfValidator);
        setResultsPublisher(resultsPublisher);
    }

    /**
     * Checks and sets the stream consumer.
     *
     * @param streamConsumer to be set.
     */
    private void setStreamConsumer(StreamConsumer streamConsumer) {
        if(streamConsumer == null) {
            throw new IllegalArgumentException("The stream consumer cannot be null.");
        }

        this.streamConsumer = streamConsumer;
    }

    /**
     * Checks and sets the rdf validator.
     *
     * @param rdfValidator to be set.
     */
    private void setRDFValidator(RDFValidator rdfValidator) {
        if(rdfValidator == null) {
            throw new IllegalArgumentException("The rdf validator cannot be null.");
        }

        this.rdfValidator = rdfValidator;
    }

    /**
     * Checks and sets the results publisher.
     *
     * @param resultsPublisher to be set.
     */
    private void setResultsPublisher(ResultsPublisher resultsPublisher) {
        if(resultsPublisher == null) {
            throw new IllegalArgumentException("The results publisher cannot be null.");
        }

        this.resultsPublisher = resultsPublisher;
    }

    /**
     * Stops the execution of the turbine consumer. If needed to run again just execute run again.
     */
    public void stop() {
        this.continueExecuting = false;
    }

    @Override
    public void run() {
        this.continueExecuting = true;

        while(this.continueExecuting) {
            Collection<RDFStream> streams = this.streamConsumer.consume();
            RDFValidatorResult result;

            for(RDFStream stream : streams) {
                result = this.rdfValidator.validate(stream);

                if(this.resultsPublisher!=null)
                    this.resultsPublisher.publish(result);
            }
        }
    }
}
