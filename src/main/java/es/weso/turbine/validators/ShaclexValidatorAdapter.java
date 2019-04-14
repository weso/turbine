package es.weso.turbine.validators;


import es.weso.turbine.streams.RDFStream;

public class ShaclexValidatorAdapter implements RDFValidator {

    @Override
    public RDFValidatorResult validate(RDFStream rdfStream) {
        String graphToValidate = rdfStream.getGraph();
        String scheema = rdfStream.getSchema();
        String shapeMap = rdfStream.getShapeMap();

        // Validation must be done here...
        // Validator.validate()

        return new DefaultRDFValidatorResult(rdfStream, "", false);
    }
}
