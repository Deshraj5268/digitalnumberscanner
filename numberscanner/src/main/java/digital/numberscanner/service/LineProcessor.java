package digital.numberscanner.service;

import digital.numberscanner.configconstants.Constants;
import digital.numberscanner.configconstants.DigitLMatrix;
import digital.numberscanner.validationTest.SymbolValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineProcessor {

    SymbolValidator symbolValidator;

    @Autowired
    public LineProcessor(SymbolValidator symbolValidator) {
        this.symbolValidator = symbolValidator;
    }

    public String processor(String [] line,int lineLength){
        StringBuilder stringBuilder = new StringBuilder();
        int [][] matrix;
        char symbolChar;
        for(int i=0;i<lineLength;i+=3){
            String [] lineArr = new String[3];
            lineArr[0] = line[0].substring(i,i+3);
            lineArr[1] = line[1].substring(i,i+3);
            lineArr[2] = line[2].substring(i,i+3);
            matrix = symbolReader(lineArr,3);
            symbolChar = symbolMatcher(matrix);
            stringBuilder.append(symbolChar);
        }
        if(stringBuilder.indexOf(String.valueOf(Constants.INVALID_CHAR)) != -1){
            stringBuilder.append(Constants.ILLEGAL_LINE);
        }
        return stringBuilder.toString();
    }

    public char symbolMatcher(int[][] matrix1) {
        if(matrix1 != null) {
            List<int[][]> matrixList = DigitLMatrix.getDigitMatrix();
            for (int i = 0; i < matrixList.size(); i++) {
                if (DigitLMatrix.isMatrixEqual(matrix1, matrixList.get(i))) {
                    return (char) (i + '0');
                }
            }
        }
        return Constants.INVALID_CHAR;
    }

    public int[][] symbolReader(String [] line1, int n) {
        int [][] matrix = new int[n][n];
        for(int i=0;i<n;i++) {
            matrix[i] = convertToIntArray(line1[i], n);
            if(matrix[i] == null){
                return null;
            }
        }
        return matrix;
    }

    public int[] convertToIntArray(String line,int length) {
        int [] row = new int[length];
        for(int i=0;i<length;i++){
            if(symbolValidator.isValidCharacter(line.charAt(i))){
                row[i] = symbolValidator.getValueForChar(line.charAt(i));
            }else{
                return null;
            }
        }
        return row;
    }

}
