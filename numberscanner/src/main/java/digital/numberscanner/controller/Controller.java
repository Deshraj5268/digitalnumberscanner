package digital.numberscanner.controller;

import digital.numberscanner.configconstants.Constants;
import digital.numberscanner.service.FileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/scanner",consumes = MediaType.ALL_VALUE,produces = MediaType.ALL_VALUE)
public class Controller {


    @Autowired
    private FileReaderService fileReaderService;

    @GetMapping(value = "v1/digital-number-scanner")
    public String getOutPutPath() throws Exception {
        String filePath = Constants.INPUT_DIR_PATH+"testInput";
        boolean isFileProcessed = fileReaderService.fileReaderProcessor(filePath);
        return isFileProcessed? fileReaderService.getBasePath()+Constants.OUTPUT_DIR_PATH+"testOutput":"ERRORINPROCESSING";
    }

    @GetMapping(value = "/test",consumes = MediaType.ALL_VALUE,produces = MediaType.ALL_VALUE)
    public String test1(){
        return "test";
    }
}
