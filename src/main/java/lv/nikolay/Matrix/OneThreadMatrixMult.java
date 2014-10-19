package lv.nikolay.Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OneThreadMatrixMult {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> allThreads = new ArrayList<Thread>();

        OneThreadMatrixMult o = new OneThreadMatrixMult();
        Random randomGenerator = new Random();

        int[][] firstMatrix = new int[20][20];
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                firstMatrix[i][j] = randomGenerator.nextInt(100);
            }
        }
        int[][] secondMatrix = new int[20][20];
        for (int i = 0; i < secondMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                secondMatrix[i][j] = randomGenerator.nextInt(100);
            }
        }

        MatrixHolder mh = new MatrixHolder(firstMatrix, secondMatrix);
        mh.setTransMatrix(secondMatrix);
        long startTime = System.nanoTime();
        for (int i = 0; i < mh.getaMatrix().length; i++) {
            for (int j = 0; j < mh.getaMatrix().length; j++) {
                for (int k = 0; k < mh.getaMatrix().length; k++) {
                    mh.getResultMatrix()[i][j] += mh.getaMatrix()[i][k] * mh.getTransMatrix()[j][k];
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        }

        for (int i = 0; i < mh.getResultMatrix().length; i++) {
            for (int j = 0; j < mh.getResultMatrix()[0].length; j++) {
                System.out.format("%6d |", mh.getResultMatrix()[i][j]);
            }
            System.out.println();
        }
        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
        System.out.println("Main process done!");
    }
}
