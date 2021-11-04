package main.java;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long size = 0;
        try {
           size = Files.walk(Paths.get(path)).map(Path::toFile).filter(File::isFile).mapToLong(File::length).sum();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return size;
    }

    public static String getSizeFile (long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[] {"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int)(Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups))
                + " " + units[digitGroups];
    }
}
