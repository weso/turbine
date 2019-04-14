package org.weso.turbine;

/**
 * For every possible implementation of an RDF validator we will have a validate method
 * that after its execution will return a result with the validated rdf stream and the
 * validation result.
 *
 * @author Guillermo Facundo Colunga
 * @version 20190414
 */
@FunctionalInterface
public interface RDFValidator {

    /**
     * Performs the validation algorithm over an RDF Stream and returns the result.
     *
     * @return the result of the validation for the rdf stream. The result can be
     * correct or incorrect, in the last case will contain the description of the error.
     */
    RDFValidatorResult validate(RDFStream rdfStream);
}
