package es.weso.turbine.validators

import es.weso.turbine.streams.RDFStream

/**
 * For every possible implementation of an RDF validator we will have a validate method
 * that after its execution will return a result with the validated rdf stream and the
 * validators result.
 *
 * @author Guillermo Facundo Colunga
 * @version 20190414
 */
@FunctionalInterface
interface RDFValidator {

    /**
     * Performs the validators algorithm over an RDF Stream and returns the result.
     *
     * @return the result of the validators for the rdf stream. The result can be
     * correct or incorrect, in the last case will contain the description of the error.
     */
    fun validate(rdfStream: RDFStream): RDFValidatorResult

    companion object {

        val SHACLEX_VALIDATOR: RDFValidator = ShaclexValidatorAdapter()
    }
}
