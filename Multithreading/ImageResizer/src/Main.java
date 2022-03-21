import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static int CORES = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        String srcFolder = "img/src";
        String dstFolder = "img/dst";

        File folder = new File(dstFolder);
        if (!folder.exists()) {
            folder.mkdir();
        }

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        int newWidth = 300;
        int filesLength = files.length;
        int threadLength;
        int srcPos = 0;

        ExecutorService executor = Executors.newFixedThreadPool(CORES);

        for (int i = CORES; i > 0; i--) {
            threadLength = filesLength / i;
            File[] filesInThread = new File[threadLength];
            System.arraycopy(files, srcPos, filesInThread, 0, threadLength);
            ImageResizer resizer = new ImageResizer(filesInThread, dstFolder, newWidth);
            executor.execute(resizer);

            filesLength = filesLength - threadLength;
            srcPos = srcPos + threadLength;
        }

        executor.shutdown();
    }
}
