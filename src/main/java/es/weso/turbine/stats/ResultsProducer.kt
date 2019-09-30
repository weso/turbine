package es.weso.turbine.stats

import es.weso.turbine.validators.RDFValidatorResult

/**
 * A results producer is the object that will be published as a JSON or as whatever the user wants to.
 *
 * @author Guillermo Facundo Colunga
 * @version 20180414
 */
interface ResultsProducer {

    /**
     * Gets the number of correct validations that had occur until this method is called.
     *
     * @return the number of correct validations.
     */
    val numberOfCorrectValidations: String

    /**
     * Gets the number of incorrect validations that had occur until this method is called.
     *
     * @return the number of incorrect validations.
     */
    val numberOfIncorrectValidations: String

    /**
     * Gets the percentage of correct validations that had occur until this method is called.
     *
     * @return the percentage of correct validations.
     */
    val percentageOfCorrectValidations: String

    /**
     * Gets the incorrect validations objects that had occur until this method is called.
     *
     * @return the incorrect validations objects.
     */
    val incorrectValidationResults: Collection<RDFValidatorResult>
}
