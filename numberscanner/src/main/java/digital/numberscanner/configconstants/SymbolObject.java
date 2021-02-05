package digital.numberscanner.configconstants;

import java.util.ArrayList;


public class SymbolObject {

    private SymbolObject(){

    }

    private static ArrayList<Character> symbols = new ArrayList<Character>();
    static {
        symbols.add('.');
        symbols.add('_');
        symbols.add('|');
    }

    public static boolean isSymbolExist(char ch){
        return symbols.contains(ch);
    }

    public static int getSymbolPosition(char ch){
        return symbols.lastIndexOf(ch);
    }
}
