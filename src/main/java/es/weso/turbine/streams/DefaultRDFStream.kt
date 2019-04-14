package es.weso.turbine.streams

/**
 * Default implementation for a rdf stream.
 *
 * @author Guillermo Facundo Colunga
 * @version 20190415
 */
data class DefaultRDFStream(private val rdfGraph: String, private val shapeMap: String, private val schema: String) : RDFStream {

    override fun getGraph(): String {
        return this.rdfGraph
    }

    override fun getShapeMap(): String {
        return this.shapeMap
    }

    override fun getSchema(): String {
        return this.getSchema()
    }
}