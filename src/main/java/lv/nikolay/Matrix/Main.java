/*
package lv.nikolay.Matrix;

import static java.lang.Thread.sleep;

public class MultiplyArraysThread implements Runnable {
    private int[] firstMatrixRow;
    private int[] secondMatrixRow;
    private int calculatedValue;

    public int getCalculatedValue() {
        return calculatedValue;
    }

    public void setCalculatedValue(int calculatedValue) {
        this.calculatedValue = calculatedValue;
    }

    public MultiplyArraysThread(int[] firstArrayRow, int[] secondArrayRow) {
        this.firstMatrixRow = firstArrayRow;
        this.secondMatrixRow = secondArrayRow;
    }

    @Override
    public void run() {
        int result = 0;

        for (int k = 0; k < firstMatrixRow.length; k++) { // aColumn


            result += firstMatrixRow[k] * secondMatrixRow[k];
            if (result == 28){
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println("DEBUG: " + Thread.currentThread().getName()+ "result" +result);
        this.setCalculatedValue(result);




    }


}
*/
