package org.weso.turbine.validatiors;

import org.weso.turbine.streams.RDFStream;

/**
 * After a validatiors a result is generated. The result contains the validated
 * RDF stream and the result of the validatiors.
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
     * Gets the description of the validatiors. If the validatiors result is correct
     * will have a correct message, else will contain the error.
     *
     * @return If the validatiors result is correct will have a correct message, else will contain the error.
     */
    String getResultDescription();

    /**
     * If a validatiors produces any error this fild will be false. True otherwise.
     *
     * @return the result of the validatiors in terms o a boolean variable.
     */
    boolean isCorrect();
}
