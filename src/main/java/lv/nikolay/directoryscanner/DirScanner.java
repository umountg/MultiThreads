package lv.nikolay.directoryscanner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirScanner implements Runnable {
    private List<String> searchResult;
    private File initialDir;
    private String searchMask;

    public DirScanner(String searchMask, File initialDir, List<String> searchResult) {
        this.searchMask = searchMask;
        this.initialDir = initialDir;
        this.searchResult = searchResult;
    }

    public void walkin(String searchMask, File initialDir, List<String> searchResult) {

        File listFile[] = initialDir.listFiles();
        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    DirScanner ds = new DirScanner(searchMask, listFile[i], searchResult);
                    Thread t = new Thread(ds);
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (listFile[i].getName().matches(searchMask)) {
                        searchResult.add(listFile[i].getPath());
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        walkin(searchMask, initialDir, searchResult);

    }

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.nanoTime();
        List<String> searchResult = Collections.synchronizedList(new ArrayList<String>());
        File initialDir = new File("/Users");
        String pattern = ".*\\.mp3.*";

        DirScanner ds = new DirScanner(pattern, initialDir, searchResult);
        Thread t = new Thread(ds);
        t.start();
        t.join();
        //Thread.sleep(10000);

//        for (String path : searchResult) {
//            System.out.println(path);
//        }
        System.out.println("Found " + searchResult.size() + " files");
        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) + " ns");
        System.out.println("Main process done!");
    }

}
