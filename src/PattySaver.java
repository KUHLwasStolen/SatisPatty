/*
 * Description: Class that contains all the necessary stuff to save a finished pattern
 * Creator: @KUHLwasStolen
 * Editor(s): @KUHLwasStolen
 * Version: V1.0.0
 * License: GPLv3
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

public class PattySaver {
    public static String savePattern(PattyPress pPress) {
        BufferedImage screenshot = new BufferedImage(pPress.WIDTH, pPress.HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics screenShG = screenshot.getGraphics();

        // Sets the filename to the current date and time and creates a directory for images if necessary
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String filepath = "../screenshots/" + LocalDateTime.now().format(formatter) + ".png";
        try {
            Files.createDirectories(Paths.get("../screenshots/"));
        } catch (Exception e) {
            System.out.printf("%sSomething went terribly wrong while creating a directory!%s", PattyConsole.RED, PattyConsole.RESET);
            e.printStackTrace();
        }
        File screenFile = new File(filepath);

        // Resets the pattern and then runs it again, but now paints on the image instead of the screen
        pPress.setup(screenShG);
        pPress.delay = 0;
        pPress.savingRun = true;
        pPress.paint(screenShG);

        try {
            ImageIO.write(screenshot, "png", screenFile);
            return PattyConsole.BRIGHT_GREEN + "Your pattern was succesfully saved here: " + PattyConsole.GRAY + screenFile.getCanonicalPath() + PattyConsole.RESET + "\n";
        } catch(Exception e) {
            System.out.println("Something went terribly wrong while saving your pattern!");
            e.printStackTrace();
            return "";
        }
    }
}
