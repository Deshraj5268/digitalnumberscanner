package serviceTest;

import digital.numberscanner.configconstants.Constants;
import digital.numberscanner.service.LineProcessor;
import digital.numberscanner.validationTest.SymbolValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LineProcessorTest {

    private SymbolValidator symbolValidator = new SymbolValidator();
    private LineProcessor lineProcessor = new LineProcessor(symbolValidator);

    @Test
    public void validCharacter(){

        String [] lines = {"._.",
                           "|_|",
                           "|_|"};

        int [][] matrix = lineProcessor.symbolReader(lines,3);
        assertEquals(lineProcessor.symbolMatcher(matrix),'8');
    }

    @Test
    public void invalidCharacter(){
        String [] lines = {"._.",
                            "|_|",
                            "|__"};

        int [][] matrix = lineProcessor.symbolReader(lines,3);
        assertEquals(lineProcessor.symbolMatcher(matrix), Constants.INVALID_CHAR);

    }
}
