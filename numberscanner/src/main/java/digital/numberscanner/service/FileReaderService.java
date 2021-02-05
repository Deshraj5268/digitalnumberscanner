package digital.numberscanner.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class FileReaderService {

    @Value("${base.path}")
    public String basePath;

    @Autowired
    FileChunker chunker;

    public boolean fileReaderProcessor(String inputFilePath) throws Exception{
        BufferedReader bufferedReader = null;
        String inputFullFilePath = basePath+inputFilePath;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFullFilePath));
            chunker.fileChunker(bufferedReader);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return false;
    }

    public String getBasePath() {
        return basePath;
    }
}
