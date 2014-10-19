package lv.nikolay.directoryscanner;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;


public class SimpleThread implements Runnable {
    private List<String> searchResult;
    private File initialDir;
    private String searchPattern;
    ExecutorService exec;

    public SimpleThread(String searchPattern, File initialDir, List<String> searchResult, ExecutorService exec) {
        this.searchPattern = searchPattern;
        this.initialDir = initialDir;
        this.searchResult = searchResult;
        this.exec = exec;
    }

    public void walkin(String searchPattern, File initialDir, List<String> searchResult, ExecutorService exec) {

        File listFile[] = initialDir.listFiles();
        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    //System.out.println("Directory = " + listFile[i]);
                    //System.out.println("New Thread should be created!");

                    SimpleThread st = new SimpleThread(searchPattern, listFile[i], searchResult, exec);
                    exec.execute(st);


                } else {
                    if (listFile[i].getName().matches(searchPattern)) {
                        searchResult.add(listFile[i].getPath());
                    //    System.out.println("File added!" + listFile[i].getPath());
                    }

                }
            }
        }

    }

    @Override
    public void run() {
        walkin(searchPattern, initialDir, searchResult, exec);

    }
}
