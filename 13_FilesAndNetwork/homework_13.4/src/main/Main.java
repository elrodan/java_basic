package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        if (!Files.isDirectory(Paths.get("images"))) {
            Files.createDirectory(Paths.get("images/"));
        }
        Document doc = Jsoup.connect("https://lenta.ru/").get();
        Elements images = doc.select("img.g-picture");
        images.forEach(element -> {
            String absScr = element.attr("abs:src");
            String nameFile = absScr.substring(absScr.lastIndexOf("/") + 1);
            String formatName = absScr.substring(absScr.lastIndexOf(".") + 1);
            try {
                URL url = new URL(absScr);
                BufferedImage image = ImageIO.read(url);
                ImageIO.write(image, formatName, new File("images/" + nameFile));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
