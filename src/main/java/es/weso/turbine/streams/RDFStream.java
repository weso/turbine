package es.weso.turbine.streams;

import es.weso.rdf.jena.RDFAsJenaModel;

/**
 * Represents an rdf stream that can be validated.
 *
 * @author Guillermo Facundo Colunga
 * @version 20190419
 */
public interface RDFStream {

    /**
     * Gets the graph to validate against the schema in turtle syntax.
     *
     * @return an string in ttl syntax containing the graph to validate.
     */
    String getGraph();

    /**
     * Gets the shape expresion shape map associated with the graph.
     * <p>
     * set of properties for associating nodes with shapes. These are defined as RDF properties,
     * implying an execution model where the node/shape associations are supplied in RDF.
     * </p>
     *
     * @return the shape expresion shape map associated with the graph.
     */
    String getShapeMap();

    /**
     * Gets the schema against the graph will be validated.
     *
     * @return the schema against the graph will be validated.
     */
    String getSchema();
}