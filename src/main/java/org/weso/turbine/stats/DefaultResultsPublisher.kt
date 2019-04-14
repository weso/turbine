package org.weso.turbine.stats

import org.weso.turbine.validatiors.RDFValidatorResult

import java.math.BigInteger
import java.util.LinkedList

/**
 * Default implementation of a results publisher. It stores the results of the results received.
 *
 * @author Guillermo Facundo Colunga.
 * @version 20180414
 */
class DefaultResultsPublisher : ResultsPublisher {

    private val correctValidations: BigInteger = BigInteger.ZERO
    private val incorrectValidations: BigInteger = BigInteger.ZERO
    private var percentageOfCorrectValidations: Double = 0.toDouble()
    private val incorrectValidationResults: MutableCollection<RDFValidatorResult>

    init {
        this.percentageOfCorrectValidations = 0.0
        this.incorrectValidationResults = LinkedList()
    }

    override fun publish(result: RDFValidatorResult) {

        if (result.isCorrect) {
            this.correctValidations.add(BigInteger.ONE)
        } else {
            this.incorrectValidations.add(BigInteger.ONE)
            this.incorrectValidationResults.add(result)
        }

        this.percentageOfCorrectValidations = this.correctValidations.divide(this.correctValidations.add(this.incorrectValidations)).toFloat().toDouble()
    }
}
