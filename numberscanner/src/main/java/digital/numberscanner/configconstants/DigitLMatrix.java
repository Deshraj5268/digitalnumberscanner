package digital.numberscanner.configconstants;

import java.util.ArrayList;
import java.util.List;

public class DigitLMatrix {

    private static List<int [][]> matrixList;

    public static List<int [][]> getDigitMatrix(){
        if(matrixList == null){
            new DigitLMatrix();
        }
        return matrixList;
    }

    private DigitLMatrix(){
        matrixList =  new ArrayList<>();
        matrixList.add(new int[][] {{0,1,0},{2,0,2},{2,1,2}}); //0
        matrixList.add(new int[][] {{0,0,0},{0,0,2},{0,0,2}});//1
        matrixList.add(new int[][] {{0,1,0},{0,1,2},{2,1,0}});//2
        matrixList.add(new int[][] {{0,1,0},{0,1,2},{0,1,2}});//3
        matrixList.add(new int[][] {{0,0,0},{2,1,2},{0,0,2}});//4
        matrixList.add(new int[][] {{0,1,0},{2,1,0},{0,1,2}});//5
        matrixList.add(new int[][] {{0,1,0},{2,1,0},{2,1,2}});//6
        matrixList.add(new int[][] {{0,1,0},{0,0,2},{0,0,2}});//7
        matrixList.add(new int[][] {{0,1,0},{2,1,2},{2,1,2}});//8
        matrixList.add(new int[][] {{0,1,0},{2,1,2},{0,1,2}});//9
    }

    public static boolean isMatrixEqual(int [][] matrix1,int [][] matrix2){
        if(matrix1 == null || matrix2 == null){
            return false;
        }
        for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               if(matrix1[i][j] != matrix2[i][j]){
                   return false;
               }
           }
        }
        return true;
    }
}
