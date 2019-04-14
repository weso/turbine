package es.weso.turbine.stats;

import es.weso.turbine.validators.RDFValidatorResult;

import java.util.Collection;

/**
 * A results producer is the object that will be published as a JSON or as whatever the user wants to.
 *
 * @author Guillermo Facundo Colunga
 * @version 20180414
 */
public interface ResultsProducer {

    /**
     * Gets the number of correct validations that had occur until this method is called.
     *
     * @return the number of correct validations.
     */
    String getNumberOfCorrectValidations();

    /**
     * Gets the number of incorrect validations that had occur until this method is called.
     *
     * @return the number of incorrect validations.
     */
    String getNumberOfIncorrectValidations();

    /**
     * Gets the percentage of correct validations that had occur until this method is called.
     *
     * @return the percentage of correct validations.
     */
    String getPercentageOfCorrectValidations();

    /**
     * Gets the incorrect validations objects that had occur until this method is called.
     *
     * @return the incorrect validations objects.
     */
    Collection<RDFValidatorResult> getIncorrectValidationResults();
}
