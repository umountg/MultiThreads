package lv.nikolay.Matrix;

public class MultiplyTwoVectorsThread implements Runnable {
    private int[] firstMatrixRow;
    private int[] secondMatrixRow;
    private int[][] resultMatrix;

    public int[][] getResultMatrix() {
        return resultMatrix;
    }

    private int resultMatrixRow;
    private int resultMatrixCol  ;

    public MultiplyTwoVectorsThread(int[] firstArrayRow, int[] secondArrayRow, int[][] resultMatrix, int row, int col) {
        this.firstMatrixRow = firstArrayRow;
        this.secondMatrixRow = secondArrayRow;
        this.resultMatrix = resultMatrix;
        this.resultMatrixRow = row;
        this.resultMatrixCol = col;

    }

    @Override
    public void run() {
            for (int k = 0; k < firstMatrixRow.length; k++) { // aColumn
                resultMatrix[resultMatrixRow][resultMatrixCol] += firstMatrixRow[k] * secondMatrixRow[k];
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

    }

}
