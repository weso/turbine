package es.weso.turbine.validators

import es.weso.turbine.streams.RDFStream

/**
 * Default implementation of an rdf validated stream.
 *
 * @author Guillermo Facundo Colunga
 * @version 20180414
 */
data class DefaultRDFValidatorResult(private val validatedRDFStream: RDFStream, private val resultDescription: String, private val isCorrect: Boolean) : RDFValidatorResult {

    override fun getValidatedRDFStream(): RDFStream {
        return this.validatedRDFStream
    }

    override fun getResultDescription(): String {
        return this.resultDescription
    }

    override fun isCorrect(): Boolean {
        return this.isCorrect
    }
}
