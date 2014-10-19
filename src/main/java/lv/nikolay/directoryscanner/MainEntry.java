package lv.nikolay.directoryscanner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainEntry {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<String> searchResult = Collections.synchronizedList(new ArrayList<String>());

        walkin(new File("/Users"), searchResult); //Replace this with a suitable directory

//        for (String path : searchResult){
//            System.out.println(path);
//        }
        System.out.println("Found " + searchResult.size() + " files");
        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) + " ns");
        System.out.println("Main process done!");
    }

    /**
     * Recursive function to descend into the directory tree and find all the files
     * that end with ".mp3"
     *
     * @param dir A file object defining the top directory
     */
    public static void walkin(File dir, List<String> searchResult) {
        String pattern = ".*\\.mp3.*";

        File listFile[] = dir.listFiles();
        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    walkin(listFile[i], searchResult);
                } else {
                    if (listFile[i].getName().matches(pattern)) {
                     //   System.out.println(listFile[i].getPath());
                        searchResult.add(listFile[i].getPath());
                    }
                }
            }
        }
    }
}
// 2457661000
// 6236428000
// 1357925000

