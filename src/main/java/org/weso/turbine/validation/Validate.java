package org.weso.turbine.validation;

import es.weso.rdf.jena.RDFAsJenaModel;
import es.weso.shapeMaps.ShapeMap;
import es.weso.shex.Schema;
import es.weso.shex.validator.Validator;
import es.weso.utils.FileUtils;
import scala.Option;
import scala.util.Either;
import scala.util.Left;
import scala.util.Right;

import java.io.File;
import java.nio.file.Paths;

public class Validate {

    Option<String> none = Option.empty();

    public Either<String, Result> validate(String dataFile,
                                           String dataFormat,
                                           String schemaFile,
                                           String schemaFormat,
                                           String shapeMapFile,
                                           String shapeMapFormat) {

        RDFAsJenaModel emptyRDF = RDFAsJenaModel.apply();

        return readRDF(dataFile, dataFormat).flatMap(rdf ->
                FileUtils.getContents(schemaFile).flatMap(schemaStr ->
                        Schema.fromString(schemaStr,schemaFormat,none, emptyRDF).flatMap(schema ->
                                FileUtils.getContents(shapeMapFile).flatMap(shapeMapStr ->
                                        ShapeMap.fromString(shapeMapStr.toString(),
                                                shapeMapFormat,
                                                none,
                                                rdf.getPrefixMap(),
                                                schema.prefixMap()).flatMap(shapeMap ->
                                                ShapeMap.fixShapeMap(shapeMap,
                                                        rdf,
                                                        rdf.getPrefixMap(),
                                                        schema.prefixMap()).flatMap(fixedShapeMap ->
                                                        Validator.validate(schema,
                                                                fixedShapeMap,
                                                                rdf).flatMap(resultShapeMap ->
                                                                new Right<String,Result>(new Result(schema, rdf, shapeMap, resultShapeMap))
                                                        )))))));


    }

    public Either<String, RDFAsJenaModel> readRDF(String fileName, String format) {
        try {
            //log.info("Reading data file " + fileName);
            File file = Paths.get(fileName).toFile();
            return RDFAsJenaModel.fromFile(file, format, none);
        } catch (Exception e) {
            return new Left<>("Error reading file " + fileName + ":" + e.getMessage());
        }
    }
}
