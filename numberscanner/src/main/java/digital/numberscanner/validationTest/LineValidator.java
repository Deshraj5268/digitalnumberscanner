package digital.numberscanner.validationTest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LineValidator {

    public List<String> validateLines(String [] lines, int lineLength) {
        List<String> errorList = new ArrayList<>();
        if(lines == null || lines.length != 3){
            errorList.add("3 perfect lines not exist ");
        }
        String error;
        for(int i=0;i<lines.length;i++){
                error = validateEachLine(lines[i],lineLength);
                if(error !=null) {
                    errorList.add(String.format(i + " th" + error + " %d ", lines[i].length()));
                }
        }
        return errorList;
    }

    //we can add more validation if required SRP principle
    public String validateEachLine(String line, int lineLength){
        if(line.length() != lineLength){
            return "line length is invalid out of 3 lines ";
        }
        return null;
    }
}
