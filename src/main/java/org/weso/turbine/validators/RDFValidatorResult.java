package org.weso.turbine.validators;

import org.weso.turbine.streams.RDFStream;

/**
 * After a validators a result is generated. The result contains the validated
 * RDF stream and the result of the validators.
 *
 * @author Guillermo Facundo Colunga
 * @version 20190414
 */
public interface RDFValidatorResult {

    /**
     * Gets the validated RDF stream.
     *
     * @return the validated RDF stream.
     */
    RDFStream getValidatedRDFStream();

    /**
     * Gets the description of the validators. If the validators result is correct
     * will have a correct message, else will contain the error.
     *
     * @return If the validators result is correct will have a correct message, else will contain the error.
     */
    String getResultDescription();

    /**
     * If a validators produces any error this fild will be false. True otherwise.
     *
     * @return the result of the validators in terms o a boolean variable.
     */
    boolean isCorrect();
}
