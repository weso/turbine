package org.weso.turbine.streams

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