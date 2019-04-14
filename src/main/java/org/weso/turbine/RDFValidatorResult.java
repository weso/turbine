package org.weso.turbine;

/**
 * After a validation a result is generated. The result contains the validated
 * RDF stream and the result of the validation.
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
     * Gets the description of the validation. If the validation result is correct
     * will have a correct message, else will contain the error.
     *
     * @return If the validation result is correct will have a correct message, else will contain the error.
     */
    String getResultDescription();

    /**
     * If a validation produces any error this fild will be false. True otherwise.
     *
     * @return the result of the validation in terms o a boolean variable.
     */
    boolean isCorrect();
}
