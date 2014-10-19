package lv.nikolay.directoryscanner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleThreadPool {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<String> searchResult = Collections.synchronizedList(new ArrayList<String>());

        File initialDir = new File("/Users");
        String searchPattern = ".*\\.mp3.*";

        SimpleThread st = new SimpleThread(searchPattern, initialDir, searchResult, executor);
        executor.execute(st);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {

        }


//        executor.shutdown();

//        while (!executor.isTerminated()) {
//        }
//        for (String path : searchResult) {
//            System.out.println(path);
//        }

        System.out.println("Found " + searchResult.size() + " files");
        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) + " ns");
        System.out.println("Main process done!");
    }

}