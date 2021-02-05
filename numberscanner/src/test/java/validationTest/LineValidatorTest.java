package validationTest;

import digital.numberscanner.validationTest.LineValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LineValidatorTest {

    LineValidator lineValidator = new LineValidator();

    @Test
    public void exactlyThreeLineExistTest(){
        String [] lines = {"._.._.._.._.._.._.._.._.._.",
                           "|.||.||.||.||.||.||.||.||.|",
                           "|_||_||_||_||_||_||_||_||_|"};
        List<String> errorList =  lineValidator.validateLines(lines,27);
        assertEquals(errorList.isEmpty(),true);
    }

    @Test
    public void eachLineShouldHave27Character(){

        String [] lines = {"._.._.._.._.._.._.._.._.._",
                           "|.||.||.||.||.||.||.||.||.|",
                           "|_||_||_||_||_||_||_||_||_|"};

        assertNotNull(lineValidator.validateEachLine(lines[0],27));
        assertNull(lineValidator.validateEachLine(lines[1],27));
        assertNull(lineValidator.validateEachLine(lines[2],27));
    }
}
