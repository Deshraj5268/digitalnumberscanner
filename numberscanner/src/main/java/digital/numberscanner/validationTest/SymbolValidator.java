package digital.numberscanner.validationTest;


import digital.numberscanner.configconstants.SymbolObject;
import org.springframework.stereotype.Component;

@Component
public class SymbolValidator {

  /*  @Autowired
    SymbolObject symbol;*/

    public int getValueForChar(char charAt) {
        return SymbolObject.getSymbolPosition(charAt);
    }

    public boolean isValidCharacter(char charAt) {
        return SymbolObject.isSymbolExist(charAt);
    }
}
