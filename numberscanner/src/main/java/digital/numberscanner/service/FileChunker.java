package digital.numberscanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;

import static digital.numberscanner.configconstants.Constants.LINE_LENGTH;


@Service
public class FileChunker {

    @Autowired
    FileParserService fileParserService;
    @Autowired
    FileWriterService fileWriterService;

    public void fileChunker(BufferedReader bufferedReader) throws IOException {
        while (true) {
            String[] strings = new String[3];
            int i=0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if("".equals(line)){
                    i = 0;
                }else {
                    strings[i] = line;
                    i++;
                }
                if(i == 3){
                    String outputLine = fileParserService.fileParser(strings,LINE_LENGTH);
                    fileWriterService.outputWriter(outputLine);
                }
            }
            if(i == 0){
                break;
            }
        }
    }
}
