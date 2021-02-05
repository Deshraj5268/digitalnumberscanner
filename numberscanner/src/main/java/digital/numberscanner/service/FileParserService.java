package digital.numberscanner.service;

import digital.numberscanner.configconstants.Constants;
import digital.numberscanner.validationTest.LineValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileParserService {

    @Autowired
     LineValidator lineValidator;
    @Autowired
     LineProcessor lineProcessor;

    public String fileParser(String [] line, int lineLength){
        List<String> errorList = lineValidator.validateLines(line,lineLength);
        if(!errorList.isEmpty()){
            System.out.println(errorList.toString());
            return Constants.ILLEGAL_LINE;
        }
        String outputLine = lineProcessor.processor(line,lineLength);
        return outputLine;
    }
}
