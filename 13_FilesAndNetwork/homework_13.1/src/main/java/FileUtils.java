package main.java;

import java.io.File;
import java.text.DecimalFormat;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long size = 0;
        try {
            File folder = new File(path);
            if (folder.isFile()) {
                return folder.length();
            }
            File[] files = folder.listFiles();
            for (File file : files) {
                size += calculateFolderSize(file.getPath());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return size;
    }

    public static String getSizeFile (long size) {
        DecimalFormat df = new DecimalFormat("0.00");
        float sizeKb = 1024.0f;
        float sizeMb = sizeKb * sizeKb;
        float sizeGb = sizeMb * sizeKb;
        float sizeTb = sizeGb * sizeKb;

        if (size < sizeMb) {
            return df.format(size / sizeKb) + " Kb";
        } else if (size < sizeGb) {
            return df.format(size / sizeMb) + " Mb";
        } else if (size < sizeTb) {
            return df.format(size / sizeGb) + " Gb";
        } else {
            return df.format(size / sizeTb) + " Tb";
        }
    }
}
