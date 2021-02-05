package digital.numberscanner.service;

import digital.numberscanner.configconstants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileWriterService {

    @Value("${base.path}")
    private String basePath;

    public void outputWriter(String outputLine) {
        System.out.println(outputLine);
        writeOutputInFile(outputLine);
    }

    public void writeOutputInFile(String outputLine){
        BufferedWriter bufferedWriter = null;
        String outputPath = basePath+ Constants.OUTPUT_DIR_PATH +"testOutput";
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(outputPath,true));
            bufferedWriter.write(outputLine);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }finally {
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.printf(e.getMessage());
                }
            }
        }
    }
}
