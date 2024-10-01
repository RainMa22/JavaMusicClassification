package me.rainma22.JavaMusicClassification.preprocessing;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Preprocessor of data
 **/
public class DataPreprocessor {

    private CSVParser parser;

    /**
     * creates a new DataPreprocessor with the given path to CSV
     *
     * @param pathToDatasetCsv pathToDatasetCsv
     * @throws java.io.FileNotFoundException if file is not found
     * @throws IOException if failed to parse CSV
     **/
    public DataPreprocessor(String pathToDatasetCsv) throws IOException {
        CSVParser csvParser = new CSVParser(
                new InputStreamReader(new FileInputStream(pathToDatasetCsv)), CSVFormat.RFC4180);
    }

    public double[] preprocessData(){
        return new double[0]; //TODO
    };
}
