package validationTest;
import digital.numberscanner.configconstants.SymbolObject;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("SymbolValidator")
public class SymbolValidatorTest {

    @Test
    public void isValidCharacterTest(){
        assertTrue(SymbolObject.isSymbolExist('.'));
        assertTrue(SymbolObject.isSymbolExist('_'));
        assertTrue(SymbolObject.isSymbolExist('|'));
        assertFalse(SymbolObject.isSymbolExist('-'));
        assertFalse(SymbolObject.isSymbolExist('o'));
    }

    @Test
    public void getValueForChar(){
        assertEquals(SymbolObject.getSymbolPosition('.'),0);
        assertEquals(SymbolObject.getSymbolPosition('_'),1);
        assertEquals(SymbolObject.getSymbolPosition('|'),2);
    }
}
