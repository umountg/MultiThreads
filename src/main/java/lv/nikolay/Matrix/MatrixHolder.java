package lv.nikolay.Matrix;

public class MatrixHolder {
    private int[][] aMatrix;
    private int[][] bMatrix;
    private int[][] TransMatrix;
    private int[][] resultMatrix;

    public int[][] getaMatrix() {
        return aMatrix;
    }

    public int[][] getTransMatrix() {
        return TransMatrix;
    }

    public void setaMatrix(int[][] aMatrix) {
        this.aMatrix = aMatrix;
    }

    public int[][] getbMatrix() {
        return bMatrix;
    }

    public void setbMatrix(int[][] bMatrix) {
        this.bMatrix = bMatrix;
    }

    public MatrixHolder(int[][] aMatrix, int[][] bMatrix) {
        this.aMatrix = aMatrix;
        this.bMatrix = bMatrix;
        createResultMatrix();

    }

    public int[][] getResultMatrix() {
        return resultMatrix;
    }

    public void setTransMatrix(int[][] Matrix) {

        int MatrixRowCount = Matrix.length;
        int MatrixColCount = Matrix[0].length;
        this.TransMatrix = new int[MatrixColCount][MatrixRowCount];

        for (int i = 0; i < MatrixColCount; i++) {
            for (int j = 0; j < MatrixRowCount; j++) {
                this.TransMatrix[i][j] = bMatrix[j][i];
            }
        }

    }

    public int[][] createResultMatrix() {
        int aMatrixRowCount = aMatrix.length;
        int bMatrixColCount = bMatrix[0].length;
        this.resultMatrix = new int[aMatrixRowCount][bMatrixColCount];

        return this.resultMatrix;
    }

}
